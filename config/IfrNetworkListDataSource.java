package com.example.demo.system.networkassetlist.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager",
        basePackages = { "com.example.demo.system.networkassetlist.infra.repository" }
)
public class IfrNetworkListDataSource {

//	@Autowired
//	private Environment env;

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(primaryDataSource());
        
		//Entity 패키지 경로
        em.setPackagesToScan(new String[] { "com.example.demo.system.networkassetlist.infra.domain" });
	
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
        
        //Hibernate 설정
		HashMap<String, Object> properties = new HashMap<>();
////		properties.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
////		properties.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
		properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.hbm2ddl.auto","none");
		em.setJpaPropertyMap(properties);        

		return em;
	}
	
	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource.postgres")
//	@ConfigurationProperties("spring.datasource")
	public DataSource primaryDataSource() {
//		return DataSourceBuilder.create().build();

		return DataSourceBuilder.create().type(HikariDataSource.class).build();

//        DriverManagerDataSource rcvDataSource = new DriverManagerDataSource();
//
//        
//        rcvDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        rcvDataSource.setUrl("jdbc:oracle:thin:@localhost:1521/ORCL");
//        rcvDataSource.setUsername("sysdate");
//        rcvDataSource.setPassword("Mook@2736");
//     
////		HikariConfig hikariConfig = new HikariConfig();
////		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
////		hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
////		hikariConfig.setUsername("postgres");
////		hikariConfig.setPassword("Mook@2736");
////		//hikariConfig.setMaximumPoolSize(5);
////		//hikariConfig.setConnectionTestQuery("SELECT 1");
////		//hikariConfig.setPoolName("springHikariCP");
////		HikariDataSource sndDataSource = new HikariDataSource(hikariConfig);
//		return rcvDataSource;
		
	}
	
	@Primary
	@Bean
	public PlatformTransactionManager primaryTransactionManager() {	
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(primaryEntityManagerFactory().getObject());
		return transactionManager;
	}
}
