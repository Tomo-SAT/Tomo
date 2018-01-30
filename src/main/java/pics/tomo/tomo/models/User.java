package pics.tomo.tomo.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String bio;

    @Column(nullable = false)
    private boolean photog;

    @Column(nullable = false)
    private boolean cos;

    @OneToMany(mappedBy = "user")
    private List<Image> images; //but also has a list of images.

    @OneToMany
    private List<Message> messages;

    @OneToMany
    private List<ConSchedule> con_schedule;

    @OneToMany()
    public List<Con> cons;


    public User() {
        id = copy.id;
        name = copy.name;
        email = copy.email;
        password = copy.password;
        bio = copy.bio;
        photog = copy.photog;
        cos = copy.cos;
        images = copy.images;
        messages = copy.messages;
        con_schedule = copy.con_schedule;
    }

    public User(long id, String name, String email, String password, boolean photog, boolean cos) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.photog = photog;
        this.cos = cos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isPhotog() {
        return photog;
    }

    public void setPhotog(boolean photog) {
        this.photog = photog;
    }

    public boolean isCos() {
        return cos;
    }

    public void setCos(boolean cos) {
        this.cos = cos;
    }

//    public getProfilePic(){
//        return (featured_picture == true);
//    }
}
