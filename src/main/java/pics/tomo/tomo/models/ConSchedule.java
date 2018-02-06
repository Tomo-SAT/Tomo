package pics.tomo.tomo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="conSchedule")
public class ConSchedule {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "con_id")
    private Con con;

    @Column(nullable = false)
    private Date start_time;

    @Column(nullable = false)
    private Date end_time;

    public ConSchedule(User user, Con con, Date start_time, Date end_time) {
        this.user = user;
        this.con = con;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Con getCon() {
        return con;
    }

    public void setCon(Con con) {
        this.con = con;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
