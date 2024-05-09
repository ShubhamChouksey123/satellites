package com.shubham.app.render;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.shubham.app.dto.LauncherDto;
import com.shubham.app.service.LaunchersService;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import static com.shubham.app.controller.LauncherController.ZERO_LENGTH_STRING;

@Service
public class RenderLauncherTemplateImpl implements RenderLauncherTemplate {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private LaunchersService launchersService;

    private List<LauncherDto> getLaunchersShowList(BigInteger startingPage, BigInteger endingPage, BigInteger limit,
            String searchText) {

        BigInteger start = (startingPage).multiply(limit);
        BigInteger totalMaxPossible = ((endingPage.subtract(startingPage)).add(BigInteger.ONE)).multiply(limit);

        return launchersService.getLaunchers(start, totalMaxPossible, searchText);
    }

    @Override
    public void renderAllLaunchers(Model model, BigInteger pageNumber, BigInteger pageSize, String searchText) {

        if (pageNumber == null) {
            pageNumber = BigInteger.ONE;
        }
        if (pageSize == null) {
            pageSize = BigInteger.TEN;
        }

        List<LauncherDto> LauncherDTOs = getLaunchersShowList(pageNumber.subtract(BigInteger.ONE),
                pageNumber.subtract(BigInteger.ONE), pageSize, searchText);

        boolean isThisLastPage = false;
        if (LauncherDTOs.size() < pageSize.intValue()) {
            isThisLastPage = true;
        }

        model.addAttribute("launchers", LauncherDTOs);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("isThisLastPage", isThisLastPage);
        model.addAttribute("searchText", searchText);
    }

    @Override
    public void renderDesiredLauncherEditPage(String launcherId, Model model) {

        LauncherDto launcherDto = null;
        if (launcherId == null || Objects.equals(launcherId, ZERO_LENGTH_STRING)) {
            launcherDto = new LauncherDto(null, "", null, null);
        } else {
            launcherDto = launchersService.getLauncher(launcherId);
        }

        model.addAttribute("launcher", launcherDto);
    }
}
