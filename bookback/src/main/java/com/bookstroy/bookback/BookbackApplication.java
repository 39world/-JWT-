package com.bookstroy.bookback;

import com.bookstroy.bookback.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableJpaAuditing
@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class BookbackApplication {

    @PostConstruct
    void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    public static void main(String[] args) {
        SpringApplication.run(BookbackApplication.class, args);
    }

}
