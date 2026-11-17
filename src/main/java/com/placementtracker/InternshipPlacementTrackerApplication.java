package com.placementtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Main entry point for the Internship and Placement Application Tracker.
 * <p>
 * Architecture Note:
 * DataSourceAutoConfiguration, HibernateJpaAutoConfiguration, and SecurityAutoConfiguration
 * are explicitly excluded at this foundational stage. This allows the application to build,
 * test, and start up cleanly without requiring an active MySQL database connection or
 * enforcing default security credential challenges before those modules are implemented.
 * </p>
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        SecurityAutoConfiguration.class
})
public class InternshipPlacementTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternshipPlacementTrackerApplication.class, args);
    }
}
