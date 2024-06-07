package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.DestinationDTO;
import co.edu.icesiviajes.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/destinations")
public class DestinationRestController {

    @Autowired
    DestinationService service;

    @GetMapping(path = "/getDestination")
    public ResponseEntity<List<DestinationDTO>> getAllDestinationsWithImageUrls() {
        List<DestinationDTO> destinations = service.findAll();
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<DestinationDTO> createDestination(@RequestBody DestinationDTO destination) throws Exception {
        service.save(destination);
        return new ResponseEntity<>(destination, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteDestination(@PathVariable Integer id) throws Exception {
        DestinationDTO destinationDTO = service.findById(id);
        destinationDTO.setState("Inactive");
        service.update(destinationDTO);
        return new ResponseEntity<>("Destino Eliminado", HttpStatus.OK);
    }


    @PostMapping(path = "/update")
    public ResponseEntity<DestinationDTO> updateDestination(@RequestBody DestinationDTO destination) throws Exception {
        service.update(destination);
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    @GetMapping(value = "/countDestinations")
    public ResponseEntity<Long> numberDestinations(){
        Long destinations = service.count();
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

}