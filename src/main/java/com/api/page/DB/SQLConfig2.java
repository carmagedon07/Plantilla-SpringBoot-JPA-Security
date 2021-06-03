package com.api.page.DB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "northWindEntityManagerFactory", transactionManagerRef = "northWindTransactionManager", basePackages = {
        "com.api.page.Repository.NorthWind" })
public class SQLConfig2 {


    @Autowired
    private Environment env;


    @Bean(name = "northWindDataSource")
    public DataSource northWindDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("BD2.datasource.url"));
        dataSource.setUsername(env.getProperty("BD2.datasource.username"));
        dataSource.setPassword(env.getProperty("BD2.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("BD2.datasource.driverClassName"));

        return dataSource;
    }


    @Bean(name = "northWindEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(northWindDataSource());
        em.setPackagesToScan("com.api.page.Entities.NorthWind");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.show-sql", env.getProperty("BD2.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("BD2" +
                "" +
                ".jpa.properties.hibernate.dialect"));

        em.setJpaPropertyMap(properties);

        return em;

    }


    @Bean(name = "northWindTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }
}
