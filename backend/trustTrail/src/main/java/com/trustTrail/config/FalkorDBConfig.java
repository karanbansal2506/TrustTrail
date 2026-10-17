package com.trustTrail.config;

import com.falkordb.Driver;
import com.falkordb.FalkorDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FalkorDBConfig {

    @Bean(destroyMethod = "close")
    public Driver falkorDBDriver() {
        return FalkorDB.driver("localhost", 6379);
    }
}
