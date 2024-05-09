package com.shubham.app.hibernate.dao;

import com.shubham.app.entity.CustomerSatellite;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface SatelliteInfoDao {

    void saveOrUpdate(CustomerSatellite customerSatellite);

    CustomerSatellite getSatelliteById(String satelliteId);

    List<CustomerSatellite> getAllCustomerSatellite();

    List<CustomerSatellite> getCustomerSatellite(BigInteger firstResult, BigInteger maxResults);

    List<CustomerSatellite> getCustomerSatellite(BigInteger firstResult, BigInteger maxResults, String searchText);

    void updateSatelliteData(String satelliteId, String country, Date launchDate, Double mass, String launcherId);

    void deleteSatellite(String satelliteId);
}
