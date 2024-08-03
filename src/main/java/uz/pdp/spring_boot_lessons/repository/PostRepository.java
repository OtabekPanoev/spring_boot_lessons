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

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    // JPQL
    @Query("select p from Post p where p.userId = ?1")
    List<Post> findAllPostsByUserId(Integer userId, Sort sort);

    //NAtive
    @Query(value = "select * from post p where p.user_id = :userId", nativeQuery = true)
    List<Post> findAllPostsByUserIdNative(@Param("userId") Integer user, Pageable pageable);

    @Query("from Post p where p.id = :id")
    Optional<Post> findPostByIdInteger(@Param("id") Integer id);

    @Query("from Post p where p.userId in (:userIds)")
    Page<Post> findAllPostsByUserIdIn(List<Integer> userIds, Pageable pageable);

    @Transactional
    @Modifying
    @Query("delete from Post p where p.userId = :userId")
    void deleteAllByUserId(Integer userId);
}
