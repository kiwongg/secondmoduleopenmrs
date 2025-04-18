package org.openmrs.module.premium.api.service;

import org.openmrs.api.context.Context;
import org.openmrs.module.helloworld.api.model.Greeting;
import org.openmrs.module.helloworld.api.service.GreetingService;
import org.openmrs.module.premium.api.dao.PremiumGreetingDAO;
import org.openmrs.module.premium.api.model.PremiumGreeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class PremiumGreetingService {

    @Autowired
    private PremiumGreetingDAO premiumGreetingDAO;

    private GreetingService getGreetingService() {
        return Context.getService(GreetingService.class);
    }

    public PremiumGreeting createPremiumGreeting(String baseGreetingUuid, Integer level, Boolean featured) {
        // Get base greeting
        Greeting greeting = getGreetingService().getByUuid(baseGreetingUuid);

        // Create premium version
        PremiumGreeting premiumGreeting = new PremiumGreeting();
        premiumGreeting.setGreetingId(greeting.getUuid());
        premiumGreeting.setLevel(level);
        premiumGreeting.setFeatured(featured);
        premiumGreeting.setCreatedAt(LocalDateTime.now());

        return premiumGreetingDAO.save(premiumGreeting);
    }

    public PremiumGreeting getPremiumGreeting(String greetingUuid) {
        return premiumGreetingDAO.getByGreetingId(greetingUuid);
    }
}