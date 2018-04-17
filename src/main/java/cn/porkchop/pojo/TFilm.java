package cn.porkchop.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "t_film", schema = "db_film2")
public class TFilm {
    private Integer id;
    private String content;
    private Integer hot;
    private String imageName;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp publishDate;
    private String title;
    private Collection<TInfo> tInfos;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "hot", nullable = true)
    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    @Basic
    @Column(name = "image_name", nullable = true, length = 300)
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "title", nullable = true, length = 500)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TFilm tFilm = (TFilm) o;

        if (id != null ? !id.equals(tFilm.id) : tFilm.id != null) return false;
        if (content != null ? !content.equals(tFilm.content) : tFilm.content != null) return false;
        if (hot != null ? !hot.equals(tFilm.hot) : tFilm.hot != null) return false;
        if (imageName != null ? !imageName.equals(tFilm.imageName) : tFilm.imageName != null) return false;
        if (name != null ? !name.equals(tFilm.name) : tFilm.name != null) return false;
        if (publishDate != null ? !publishDate.equals(tFilm.publishDate) : tFilm.publishDate != null) return false;
        if (title != null ? !title.equals(tFilm.title) : tFilm.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (hot != null ? hot.hashCode() : 0);
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tFilm")
    public Collection<TInfo> gettInfos() {
        return tInfos;
    }

    public void settInfos(Collection<TInfo> tInfos) {
        this.tInfos = tInfos;
    }
}
