package cn.porkchop.pojo;

import javax.persistence.*;

@Entity
@Table(name = "t_link")
public class Link {

    // 编号
    @Id
    @GeneratedValue
    private Integer id;

    //  名称
    @Column(length = 500)
    private String name;

    //地址
    @Column(length = 500)
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

