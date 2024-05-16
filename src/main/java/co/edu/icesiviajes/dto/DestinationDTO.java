package co.edu.icesiviajes.dto;

import co.edu.icesiviajes.domain.DestinationType;
import lombok.Data;

@Data
public class DestinationDTO {

    private Integer id_destination;
    private String code;
    private String name;
    private String description;
    private String state;
    private Long destinationType;

}
