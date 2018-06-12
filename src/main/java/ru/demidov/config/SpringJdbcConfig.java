package ru.demidov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("ru.demidov")
public class SpringJdbcConfig {

    @Bean
    public JdbcTemplate getTemplate() {
        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        driverManager.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        driverManager.setUsername("kaban77");
        driverManager.setPassword("kaban77");

        return new JdbcTemplate(driverManager);
    }
}
