package co.edu.icesiviajes.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ClientDTO {

    private Integer id_client;
    private String first_name;
    private String last_name;
    private String id_number;
    private String phone;
    private String mail;
    private String Gender;
    private Date birthdate;

}
