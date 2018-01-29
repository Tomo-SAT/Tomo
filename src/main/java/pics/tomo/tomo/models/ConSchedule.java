package pics.tomo.tomo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="con_schedule")
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
    private LocalDateTime start_time;

    @Column(nullable = false)
    private LocalDateTime end_time;

    public ConSchedule(User user, Con con, LocalDateTime start_time, LocalDateTime end_time) {
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

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }
}
