package org.openmrs.module.premium.api.dao;

import org.hibernate.SessionFactory;
import org.openmrs.module.premium.api.model.PremiumGreeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PremiumGreetingDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public PremiumGreeting save(PremiumGreeting premiumGreeting) {
        sessionFactory.getCurrentSession().saveOrUpdate(premiumGreeting);
        return premiumGreeting;
    }

    public PremiumGreeting getByGreetingId(String greetingId) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM PremiumGreeting WHERE greetingId = :id", PremiumGreeting.class)
                .setParameter("id", greetingId)
                .uniqueResult();
    }
}