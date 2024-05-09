package com.shubham.app.render;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.shubham.app.dto.SatelliteDto;
import com.shubham.app.service.SatelliteService;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import static com.shubham.app.controller.LauncherController.ZERO_LENGTH_STRING;

@Service
public class RenderSatelliteTemplateImpl implements RenderSatelliteTemplate {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SatelliteService satelliteService;

    private List<SatelliteDto> getSatelliteShowList(BigInteger startingPage, BigInteger endingPage, BigInteger limit,
            String searchText) {

        BigInteger start = (startingPage).multiply(limit);
        BigInteger totalMaxPossible = ((endingPage.subtract(startingPage)).add(BigInteger.ONE)).multiply(limit);

        return satelliteService.getSatellites(start, totalMaxPossible, searchText);
    }

    @Override
    public void renderAllSatellite(Model model, BigInteger pageNumber, BigInteger pageSize, String searchText) {

        if (pageNumber == null) {
            pageNumber = BigInteger.ONE;
        }
        if (pageSize == null) {
            pageSize = BigInteger.TEN;
        }

        List<SatelliteDto> satelliteDTOs = getSatelliteShowList(pageNumber.subtract(BigInteger.ONE),
                pageNumber.subtract(BigInteger.ONE), pageSize, searchText);

        boolean isThisLastPage = false;
        if (satelliteDTOs.size() < pageSize.intValue()) {
            isThisLastPage = true;
        }

        model.addAttribute("satellites", satelliteDTOs);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("isThisLastPage", isThisLastPage);
        model.addAttribute("searchText", searchText);
    }

    @Override
    public void renderDesiredSatelliteEditPage(String satelliteId, Model model) {

        SatelliteDto satelliteDto = null;
        if (satelliteId == null || Objects.equals(satelliteId, ZERO_LENGTH_STRING)) {
            satelliteDto = new SatelliteDto("", "", null, null, null, null);
            model.addAttribute("isUpdate", 0);
        } else {
            satelliteDto = satelliteService.getSatellite(satelliteId);
            model.addAttribute("isUpdate", 1);
        }

        model.addAttribute("satellite", satelliteDto);
    }
}
