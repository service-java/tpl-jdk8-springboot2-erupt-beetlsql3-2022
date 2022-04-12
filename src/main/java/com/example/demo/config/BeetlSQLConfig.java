//package com.example.demo.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//public class BeetlSQLConfig {
//
//    @Bean(name = "ds1")
//    public DataSource getDataSource(Environment env){
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        return dataSource;
//    }
//
//}
