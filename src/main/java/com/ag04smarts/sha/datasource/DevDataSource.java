package com.ag04smarts.sha.datasource;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class DevDataSource implements Datasource {
    @Override
    public String config() {
        return "Development data source config";
    }
}
