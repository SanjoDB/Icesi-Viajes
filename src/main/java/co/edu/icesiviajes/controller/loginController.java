package co.edu.icesiviajes.controller;


import co.edu.icesiviajes.dto.LoginDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.edu.icesiviajes.dto.UserDTO;
import co.edu.icesiviajes.response.LoginResponse;
import co.edu.icesiviajes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class loginController {


    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO){

        String id = userService.addUser(userDTO);
        return id;
    }


    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){

        LoginResponse loginResponse = userService.loginUser(loginDTO);

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping(path = "/getUser")
    public ResponseEntity<List<UserDTO>> getAllUsersWithImageUrls(@RequestParam(required = false) String word) {
        List<UserDTO> users = userService.listAll(word);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}