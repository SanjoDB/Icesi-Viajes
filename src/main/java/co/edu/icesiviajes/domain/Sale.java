package co.edu.icesiviajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "client", nullable = false)
    private Client client;
    @Column(name = "plan", nullable = false)
    private Plan plan;

}
