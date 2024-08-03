package uz.pdp.spring_boot_lessons.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/post/creation")
@RequiredArgsConstructor
public class PostCreationController {

    private final PostRepository postRepository;
    private final PostCreationRepository repository;



    @GetMapping("/filter/{userId}")
    public Page<PostProjection> getPostsByUserId(
            @PathVariable(required = false) Integer userId,
            @RequestParam(required = false) String title
    ) {
//        List<Post> allByUserId = repository.findAllByUserId(userId);
//        return repository.findAllByUserIdIn(List.of(userId, 19));
//        return repository.findAllByTitleStartingWith(title);
//        return repository.findAllByTitleIgnoreCaseStartingWith(title);
//        return repository.findAllByTitleContaining(title);
//        return repository.findAllByTitleContainingAndUserIdOrderByCreatedAtDesc(title, userId);
        return repository.findByUserId(userId, PageRequest.of(0, 10));
    }

}
