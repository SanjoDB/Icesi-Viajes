package co.edu.icesiviajes.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PlanDTO {

    private Integer id_plan;
    private String code;
    private String name;
    private String description;
    private Integer num_people;
    private Date start_Date;
    private Date end_Date;

    public PlanDTO(String code, String name, String description, Integer num_people, Date start_Date, Date end_Date, Double price, String state, String image) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.num_people = num_people;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
        this.price = price;
        this.state = state;
        this.image = image;
    }

    private Double price;
    private String state;
    private String image;


}