package com.shubham.app.hibernate.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shubham.app.entity.Launchers;
import com.shubham.app.entity.Launchers_;
import com.shubham.app.model.LaunchType;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LaunchersDaoImpl implements LaunchersInfoDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    EntityManager em;

    @Override
    public void saveOrUpdate(Launchers launchers) {
        try {
            em.merge(launchers);
        } catch (Exception e) {
            logger.error("Unable to save or update launchers details with {}", launchers);
        }
    }

    @Override
    public Launchers getLauncherById(String launcherId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Launchers> query = cb.createQuery(Launchers.class);
        Root<Launchers> root = query.from(Launchers.class);

        query.select(root);
        query.where(cb.equal(root.get(Launchers_.id), launcherId));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public List<Launchers> getAllLaunchers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Launchers> query = cb.createQuery(Launchers.class);
        Root<Launchers> root = query.from(Launchers.class);

        query.select(root);

        List<Launchers> launchers = null;
        try {
            launchers = em.createQuery(query).getResultList();
        } catch (Exception e) {
            logger.warn("Couldn't find a suitable launcher : {}", e.getMessage());
        }

        return launchers;
    }

    @Override
    public List<Launchers> getLaunchers(BigInteger firstResult, BigInteger maxResults) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Launchers> query = cb.createQuery(Launchers.class);
        Root<Launchers> root = query.from(Launchers.class);

        query.select(root);
        query.orderBy(cb.desc(root.get(Launchers_.createdAt)));

        List<Launchers> launchers = null;
        try {
            launchers = em.createQuery(query).setFirstResult(firstResult.intValue())
                    .setMaxResults(maxResults.intValue()).getResultList();

        } catch (Exception e) {
            logger.warn("Couldn't find a suitable launcher : {}", e.getMessage());
        }

        return launchers;
    }

    @Override
    public List<Launchers> getLaunchers(BigInteger firstResult, BigInteger maxResults, String searchText) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Launchers> query = cb.createQuery(Launchers.class);
        Root<Launchers> root = query.from(Launchers.class);

        query.select(root);

        Predicate searchPredicate = cb.or(cb.like(cb.lower(root.get(Launchers_.id)), "%" + searchText + "%"),
                cb.like(cb.function("lower", String.class, root.get(Launchers_.launchType).as(String.class)),
                        "%" + searchText + "%"),
                cb.like(cb.function("lower", String.class, root.get(Launchers_.registeredOn).as(String.class)),
                        "%" + searchText + "%"));

        query.where(searchPredicate);

        List<Launchers> launchers = null;
        try {
            launchers = em.createQuery(query).setFirstResult(firstResult.intValue())
                    .setMaxResults(maxResults.intValue()).getResultList();

        } catch (Exception e) {
            logger.warn("Couldn't find a suitable launcher : {}", e.getMessage());
        }

        return launchers;
    }

    @Override
    public void updateLauncherData(String launcherId, LaunchType launcherType, Date registeredOn, Long dbId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Launchers> criteria = cb.createCriteriaUpdate(Launchers.class);

        Root<Launchers> root = criteria.from(Launchers.class);

        if (launcherType != null) {
            criteria.set(Launchers_.id, launcherId);
        }
        if (launcherType != null) {
            criteria.set(Launchers_.launchType, launcherType);
        }
        if (registeredOn != null) {
            criteria.set(Launchers_.registeredOn, registeredOn);
        }

        criteria.where(cb.equal(root.get(Launchers_.dbId), dbId));

        em.createQuery(criteria).executeUpdate();
    }

    @Override
    public void deleteLauncher(String launcherId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaDelete<Launchers> criteria = cb.createCriteriaDelete(Launchers.class);
        Root<Launchers> root = criteria.from(Launchers.class);

        Predicate predicateForUserId = cb.equal(root.get(Launchers_.id), launcherId);
        criteria.where(predicateForUserId);

        // perform delete
        em.createQuery(criteria).executeUpdate();
    }
}
