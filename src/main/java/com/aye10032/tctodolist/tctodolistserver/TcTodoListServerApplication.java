package com.aye10032.tctodolist.tctodolistserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class TcTodoListServerApplication {

    public static void main(String[] args) {
        // ServerInit.init();
        SpringApplication.run(TcTodoListServerApplication.class, args);
    }

}
