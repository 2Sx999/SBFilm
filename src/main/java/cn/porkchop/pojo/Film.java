package cn.porkchop.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_film")
public class Film {

    @Id
    @GeneratedValue
    // 编号
    private Integer id;

    @NotEmpty(message = "请输入您要搜索的电影！")
    @Column(length = 200)
    // 电影名称
    private String name;

    @Column(length = 500)
    // 帖子名称
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    // 帖子内容
    private String content;

    @Column(length = 300)
    // 电影图片
    private String imageName;

    // 是否热门电影 1 热门 0 非热门
    private Integer hot;

    // 发布日期
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}

