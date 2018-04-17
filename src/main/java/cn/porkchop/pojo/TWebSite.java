package cn.porkchop.pojo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "t_web_site", schema = "db_film2")
public class TWebSite {
    private Integer id;
    private String name;
    private String url;
    private Collection<TInfo> tInfos;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 300)
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

        TWebSite tWebSite = (TWebSite) o;

        if (id != null ? !id.equals(tWebSite.id) : tWebSite.id != null) return false;
        if (name != null ? !name.equals(tWebSite.name) : tWebSite.name != null) return false;
        if (url != null ? !url.equals(tWebSite.url) : tWebSite.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tWebSite")
    public Collection<TInfo> gettInfos() {
        return tInfos;
    }

    public void settInfos(Collection<TInfo> tInfos) {
        this.tInfos = tInfos;
    }
}
