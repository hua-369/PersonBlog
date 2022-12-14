package com.huangxuan.dao;

import com.huangxuan.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {
    @Query("select b from Blog b where b.isRecommend=true and b.issue=true ")
    List<Blog> findTop(Pageable pageable);
    @Query("select b from Blog b where b.issue=true and (b.title like ?1 or b.content like ?1)")
    Page<Blog> findByQuery(String query,Pageable pageable);
    @Transactional
    @Modifying
    @Query("update Blog b set b.viewCount=b.viewCount+1 where b.id=?1")
    int updateViews(Long id);
    @Query("select function('date_format',b.updateTime,'%Y') as year from Blog b group by function('date_format',b.updateTime,'%Y') order by year desc ")
    List<String> findGroupYear();

    @Query("select b from Blog b where function('date_format',b.updateTime,'%Y') = ?1 and b.issue=true ")
    List<Blog> findByYear(String year);
    @Query("select b from Blog b where b.issue=true ")
    Page<Blog> findAllByIssue(Pageable pageable);
    @Query("select count(b) from Blog b where b.issue=true ")
    Long countBlogs();
}
