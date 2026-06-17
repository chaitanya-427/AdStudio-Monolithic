package com.cts.adstudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Single entry point for the AdStudio monolith.
 *
 * <p>All former microservices (iam, advertiser, mediaplan, finance, creative,
 * delivery, notification) now live as sub-packages under {@code com.cts.adstudio}
 * and are picked up by component, entity, and repository scanning from here.</p>
 *
 * <p>{@code @EnableScheduling} is required by the media-plan PacingAlertScheduler.</p>
 */
@SpringBootApplication
@EnableScheduling
public class AdStudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdStudioApplication.class, args);
    }
}
