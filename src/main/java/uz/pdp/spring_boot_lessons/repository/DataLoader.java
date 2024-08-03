package uz.pdp.spring_boot_lessons.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PostRepository postRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {


        if (postRepository.count() < 10) {
            File file = new File("src/main/resources/static/MOCK_DATA.json");
            TypeReference<List<Post>> POST_REF = new TypeReference<>() {};
            List<Post> posts = objectMapper.readValue(file, POST_REF);
            postRepository.saveAll(posts);
        }

    }
}
