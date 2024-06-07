package co.edu.icesiviajes.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "plananddetail")
public class Plan_PlanDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pad", nullable = false)
    private Integer id_pAd;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "plan_detail_id")
    private PlanDetail planDetail;

    public Plan_PlanDetail(Integer id_pAd, Plan plan, PlanDetail planDetail) {
        this.id_pAd = id_pAd;
        this.plan = plan;
        this.planDetail = planDetail;
    }

    public Plan_PlanDetail(){

    }
}
