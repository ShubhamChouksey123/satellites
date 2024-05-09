package com.shubham.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shubham.app.dto.LauncherDto;
import com.shubham.app.entity.Launchers;
import com.shubham.app.hibernate.dao.LaunchersInfoDao;
import com.shubham.app.model.LaunchType;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.shubham.app.controller.LauncherController.ZERO_LENGTH_STRING;

@Service
public class LaunchersServiceImpl implements LaunchersService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private LaunchersInfoDao launchersInfoDao;

    private Date getDate(String dateInString) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return formatter.parse(dateInString);
    }

    public String getDate(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return formatter.format(date);
    }

    private List<LauncherDto> getCountDtoListFromEntity(List<Launchers> launchers) {

        List<LauncherDto> launchersDTOs = new ArrayList<>();

        if (launchers == null) {
            return launchersDTOs;
        }

        launchers.forEach(launcher -> {
            LauncherDto launcherDto = new LauncherDto(launcher.getDbId(), launcher.getId(), launcher.getLaunchType(),
                    getDate(launcher.getRegisteredOn()));
            launchersDTOs.add(launcherDto);
        });
        return launchersDTOs;
    }

    @Override
    public List<LauncherDto> getLaunchers(BigInteger firstResult, BigInteger maxResults, String searchText) {

        List<Launchers> launchers;
        if (searchText != null && !Objects.equals(searchText, ZERO_LENGTH_STRING)) {
            searchText = searchText.toLowerCase();
            launchers = launchersInfoDao.getLaunchers(firstResult, maxResults, searchText);
        } else {
            launchers = launchersInfoDao.getLaunchers(firstResult, maxResults);
        }

        return getCountDtoListFromEntity(launchers);
    }

    @Override
    public void createOrUpdateLauncher(String id, LaunchType launcherType, String registeredOn, Long dbId,
            RedirectAttributes redirectAttrs) throws ParseException {

        /** updating existing launcher */
        if (dbId == null) {
            Launchers launcher = new Launchers(id, launcherType, getDate(registeredOn), new Date());
            launchersInfoDao.saveOrUpdate(launcher);
            redirectAttrs.addFlashAttribute("successMessage",
                    "Successfully added a new launcher with id : " + id + " of type : " + launcherType);
            return;
        }

        /** adding new launcher */
        logger.info("Updating launcher with values as id : {}, launcherType : {} and registeredOn : {} and dbId : {}",
                id, launcherType, registeredOn, dbId);
        launchersInfoDao.updateLauncherData(id, launcherType, getDate(registeredOn), dbId);
        redirectAttrs.addFlashAttribute("successMessage",
                "Successfully updated existing launcher with id : " + id + " of type : " + launcherType);
    }

    @Override
    public LauncherDto getLauncher(String launcherId) {

        Launchers launcher = launchersInfoDao.getLauncherById(launcherId);
        return new LauncherDto(launcher.getDbId(), launcher.getId(), launcher.getLaunchType(),
                getDate(launcher.getRegisteredOn()));
    }

    @Override
    public void deleteLauncher(String launcherId) {
        launchersInfoDao.deleteLauncher(launcherId);
    }
}
