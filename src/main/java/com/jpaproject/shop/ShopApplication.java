package com.jpaproject.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {

        Hello hello = new Hello();
        hello.setAge(10);
        hello.getAge();
        SpringApplication.run(ShopApplication.class, args);
    }

}
