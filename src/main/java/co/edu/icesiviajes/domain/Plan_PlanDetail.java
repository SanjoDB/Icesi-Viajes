package co.edu.icesiviajes.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "plan_PlanDetail")
public class Plan_PlanDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pAd", nullable = false)
    private Integer id_pAd;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "id_planDetail")
    private PlanDetail planDetail;

}
