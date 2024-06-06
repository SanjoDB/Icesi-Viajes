package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.ClientDTO;
import co.edu.icesiviajes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/clients")
public class ClientRestController {

    @Autowired
    private ClientService service;

    @GetMapping(path = "/getClient")
    public ResponseEntity<List<ClientDTO>> getAllClientsWithImageUrls(@RequestParam(required = false) String word) {
        List<ClientDTO> clients = service.listAll(word);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ClientDTO> createPlan(@RequestBody ClientDTO client) throws Exception {
        service.save(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<String> deletePlan(@RequestBody Integer id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<>("Cliente Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<ClientDTO> updatePlan(@RequestBody ClientDTO client) throws Exception {
        service.update(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}