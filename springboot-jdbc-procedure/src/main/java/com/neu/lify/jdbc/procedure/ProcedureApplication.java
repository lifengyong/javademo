package com.neu.lify.jdbc.procedure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcedureApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProcedureApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("start procedure");
    }
}
