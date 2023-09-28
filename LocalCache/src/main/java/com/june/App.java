package com.june;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(App.class);
        ConfigurableApplicationContext context = app.run();
        context.close();
        System.out.println( "Application Started!" );
    }
}
