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
    private Double price;
    private String state;
    private Integer client;
    private Integer user;
    private String image;

}