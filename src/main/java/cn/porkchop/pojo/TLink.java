package cn.porkchop.pojo;

import javax.persistence.*;

@Entity
@Table(name = "t_link", schema = "db_film2")
public class TLink {
    private Integer id;
    private String name;
    private Integer sort;
    private String url;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 500)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sort", nullable = true)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 500)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TLink tLink = (TLink) o;

        if (id != null ? !id.equals(tLink.id) : tLink.id != null) return false;
        if (name != null ? !name.equals(tLink.name) : tLink.name != null) return false;
        if (sort != null ? !sort.equals(tLink.sort) : tLink.sort != null) return false;
        if (url != null ? !url.equals(tLink.url) : tLink.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
