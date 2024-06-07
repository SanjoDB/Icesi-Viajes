package co.edu.icesiviajes.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "plandetail")
public class PlanDetail {

    @Id
    @Column(name = "id_plandetail", nullable = false)
    private Integer id_planDetail;
    @Column(name = "nutrition", nullable = false)
    private String nutrition;
    @Column(name = "lodging", nullable = false)
    private String lodging;
    @Column(name = "transportation", nullable = false)
    private String transportation;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "num_nights", nullable = false)
    private Integer num_nights;
    @Column(name = "num_days", nullable = false)
    private Integer num_days;
    @Column(name = "state", nullable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public PlanDetail(Integer id_planDetail, String nutrition, String lodging, String transportation, Double price, Integer num_nights, Integer num_days, String state, Destination destination) {
        this.id_planDetail = id_planDetail;
        this.nutrition = nutrition;
        this.lodging = lodging;
        this.transportation = transportation;
        this.price = price;
        this.num_nights = num_nights;
        this.num_days = num_days;
        this.state = state;
        this.destination = destination;
    }

    public PlanDetail(){

    }
}
