package org.openmrs.module.premium.web.controller;

import org.openmrs.module.premium.api.service.PremiumGreetingService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/" + RestConstants.VERSION_1 + "/premium-greetings")
public class PremiumGreetingController {

    @Autowired
    private PremiumGreetingService premiumGreetingService;

    @PostMapping
    public ResponseEntity<?> createPremiumGreeting(
            @RequestParam String baseGreetingUuid,
            @RequestParam Integer level,
            @RequestParam Boolean featured) {

        return ResponseEntity.ok(
                premiumGreetingService.createPremiumGreeting(baseGreetingUuid, level, featured)
        );
    }

    @GetMapping("/{greetingUuid}")
    public ResponseEntity<?> getPremiumGreeting(@PathVariable String greetingUuid) {
        return ResponseEntity.ok(
                premiumGreetingService.getPremiumGreeting(greetingUuid)
        );
    }
}