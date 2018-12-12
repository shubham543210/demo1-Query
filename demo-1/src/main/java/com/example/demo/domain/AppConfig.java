package com.example.demo.domain;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.domain")
@EnableAutoConfiguration
@Configuration
public class AppConfig {
	
	
	@Autowired
	private Environment env;
	
	 @Bean(name = "comp", initMethod = "printMe" ,destroyMethod ="printMe")
	    Domain domain(){
	        return new Domain();
	    }
//	 @Bean
//		public DbConnection getDBConnection() {
//			DbConnection dbConnection = new DbConnection();
//			return dbConnection;
//		}
//	 @Bean
//	 public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//	 HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//	 vendorAdapter.setDatabase(Database.MYSQL);
//	 vendorAdapter.setGenerateDdl(true);
//
//	 LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//	 em.setDataSource(dataSource());
//	 em.setPackagesToScan("com.example.demo.beans");
//	 em.setJpaVendorAdapter(vendorAdapter);
//	 em.setJpaProperties(additionalProperties());
//
//	 return em;
//	 }
	 @Bean
	    public EntityManagerFactory entityManagerFactory() {

	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        vendorAdapter.setGenerateDdl(true);
	        vendorAdapter.setShowSql(true);
	        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
	        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	        factory.setJpaVendorAdapter(vendorAdapter);
	        factory.setJpaProperties(getHibernateProperties());
	        factory.setPackagesToScan("com.example.demo.*");
	        factory.setDataSource(dataSource());
	        factory.afterPropertiesSet();
	        return factory.getObject();
	    }


	    @Bean
	    public JpaTransactionManager transactionManager() {
	        JpaTransactionManager txManager = new JpaTransactionManager();
	        txManager.setDataSource(dataSource());
	        txManager.setEntityManagerFactory(entityManagerFactory());
	        return txManager;
	    }

	    Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.ddl-auto", "update");
	        return properties;
	    }
//	 @Bean
//	 public DataSource dataSource() {
//	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	 dataSource.setUrl(env.getProperty("jdbc:mysql://localhost:3307/details1?useSSL=false"));
//	 dataSource.setUsername(env.getProperty("root"));
//	 dataSource.setPassword(env.getProperty("root"));
//	 
//	 return dataSource;
//	 }

	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3307/details1?useSSL=false");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        return dataSource;
	    }


	 @Bean
	 public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	 JpaTransactionManager transactionManager = new JpaTransactionManager();
	 transactionManager.setEntityManagerFactory(emf);

	 return transactionManager;
	 }

	 @Bean
	 public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	 return new PersistenceExceptionTranslationPostProcessor();
	 }

//	 private Properties additionalProperties() {
//	 Properties properties = new Properties();
//	 properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
//	 properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//	 properties.setProperty("hibernate.current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
//	 properties.setProperty("hibernate.jdbc.lob.non_contextual_creation", env.getProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation"));
//	 properties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//	 properties.setProperty("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
//	 return properties;
//	 }
	 
	 
	} 
	// spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
	

