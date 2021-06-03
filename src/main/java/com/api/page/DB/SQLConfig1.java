package com.api.page.DB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@EnableJpaRepositories(entityManagerFactoryRef = "usuariosEntityManagerFactory", transactionManagerRef = "usuariosTransactionManager", basePackages = {
        "com.api.page.Repository.Usuario" })
public class SQLConfig1 {


    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "usuarioUserDataSource")
    public DataSource usuarioUserDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("BD1.datasource.url"));
        dataSource.setUsername(env.getProperty("BD1.datasource.username"));
        dataSource.setPassword(env.getProperty("BD1.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("BD1.datasource.driverClassName"));

        return dataSource;
    }

    @Primary
    @Bean(name = "usuariosEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(usuarioUserDataSource());
        em.setPackagesToScan("com.api.page.Entities.Usuarios");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.show-sql", env.getProperty("BD1.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("BD1.jpa.properties.hibernate.dialect"));

        em.setJpaPropertyMap(properties);

        return em;

    }

    @Primary
    @Bean(name = "usuariosTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }
}
