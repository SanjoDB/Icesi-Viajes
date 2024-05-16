package co.edu.icesiviajes.dto;

import co.edu.icesiviajes.domain.Client;
import co.edu.icesiviajes.domain.Plan;
import lombok.Data;

import java.util.Date;

@Data
public class SaleDTO {

    private Integer id_sale;
    private Date sold;
    private Integer client;
    private Integer plan;

}
