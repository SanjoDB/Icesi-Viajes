package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.LoginDTO;
import co.edu.icesiviajes.dto.UserDTO;
import co.edu.icesiviajes.response.LoginResponse;

import java.util.Optional;

public interface UserService extends GenericService<UserDTO, Integer>{
    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
}



