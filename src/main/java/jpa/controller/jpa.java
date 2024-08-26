package jpa.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class jpa {

    public static void main(String args[]){
        SpringApplication.run(jpa.class, args);
    }

}
