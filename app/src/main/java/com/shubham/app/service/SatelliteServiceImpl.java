package com.shubham.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shubham.app.dto.SatelliteDto;
import com.shubham.app.entity.CustomerSatellite;
import com.shubham.app.exception.InvalidParameters;
import com.shubham.app.hibernate.dao.SatelliteInfoDao;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.shubham.app.controller.LauncherController.ZERO_LENGTH_STRING;

@Service
public class SatelliteServiceImpl implements SatelliteService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private SatelliteInfoDao satelliteInfoDao;

    private Date getDate(String dateInString) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return formatter.parse(dateInString);
    }

    public String getDate(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return formatter.format(date);
    }

    private List<SatelliteDto> getCountDtoListFromEntity(List<CustomerSatellite> satellites) {

        List<SatelliteDto> launchersDTOs = new ArrayList<>();

        if (satellites == null) {
            return launchersDTOs;
        }

        satellites.forEach(satellite -> {
            SatelliteDto satelliteDto = new SatelliteDto(satellite.getId(), satellite.getCountry(),
                    getDate(satellite.getLaunchDate()), satellite.getMass(), satellite.getLauncher(),
                    satellite.getCreatedAt());
            launchersDTOs.add(satelliteDto);
        });
        return launchersDTOs;
    }

    @Override
    public List<SatelliteDto> getSatellites(BigInteger firstResult, BigInteger maxResults, String searchText) {

        List<CustomerSatellite> satellites;
        if (searchText != null && !Objects.equals(searchText, ZERO_LENGTH_STRING)) {
            searchText = searchText.toLowerCase();
            satellites = satelliteInfoDao.getCustomerSatellite(firstResult, maxResults, searchText);
        } else {
            satellites = satelliteInfoDao.getCustomerSatellite(firstResult, maxResults);
        }

        return getCountDtoListFromEntity(satellites);
    }

    private void validateParameters(String satelliteIdExisting, String id, String country, String launchDate,
            Double mass, String launcherId) throws InvalidParameters {

        if (satelliteIdExisting == null && id == null) {
            throw new InvalidParameters("satellite Id can't be null");
        }

        if (Objects.equals(id, ZERO_LENGTH_STRING) && Objects.equals(satelliteIdExisting, ZERO_LENGTH_STRING)) {
            throw new InvalidParameters("satellite Id can't be null");
        }

        if (country == null || Objects.equals(country, ZERO_LENGTH_STRING)) {
            throw new InvalidParameters("country can't be null");
        }

        if (launchDate == null) {
            throw new InvalidParameters("launchDate can't be null");
        }

        if (mass == null) {
            throw new InvalidParameters("mass can't be null");
        }

        if (launcherId == null) {
            throw new InvalidParameters("launcherId can't be null");
        }
    }

    @Override
    public void createOrUpdateSatellites(String satelliteIdExisting, String id, String country, String launchDate,
            Double mass, String launcherId, RedirectAttributes redirectAttrs) throws ParseException, InvalidParameters {

        validateParameters(satelliteIdExisting, id, country, launchDate, mass, launcherId);

        /** updating existing launcher */
        if (satelliteIdExisting == null || Objects.equals(satelliteIdExisting, ZERO_LENGTH_STRING)) {
            CustomerSatellite customerSatellite = new CustomerSatellite(id, country, getDate(launchDate), mass,
                    launcherId, new Date());
            satelliteInfoDao.saveOrUpdate(customerSatellite);
            redirectAttrs.addFlashAttribute("successMessage", "Successfully added a new customer satellite with id : "
                    + id + " of country : " + country + " and mass : " + mass);
            return;
        }

        /** adding new launcher */
        logger.info("Updating customer satellite with values as id : {}, country : {}, launchDate : {}, mass : {}",
                satelliteIdExisting, country, launchDate, mass);
        satelliteInfoDao.updateSatelliteData(satelliteIdExisting, country, getDate(launchDate), mass, launcherId);
        redirectAttrs.addFlashAttribute("successMessage", "Successfully updated existing customer satellite with id : "
                + satelliteIdExisting + " of country : " + country);
    }

    @Override
    public SatelliteDto getSatellite(String satelliteId) {

        CustomerSatellite customerSatellite = satelliteInfoDao.getSatelliteById(satelliteId);
        return new SatelliteDto(customerSatellite.getId(), customerSatellite.getCountry(),
                getDate(customerSatellite.getLaunchDate()), customerSatellite.getMass(),
                customerSatellite.getLauncher(), customerSatellite.getCreatedAt());
    }

    @Override
    public void deleteSatellite(String satelliteId) {
        satelliteInfoDao.deleteSatellite(satelliteId);
    }
}
