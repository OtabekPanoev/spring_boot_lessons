package uz.pdp.spring_boot_lessons;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.pdp.spring_boot_lessons.repository.PostRepository;

@SpringBootApplication
public class SpringBootLessonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLessonsApplication.class, args);
	}


//	@Bean
//	public CommandLineRunner commandLineRunner(
//			PostRepository postRepository, ObjectMapper objectMapper
//	) {
//		return args -> {
//
//			System.out.println("Started ------------------");
//
//		};
//	}

}
