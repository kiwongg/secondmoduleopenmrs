package org.openmrs.module.premium.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "premium_greetings")
public class PremiumGreeting {

    @Id
    @Column(name = "greeting_id", columnDefinition = "CHAR(36)")
    private String greetingId; // References greetings.uuid

    @Column(name = "premium_level")
    private Integer level;

    @Column(name = "is_featured")
    private Boolean featured;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Getters and Setters
    public String getGreetingId() {
        return greetingId;
    }

    public void setGreetingId(String greetingId) {
        this.greetingId = greetingId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}