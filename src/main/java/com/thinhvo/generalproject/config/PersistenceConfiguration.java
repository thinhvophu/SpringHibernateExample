package com.thinhvo.generalproject.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Thinh Vo on 3/8/2016.
 */

//configuration of hibernate && transaction
@EnableTransactionManagement
@Configuration
@PropertySource("classpath:application.properties")
public class PersistenceConfiguration {

    @Autowired
    private Environment en;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(en.getRequiredProperty("db.driver"));
        dataSource.setUrl(en.getRequiredProperty("db.url"));
        dataSource.setUsername(en.getRequiredProperty("db.username"));
        dataSource.setPassword(en.getRequiredProperty("db.password"));
        return dataSource;
    }

    @Bean
    Properties hibernateProperties() {
        Properties hiberProperties = new Properties();
        hiberProperties.setProperty("hibernate.dialect", en.getRequiredProperty("hibernate.dialect"));
        hiberProperties.setProperty("hibernate.show_sql", en.getRequiredProperty("hibernate.show_sql"));
        hiberProperties.setProperty("hibernate.format_sql", en.getRequiredProperty("hibernate.format_sql"));
//        hiberProperties.setProperty("hibernate.hbm2ddl.auto", en.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return hiberProperties;
    }

    @Bean
    LocalSessionFactoryBean sessionFactory(DataSource dataSource, Properties hibernateProperties) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        sessionFactoryBean.setPackagesToScan("com.thinhvo.generalproject");
        return sessionFactoryBean;
    }

    @Bean
    HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }


}
