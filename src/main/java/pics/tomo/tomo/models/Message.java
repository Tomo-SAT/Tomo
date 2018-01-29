package pics.tomo.tomo.models;

import javax.persistence.*;

@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @Column
    private User creator;

    @ManyToOne
    @Column
    private User recipient;

    @Column
    private String body;



}
