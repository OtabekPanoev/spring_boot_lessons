package uz.pdp.spring_boot_lessons.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface PostCreationRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByUserId(Integer userId);

    List<Post> findAllByUserIdIn(Collection<Integer> userId);

    List<Post> findAllByTitleStartingWith(String title);
    List<Post> findAllByTitleIgnoreCaseStartingWith(String title);

    List<Post> findAllByTitleContaining(String title);

    List<Post> findAllByTitleContainingAndUserIdOrderByCreatedAtDesc(String title, Integer userId);


//    @Query("select p.title as title, p.content as content from Post p where p.userId = :userId")
    @Query("""
            select
                p.title as title,
                p.content as content
             from Post p where p.userId = :userId
            """)
    Page<PostProjection> findByUserId(Integer userId, Pageable pageable);

}
