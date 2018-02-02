package pics.tomo.tomo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cons")
public class Con {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date_start;

    @Column(nullable = false)
    private Date date_end;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(nullable = false)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "con")
    private List<ConSchedule> conSchedule;

    public Con(long id, String name, Date date_start, Date date_end, String location, String url, String phone) {
        this.id = id;
        this.name = name;
        this.date_start = date_start;
        this.date_end = date_end;
        this.location = location;
        this.url = url;
        this.phone = phone;
    }

    public Con() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
