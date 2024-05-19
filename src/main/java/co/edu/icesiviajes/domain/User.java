package co.edu.icesiviajes.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "passw", nullable = false)
    private String password;
    @Column(name = "first_name", nullable = false)
    private String first_name;
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Column(name = "num_id", nullable = false)
    private String num_id;
    @Column(name = "states", nullable = false)
    private String state;

    public User(String login, String password, String first_name, String last_name, String num_id, String state) {
        this.login = login;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.num_id = num_id;
        this.state = "active";
    }

    public User() {

    }
}
