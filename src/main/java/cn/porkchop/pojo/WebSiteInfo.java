package cn.porkchop.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_info")
public class WebSiteInfo {
    // 编号
    @Id
    @GeneratedValue
    private Integer id;
    // 电影
    @ManyToOne
    @JoinColumn(name = "filmId")
    private Film film;
    // 网站
    @ManyToOne
    @JoinColumn(name = "webSiteId")
    private WebSite webSite;
    // 信息
    @Column(length = 1000)
    private String info;
    // 具体网址
    @Column(length = 500)
    private String url;

    // 发布日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public WebSite getWebSite() {
        return webSite;
    }

    public void setWebSite(WebSite webSite) {
        this.webSite = webSite;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}

