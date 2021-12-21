package com.alpha.practice.restaurant_backend.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

@Configuration
@PropertySource("classpath:configuration.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.alpha.practice.restaurant_backend.daoImpl"),
		@ComponentScan("com.alpha.practice.restaurant_backend.dao"),
		@ComponentScan("com.alpha.practice.restaurant_backend.dto") })
public class HiberConfig {

	@Autowired
	public Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactoryBean() {
		// creating localsessionfactory bean
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		// introducing properties
		Properties props = new Properties();
		// setting jdbc properties
		props.put(DRIVER, env.getProperty("mysql.driver"));
		props.put(URL, env.getProperty("mysql.url"));
		props.put(USER, env.getProperty("mysql.user"));
		props.put(PASS, env.getProperty("mysql.password"));

		// setting hibernate properties
		props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));

		// setting c3p0 properties
		props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
		props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));

		// setting propeties into the hibernate
		factoryBean.setHibernateProperties(props);
		// setting packages to scan for Object Relational Mapping
		factoryBean.setPackagesToScan("com.alpha.practice.restaurant_backend.dto");

		return factoryBean;

	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		// transaction Manager
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		// setting the sessionFactoryBean into the txManager
		txManager.setSessionFactory(getSessionFactoryBean().getObject());
		return txManager;
	}

}
