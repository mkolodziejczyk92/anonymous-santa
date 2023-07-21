package io.mkolodziejczyk92.anonymoussanta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class AnonymousSantaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnonymousSantaApplication.class, args);
    }

}
