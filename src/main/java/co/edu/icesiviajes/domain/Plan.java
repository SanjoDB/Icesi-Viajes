package co.edu.icesiviajes.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "plan")
public class Plan {

    @Id
    @Column(name = "id_plan", nullable = false)
    private Integer id_plan;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "num_people", nullable = false)
    private Integer num_people;
    @Column(name = "start_Date", nullable = false)
    private Date start_Date;
    @Column(name = "end_Date", nullable = false)
    private Date end_Date;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "state", nullable = false)
    private String state;
    @Column(name = "image", nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}