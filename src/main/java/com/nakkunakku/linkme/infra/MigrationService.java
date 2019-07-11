package com.nakkunakku.linkme.infra;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.flywaydb.core.api.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MigrationService {
    final static Logger logger = LoggerFactory.getLogger(MigrationService.class);
    
    @Autowired
    DataSource dataSource;
    
    @PostConstruct
    public void migrate() {
        logger.info("start for develop web-ca DB migration ..");
        Flyway flyway = new Flyway();
        flyway.setLocations("classpath:db/migration/develop");
        flyway.setDataSource(dataSource);
        flyway.migrate();
        
        // TODO deprecated 돼서 밑에 코드로 해야하는데 dataSource를 못읽음....
//        Flyway flyway = new Flyway(config);
//        Flyway.configure().dataSource(dataSource);
//        Flyway.configure().locations("classpath:db/migration/develop");
//        flyway.migrate();
    }
}
