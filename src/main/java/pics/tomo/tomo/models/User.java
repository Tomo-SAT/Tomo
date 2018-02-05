package pics.tomo.tomo.models;

import javax.persistence.*;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Image> images; //but also has a list of images.

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creator")
    private List<Message> messagesSent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipient")
    private List<Message> messagesReceived;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ConSchedule> conSchedule;


    public User() {

    }

    public User(User user) {
        this.id = user.id;
        this.name = user.name;
        this.email = user.email;
        this.password = user.password;
        this.photog = user.photog;
        this.cos = user.cos;
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
