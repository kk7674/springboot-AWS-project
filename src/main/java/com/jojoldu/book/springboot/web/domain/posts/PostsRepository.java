package com.jojoldu.book.springboot.web.domain.posts;
import com.jojoldu.book.springboot.web.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("Select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();

}
