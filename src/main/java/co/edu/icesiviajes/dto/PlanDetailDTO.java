package co.edu.icesiviajes.dto;

import co.edu.icesiviajes.domain.Destination;
import co.edu.icesiviajes.domain.Plan;
import lombok.Data;

import java.util.Date;

@Data
public class PlanDetailDTO {

    private Integer id_planDetail;
    private String nutrition;
    private String lodging;
    private String transportation;
    private Date transfer;
    private Double price;
    private Integer num_nights;
    private Integer num_days;
    private String state;
    private Long destination;

}
