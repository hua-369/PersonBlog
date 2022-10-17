package com.huangxuan.po;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_blog")
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String headPicture;
    private String mark;
    private Integer viewCount;
    private boolean isAdmire;
    private boolean isCopyright;
    private boolean isComment;
    private boolean isRecommend;
    private boolean issue;
    @Transient
    private String tagIds;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @ManyToOne
    private Type type;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag>tags=new ArrayList<>();
    @ManyToOne
    private User user;
    private String description;
    @OneToMany(mappedBy = "blog")
    private List<Comment>comments=new ArrayList<>();
    public Blog() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public boolean isAdmire() {
        return isAdmire;
    }

    public void setAdmire(boolean admire) {
        isAdmire = admire;
    }

    public boolean isCopyright() {
        return isCopyright;
    }

    public void setCopyright(boolean copyright) {
        isCopyright = copyright;
    }

    public boolean isComment() {
        return isComment;
    }

    public void setComment(boolean comment) {
        isComment = comment;
    }

    public boolean isRecommend() {
        return isRecommend;
    }

    public void setRecommend(boolean recommend) {
        isRecommend = recommend;
    }

    public boolean isIssue() {
        return issue;
    }

    public void setIssue(boolean issue) {
        this.issue = issue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }
    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    //1,2,3
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", headPicture='" + headPicture + '\'' +
                ", mark='" + mark + '\'' +
                ", viewCount=" + viewCount +
                ", isAdmire=" + isAdmire +
                ", isCopyright=" + isCopyright +
                ", isComment=" + isComment +
                ", isRecommend=" + isRecommend +
                ", issue=" + issue +
                ", tagIds='" + tagIds + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", comments=" + comments +
                '}';
    }
}
