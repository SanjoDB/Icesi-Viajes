package co.edu.icesiviajes.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "plan_Destination")
public class Plan_Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pAdt", nullable = false)
    private Integer id_pAdt;

    @ManyToOne
    @JoinColumn(name = "id_destination")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;

}
