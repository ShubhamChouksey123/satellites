package com.shubham.app.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shubham.app.dto.SatelliteDto;
import com.shubham.app.exception.InvalidParameters;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

public interface SatelliteService {

    List<SatelliteDto> getSatellites(BigInteger firstResult, BigInteger maxResults, String searchText);

    void createOrUpdateSatellites(String satelliteIdExisting, String satelliteId, String country, String launchDate,
            Double mass, String launcherId, RedirectAttributes redirectAttrs) throws ParseException, InvalidParameters;

    SatelliteDto getSatellite(String satelliteId);

    void deleteSatellite(String satelliteId);
}
