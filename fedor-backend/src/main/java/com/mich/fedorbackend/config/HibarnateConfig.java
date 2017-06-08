package com.mich.fedorbackend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.mich.fedorbackend.dto")
@EnableTransactionManagement
public class HibarnateConfig {
private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/root";
private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
private final static String DATABASE_USERNAME = "root";
private final static String DATABASE_PASSWORD = "123456";
}
