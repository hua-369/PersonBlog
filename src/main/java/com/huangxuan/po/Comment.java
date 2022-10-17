package com.huangxuan.po;

import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;
    private String profilePicture;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @ManyToOne
    private Blog blog;
    @ManyToOne
    private Comment parentComment;
    private boolean adminComment;
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();
    public Comment() {
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public boolean isAdminComment() {
        return adminComment;
    }

    public void setAdminComment(boolean adminComment) {
        this.adminComment = adminComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", blog=" + blog +
                ", parentComment=" + parentComment +
                ", adminComment=" + adminComment +
                ", replyComments=" + replyComments +
                '}';
    }


}
