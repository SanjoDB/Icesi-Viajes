package co.edu.icesiviajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "destinationAndType")
public class DestinationAndType {

    @Id
    @Column(name = "id_dAt", nullable = false)
    private Integer id_dAt;
    @Column(name = "destiantion", nullable = false)
    private Destination destiantion;
    @Column(name = "destinationType", nullable = false)
    private DestinationType destinationType;

}
