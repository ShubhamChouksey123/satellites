package com.shubham.app.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shubham.app.dto.LauncherDto;
import com.shubham.app.model.LaunchType;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

public interface LaunchersService {

    List<LauncherDto> getLaunchers(BigInteger firstResult, BigInteger maxResults, String searchText);

    void createOrUpdateLauncher(String id, LaunchType launcherType, String registeredOn, Long dbId,
            RedirectAttributes redirectAttrs) throws ParseException;

    LauncherDto getLauncher(String launcherId);

    void deleteLauncher(String launcherId);
}
