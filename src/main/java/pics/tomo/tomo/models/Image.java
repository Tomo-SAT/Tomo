package pics.tomo.tomo.models;

import javax.persistence.*;

@Entity
@Table(name="images")
public class Image {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String url;


}
