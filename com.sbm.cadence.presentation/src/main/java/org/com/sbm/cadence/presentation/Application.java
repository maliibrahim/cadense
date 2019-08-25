package org.com.sbm.cadence.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ComponentScan(basePackages = {
		"org.com.sbm.cadence.presentation",
		"org.com.sbm.cadence.service",
		"org.com.sbm.cadence.common",
		"org.com.sbm.cadence.persistance"})
@EntityScan("org.com.sbm.cadence.common.dto")
@EnableJpaRepositories("org.com.sbm.cadence.persistance.repository")
public class Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
