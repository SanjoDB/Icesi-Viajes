package co.edu.icesiviajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "planAndDestination")
public class PlanAndDestination {

    @Id
    @Column(name = "id_pAdt", nullable = false)
    private Integer id_pAdt;
    @Column(name = "destiantion", nullable = false)
    private Destination destiantion;
    @Column(name = "plan", nullable = false)
    private Plan plan;

}
