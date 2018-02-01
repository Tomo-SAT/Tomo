package pics.tomo.tomo.models;

import javax.persistence.*;

@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn (name = "creator_id")
    private User creator;

    @ManyToOne
    @JoinColumn (name = "recipient_id")
    private User recipient;

    @Column
    private String body;

    @ManyToOne
    @JoinColumn (name = "conSchedule_id")
    private ConSchedule conSchedule;

    public Message(User creator, User recipient, String body, ConSchedule conSchedule) {
        this.creator = creator;
        this.recipient = recipient;
        this.body = body;
        this.conSchedule = conSchedule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ConSchedule getConSchedule() {
        return conSchedule;
    }

    public void setConSchedule(ConSchedule conSchedule) {
        this.conSchedule = conSchedule;
    }
}
