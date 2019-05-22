
package com.example.webservices.consuming;


import com.example.webservices.schema.UserResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "9999");
        SpringApplication.run(ConsumingApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(UserClient quoteClient) {
        return args -> {
            UserResponse response = quoteClient.getUsers();
            System.out.println(response.getUser().getResponseMsg());
        };
    }

}
