package co.edu.icesiviajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "identificationType")
public class IdentificationType {

    @Id
    @Column(name = "id_idty", nullable = false)
    private Integer id_idty;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "state", nullable = false)
    private String state;
    //@Column(name = "id_client", nullable = false)
    //private Client id_client;

}
