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

    public UserDTO(String login, String password, String first_name, String last_name, String num_id) {
        this.login = login;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.num_id = num_id;
    }

}