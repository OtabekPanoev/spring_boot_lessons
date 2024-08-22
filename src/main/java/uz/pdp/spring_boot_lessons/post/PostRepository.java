package uz.pdp.spring_boot_lessons.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot_lessons.comment.Comment;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
