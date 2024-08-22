package uz.pdp.spring_boot_lessons.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot_lessons.post.Post;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
