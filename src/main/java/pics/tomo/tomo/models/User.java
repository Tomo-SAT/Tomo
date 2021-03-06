package pics.tomo.tomo.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true, length = 1000)
    @Size(max =  1000)
    private String bio;

    @Column(nullable = false)
    private boolean photog;

    @Column(nullable = false)
    private boolean cos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Con> cons;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Image> images; //but also has a list of images.

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creator")
    private List<Message> messagesSent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipient")
    private List<Message> messagesReceived;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creator")
    private List<ConSchedule> conSchedule;

    private String profilePicture;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public User() {

    }

    public User(User user) {
        this.id = user.id;
        this.name = user.name;
        this.email = user.email;
        this.password = user.password;
        this.photog = user.photog;
        this.cos = user.cos;
        this.bio = user.bio;
        this.profilePicture = user.profilePicture;
        this.cons = user.cons;
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

    public boolean isPhotog() { return photog; }

    public void setPhotog(boolean photog) {
        this.photog = photog;
    }

    public boolean isCos() {
        return cos;
    }

    public void setCos(boolean cos) {
        this.cos = cos;
    }

    public List<Con> getCons() {
        return cons;
    }

    public void setCons(List<Con> cons) {
        this.cons = cons;
    }

//    public getProfilePic(){
//        return (featured_picture == true);
//    }

    public static String translatePhotog(boolean photog) {
        return photog ? "Yes" : "No";
    }

    public static String translateCos(boolean cos) {
        return cos ? "Yes" : "No";
    }
}
