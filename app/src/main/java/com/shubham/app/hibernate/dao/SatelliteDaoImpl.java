package com.shubham.app.hibernate.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shubham.app.entity.CustomerSatellite;
import com.shubham.app.entity.CustomerSatellite_;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SatelliteDaoImpl implements SatelliteInfoDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    EntityManager em;

    @Override
    public void saveOrUpdate(CustomerSatellite customerSatellite) {
        try {
            em.merge(customerSatellite);
        } catch (Exception e) {
            logger.error("Unable to save or update customer satellite details with {}", customerSatellite);
        }
    }

    @Override
    public CustomerSatellite getSatelliteById(String satelliteId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerSatellite> query = cb.createQuery(CustomerSatellite.class);
        Root<CustomerSatellite> root = query.from(CustomerSatellite.class);

        query.select(root);
        query.where(cb.equal(root.get(CustomerSatellite_.id), satelliteId));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public List<CustomerSatellite> getAllCustomerSatellite() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerSatellite> query = cb.createQuery(CustomerSatellite.class);
        Root<CustomerSatellite> root = query.from(CustomerSatellite.class);

        query.select(root);

        List<CustomerSatellite> CustomerSatellite = null;
        try {
            CustomerSatellite = em.createQuery(query).getResultList();
        } catch (Exception e) {
            logger.warn("Couldn't find a suitable launcher : {}", e.getMessage());
        }

        return CustomerSatellite;
    }

    @Override
    public List<CustomerSatellite> getCustomerSatellite(BigInteger firstResult, BigInteger maxResults) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerSatellite> query = cb.createQuery(CustomerSatellite.class);
        Root<CustomerSatellite> root = query.from(CustomerSatellite.class);

        query.select(root);
        query.orderBy(cb.desc(root.get(CustomerSatellite_.createdAt)));

        List<CustomerSatellite> CustomerSatellite = null;
        try {
            CustomerSatellite = em.createQuery(query).setFirstResult(firstResult.intValue())
                    .setMaxResults(maxResults.intValue()).getResultList();

        } catch (Exception e) {
            logger.warn("Couldn't find a suitable launcher : {}", e.getMessage());
        }

        return CustomerSatellite;
    }

    @Override
    public List<CustomerSatellite> getCustomerSatellite(BigInteger firstResult, BigInteger maxResults,
            String searchText) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerSatellite> query = cb.createQuery(CustomerSatellite.class);
        Root<CustomerSatellite> root = query.from(CustomerSatellite.class);

        query.select(root);

        Predicate searchPredicate = cb.or(cb.like(cb.lower(root.get(CustomerSatellite_.id)), "%" + searchText + "%"),
                cb.like(cb.lower(root.get(CustomerSatellite_.country)), "%" + searchText + "%"),
                cb.like(cb.function("lower", String.class, root.get(CustomerSatellite_.launchDate).as(String.class)),
                        "%" + searchText + "%"),
                cb.like(cb.function("lower", String.class, root.get(CustomerSatellite_.mass).as(String.class)),
                        "%" + searchText + "%"),
                cb.like(cb.lower(root.get(CustomerSatellite_.launcher)), "%" + searchText + "%"));

        query.where(searchPredicate);

        List<CustomerSatellite> CustomerSatellite = null;
        try {
            CustomerSatellite = em.createQuery(query).setFirstResult(firstResult.intValue())
                    .setMaxResults(maxResults.intValue()).getResultList();

        } catch (Exception e) {
            logger.warn("Couldn't find a suitable launcher : {}", e.getMessage());
        }

        return CustomerSatellite;
    }

    @Override
    public void updateSatelliteData(String satelliteId, String country, Date launchDate, Double mass,
            String launcherId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<CustomerSatellite> criteria = cb.createCriteriaUpdate(CustomerSatellite.class);

        Root<CustomerSatellite> root = criteria.from(CustomerSatellite.class);

        if (country != null) {
            criteria.set(CustomerSatellite_.country, country);
        }
        if (launchDate != null) {
            criteria.set(CustomerSatellite_.launchDate, launchDate);
        }
        if (mass != null) {
            criteria.set(CustomerSatellite_.mass, mass);
        }
        if (launcherId != null) {
            criteria.set(CustomerSatellite_.launcher, launcherId);
        }

        criteria.where(cb.equal(root.get(CustomerSatellite_.id), satelliteId));

        em.createQuery(criteria).executeUpdate();
    }

    @Override
    public void deleteSatellite(String launcherId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaDelete<CustomerSatellite> criteria = cb.createCriteriaDelete(CustomerSatellite.class);
        Root<CustomerSatellite> root = criteria.from(CustomerSatellite.class);

        Predicate predicateForUserId = cb.equal(root.get(CustomerSatellite_.id), launcherId);
        criteria.where(predicateForUserId);

        // perform delete
        em.createQuery(criteria).executeUpdate();
    }
}
