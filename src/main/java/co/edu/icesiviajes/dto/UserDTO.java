package co.edu.icesiviajes.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Integer id_user;
    private String login;
    private String password;
    private String first_name;
    private String last_name;
    private String num_id;
    private String state;

}