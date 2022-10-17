package com.huangxuan.web;

import com.huangxuan.po.Comment;
import com.huangxuan.po.User;
import com.huangxuan.service.BlogService;
import com.huangxuan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    @Value("${comment.profilePicture}")
    private String profilePicture;
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        Long blogId=comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        User user= (User) session.getAttribute("user");
        if (user!=null){
            comment.setProfilePicture(user.getProfilePicture());
            comment.setAdminComment(true);
        }else {
            comment.setProfilePicture(profilePicture);
            comment.setAdminComment(false);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/"+blogId;
    }
}
