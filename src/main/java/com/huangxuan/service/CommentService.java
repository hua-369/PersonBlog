package com.huangxuan.service;

import com.huangxuan.po.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);
    Comment saveComment(Comment comment);
}
