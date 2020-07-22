package com.ag04smarts.sha.datasource;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class ProdDataSource implements Datasource {
    @Override
    public String config() {
        return "Production data source config";
    }
}
