package co.edu.icesiviajes.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "id_reservation", nullable = false)
    private Integer id_reservation;
    @Column(name = "reserved", nullable = false)
    private Date reserved;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;

}
