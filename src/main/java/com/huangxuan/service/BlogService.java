package com.huangxuan.service;

import com.huangxuan.po.Blog;
import com.huangxuan.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {
    Blog saveBlog(Blog blog);
    void deleteBlog(Long id);
    Blog updateBlog(Long id,Blog blog);
    Blog getBlog(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(Long tagId,Pageable pageable);
    List<Blog> listRecommendBlogTop(Integer size);
    Page<Blog> listBlog(String query,Pageable pageable);
    Blog getAndConvert(Long id);
    Map<String,List<Blog>> archiveBlog();
    Long countBlog();
}
