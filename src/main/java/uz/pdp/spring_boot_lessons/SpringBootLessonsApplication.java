package uz.pdp.spring_boot_lessons;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.pdp.spring_boot_lessons.comment.Comment;
import uz.pdp.spring_boot_lessons.comment.CommentRepository;
import uz.pdp.spring_boot_lessons.post.Post;
import uz.pdp.spring_boot_lessons.post.PostRepository;
import uz.pdp.spring_boot_lessons.todo.Todo;
import uz.pdp.spring_boot_lessons.todo.TodoRepository;

import java.net.URL;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class SpringBootLessonsApplication {

	private final TodoRepository todoRepository;
	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;

    public SpringBootLessonsApplication(TodoRepository todoRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.todoRepository = todoRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringBootLessonsApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			if (Objects.equals(ddl, "create")) {
				ObjectMapper objectMapper = new ObjectMapper();

				List<Todo> todos = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos"), new TypeReference<List<Todo>>() {
				});

				List<Post> posts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<List<Post>>() {
				});

				List<Comment> comments = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/comments"), new TypeReference<List<Comment>>() {
				});

				todoRepository.saveAll(todos);
				postRepository.saveAll(posts);
				commentRepository.saveAll(comments);
			}


		};
	}

}
