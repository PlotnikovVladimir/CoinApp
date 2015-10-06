package com.test;

import com.test.dto.*;
import com.test.entity.*;
import ma.glasnost.orika.*;
import ma.glasnost.orika.impl.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.annotation.*;

import javax.persistence.*;
import java.io.*;

@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories("com.test.repository")
@EnableTransactionManagement
@SpringBootApplication
public class CoinApplication {

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }


    @Bean
    public MapperFacade mapper() {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Coin.class, CoinDTO.class).field("category.id", "category")
                .byDefault().register();
        mapperFactory.classMap(Category.class, CategoryDTO.class)
                .byDefault().register();
        mapperFactory.classMap(User.class, UserDTO.class)
                .byDefault().register();
        mapperFactory.classMap(CoinRequest.class, CoinDTO.class)
                .byDefault().register();
        return mapperFactory.getMapperFacade();
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CoinApplication.class, args);
    }


}
