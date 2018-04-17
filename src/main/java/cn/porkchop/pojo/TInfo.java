package cn.porkchop.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_info", schema = "db_film2")
public class TInfo {
    private Integer id;
    private String info;
    private Timestamp publishDate;
    private String url;
    private TFilm tFilm;
    private TWebSite tWebSite;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "info", nullable = true, length = 1000)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "publish_date", nullable = true)
    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
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

        TInfo tInfo = (TInfo) o;

        if (id != null ? !id.equals(tInfo.id) : tInfo.id != null) return false;
        if (info != null ? !info.equals(tInfo.info) : tInfo.info != null) return false;
        if (publishDate != null ? !publishDate.equals(tInfo.publishDate) : tInfo.publishDate != null) return false;
        if (url != null ? !url.equals(tInfo.url) : tInfo.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    public TFilm gettFilm() {
        return tFilm;
    }

    public void settFilm(TFilm tFilm) {
        this.tFilm = tFilm;
    }

    @ManyToOne
    @JoinColumn(name = "web_site_id", referencedColumnName = "id")
    public TWebSite gettWebSite() {
        return tWebSite;
    }

    public void settWebSite(TWebSite tWebSite) {
        this.tWebSite = tWebSite;
    }
}
