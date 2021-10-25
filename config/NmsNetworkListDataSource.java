package com.example.demo.system.networkassetlist.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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

@Configuration
@EnableTransactionManagement
//@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager",
        basePackages = { "com.example.demo.system.networkassetlist.nms.repository" }
)
public class NmsNetworkListDataSource {
	
//	@Autowired
//	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(secondDataSource());
		em.setPackagesToScan(new String[] { "com.example.demo.system.networkassetlist.nms.domain" });
		

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		HashMap<String, Object> properties = new HashMap<>();
////		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
////		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", "none");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean
	@ConfigurationProperties("spring.datasource.oracle")
	public DataSource secondDataSource() {
//		return DataSourceBuilder.create().build();
		return DataSourceBuilder.create().type(HikariDataSource.class).build();

//		DriverManagerDataSource sndDataSource = new DriverManagerDataSource();
////		sndDataSource = DataSourceBuilder.create().build();
////		return DataSourceBuilder.create().driverClassName("oracle.jdbc.driver.OracleDriver").url("jdbc:oracle:thin:@localhost:1521/ORCL").username("system").password("Mook@2736").build();
//        sndDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
////        sndDataSource.
//        sndDataSource.setUrl("jdbc:oracle:thin:@localhost:1521/ORCL");
//        sndDataSource.setUsername("sysdate");
//        sndDataSource.setPassword("Mook@2736");
//        
////		HikariConfig hikariConfig = new HikariConfig();
////		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
////		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/ORCL");
////		hikariConfig.setUsername("sysdate");
////		hikariConfig.setPassword("Mook@2736");
////		//hikariConfig.setMaximumPoolSize(5);
////		//hikariConfig.setConnectionTestQuery("SELECT 1");
////		//hikariConfig.setPoolName("springHikariCP");
////		HikariDataSource sndDataSource = new HikariDataSource(hikariConfig);
//		return sndDataSource;

                

	}

	@Bean
	public PlatformTransactionManager secondaryTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(secondaryEntityManagerFactory().getObject());
		return transactionManager;
	}
}
