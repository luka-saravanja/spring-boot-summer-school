package com.ag04smarts.sha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicConfig {

    private ClinicName clinicName;

    @Bean
    public ClinicName getClinicName(@Value("${clinic.name}") String clinicName) {
        return () -> clinicName;
    }


}
