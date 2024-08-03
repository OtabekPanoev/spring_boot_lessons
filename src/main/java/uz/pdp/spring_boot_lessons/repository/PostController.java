package uz.pdp.spring_boot_lessons.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
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
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/all")
    public List<Post> getPosts() {
        Sort sort = Sort
                .by(Sort.Direction.DESC, "userId")
                .and(Sort.by(Sort.Direction.ASC, "id"));
        return postRepository.findAll(sort);
    }

    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create(@RequestBody Post post) {
        System.out.println("Before : " + post.getId());

        post = postRepository.save(post);

        System.out.println("After : " + post.getId());
//        return new ResponseEntity<>(HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/filter/{userId}")
    public List<Post> getPostsByUserId(
            @PathVariable Integer userId
    ) {

//        Sort sort = Sort.by(Sort.Direction.ASC, "id");

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "body"));

        return postRepository.findAllPostsByUserId(userId, Sort.by(Sort.Direction.ASC, "content"));
//        return postRepository.findAllPostsByUserIdNative(userId, pageable);
    }

    @GetMapping("/paged")
    public Page<Post> getPostsByUserIdPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int count
    ) {

        Sort sort = Sort.by(Sort.Direction.DESC, "title");

        PageRequest pageable = PageRequest.of(page , count, sort);
//        PageRequest pageable = PageRequest.of(page , count);

//        pageable.withSort(sort);

        Page<Post> all = postRepository.findAll(pageable);
        return all;
    }

    @GetMapping("/{id}")
    public Post getPostsByUserIdPaged(@PathVariable Integer id){

//        return postRepository.findById(id)
//                .orElseThrow(NoSuchElementException::new);

        return postRepository.findPostByIdInteger(id)
                .orElseThrow(NoSuchElementException::new);
    }


    @GetMapping("/filter/in/{userIds}")
    public Page<Post> getPostsByUserIds(
            @PathVariable List<Integer> userIds
    ) {

        return postRepository.findAllPostsByUserIdIn(userIds, PageRequest.of(0, 10));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/user/{userId}")
    public ResponseEntity<Void> deleteAllByUserId(@PathVariable Integer userId) {
        postRepository.deleteAllByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}
