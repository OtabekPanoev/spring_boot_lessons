package uz.pdp.spring_boot_lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootLessonsApplication {

    public static void main(String[] args) {
		SpringApplication.run(SpringBootLessonsApplication.class, args);
	}

}
