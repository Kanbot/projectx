package com.jojoldu.book.spring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT x FROM Posts x ORDER BY x.id DESC")
    List<Posts> findAllDesc();
    @Query("SELECT x FROM Posts x where category = x.category")
    List<Posts> findAll(String category);
    @Modifying
    @Query("UPDATE Posts x set content = content || '경고! 내용을 수정하시기 바랍니다.' where id =x.id")
    void revise(Long id);
    @Query(value = "select  * from posts where title like '%?1%' or content like '%?1%' or author like '%?1%'", nativeQuery = true)
    List<Posts> search(String search);

}
