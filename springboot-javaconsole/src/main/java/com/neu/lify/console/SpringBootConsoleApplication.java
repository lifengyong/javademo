package com.neu.lify.console;

import com.neu.lify.console.apple.RedApple;
import com.neu.lify.console.orange.BigOrange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private RedApple apple;
    @Autowired
    private BigOrange orange;

    public static void main(String[] args) throws Exception {

        SpringApplication.run(SpringBootConsoleApplication.class, args);

    }

    @Override
    public void run(String... args) {
        String s = "spring boot start";
        System.out.println(s);
        System.out.println(apple.getAppleColor());

        System.out.println(orange.getOrangeColor());
    }
}
