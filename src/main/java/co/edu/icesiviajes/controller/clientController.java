package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.ClientDTO;
import co.edu.icesiviajes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public class clientController {

    @Autowired
    private ClientService service;

    @GetMapping(path = "/getClient")
    public ResponseEntity<List<ClientDTO>> getAllClientsWithImageUrls(@RequestParam(required = false) String word) {
        List<ClientDTO> clients = service.listAll(word);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

}