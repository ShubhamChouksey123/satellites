package com.shubham.app.hibernate.dao;

import com.shubham.app.entity.Launchers;
import com.shubham.app.model.LaunchType;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface LaunchersInfoDao {

    void saveOrUpdate(Launchers launchers);

    Launchers getLauncherById(String launcherId);

    List<Launchers> getAllLaunchers();

    List<Launchers> getLaunchers(BigInteger firstResult, BigInteger maxResults);

    List<Launchers> getLaunchers(BigInteger firstResult, BigInteger maxResults, String searchText);

    void updateLauncherData(String id, LaunchType launcherType, Date registeredOn, Long dbId);

    void deleteLauncher(String launcherId);
}
