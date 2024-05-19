package co.edu.icesiviajes.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "sale")
public class Sale {

    @Id
    @Column(name = "id_sale", nullable = false)
    private Integer id_sale;
    @Column(name = "sold", nullable = false)
    private Date sold;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;

}
