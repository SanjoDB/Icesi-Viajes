package co.edu.icesiviajes.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "destination_DestinationType")
public class Destination_DestinationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dAt", nullable = false)
    private Integer id_dAt;

    @ManyToOne
    @JoinColumn(name = "id_destination")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "id_desType")
    private DestinationType destinationType;

}
