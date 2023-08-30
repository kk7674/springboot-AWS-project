package com.jojoldu.book.springboot.web.domain.posts;
import com.jojoldu.book.springboot.web.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
}
