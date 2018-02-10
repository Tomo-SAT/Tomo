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
    @JoinColumn (name = "creator_id")
    private User creator;

    @ManyToOne
    @JoinColumn (name = "recipient_id")
    private User recipient;

    @ManyToOne
    @JoinColumn (name = "con_id")
    private Con con;

    @Column(nullable = false)
    private String  time;

    @Column(nullable = false)
    private String day;

    public ConSchedule(User user, Con con, String time, String day) {
        this.creator = user;
        this.con = con;
        this.time = time;
        this.day = day;
    }

    public ConSchedule(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User user) {
        this.creator = user;
    }

    public User getRecipient(User user) {return this.recipient;}

    public void setRecipient(User user) {this.recipient = user;}

    public Con getCon() {
        return con;
    }

    public void setCon(Con con) {
        this.con = con;
    }

    public String  getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
