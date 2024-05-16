package co.edu.icesiviajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "client", nullable = false)
    private Client client;
    @Column(name = "plan", nullable = false)
    private Plan plan;

}
