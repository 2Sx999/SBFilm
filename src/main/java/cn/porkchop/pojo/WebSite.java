package cn.porkchop.pojo;

import javax.persistence.*;

@Entity
@Table(name = "t_webSite")
public class WebSite {
    // 编号
    @Id
    @GeneratedValue
    private Integer id;
    // 网站地址
    @Column(length = 300)
    private String url;
    // 网站名称
    @Column(length = 100)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

