package co.edu.icesiviajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "planAndDetail")
public class PlanAndDetail {

    @Id
    @Column(name = "id_pAd", nullable = false)
    private Integer id_pAd;
    @Column(name = "plan", nullable = false)
    private Plan plan;
    @Column(name = "planDetail", nullable = false)
    private PlanDetail planDetail;

}
