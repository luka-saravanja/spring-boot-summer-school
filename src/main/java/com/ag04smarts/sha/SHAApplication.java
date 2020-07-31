package com.ag04smarts.sha;


import javax.annotation.PostConstruct;

import com.ag04smarts.sha.datasource.Datasource;
import com.ag04smarts.sha.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ag04smarts.sha.utils.PatientDummyData;


@SpringBootApplication
public class SHAApplication {

    @Autowired
    Datasource datasource;
    @Autowired
    private PatientService patientService;

    @PostConstruct
    public void init() {
        PatientDummyData.loadData().forEach(p -> patientService.insert(p));
        System.out.println(datasource.config());
    }

    public static void main(String[] args) {
        SpringApplication.run(SHAApplication.class, args);
    }
}
