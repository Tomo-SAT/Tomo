package pics.tomo.tomo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="cons")
public class Con {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String location;


}
