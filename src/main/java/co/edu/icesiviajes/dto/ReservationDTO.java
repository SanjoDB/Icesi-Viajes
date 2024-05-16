package co.edu.icesiviajes.dto;

import co.edu.icesiviajes.domain.Client;
import co.edu.icesiviajes.domain.Plan;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDTO {

    private Integer id_reservation;
    private Date reserved;
    private Long client;
    private Long plan;

}
