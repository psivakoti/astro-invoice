package com.galvanize.dock_sandwich;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.DatabaseStartupValidator;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.stream.Stream;

@Configuration
public class DatabaseStartup {

  @Bean
  public DatabaseStartupValidator databaseStartupValidator(DataSource dataSource) {
    var validator = new DatabaseStartupValidator();
    validator.setDataSource(dataSource);
    validator.setValidationQuery(DatabaseDriver.MYSQL.getValidationQuery());
    return validator;
  }

  @Bean
  public static BeanFactoryPostProcessor dependsOnPostProcessor() {
    return beanFactory -> {
      String[] jpa = beanFactory.getBeanNamesForType(EntityManagerFactory.class);
      Stream.of(jpa)
        .map(beanFactory::getBeanDefinition)
        .forEach(it -> it.setDependsOn("databaseStartupValidator"));
    };
  }

}
