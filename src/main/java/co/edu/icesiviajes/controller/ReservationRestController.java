package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.DestinationDTO;
import co.edu.icesiviajes.dto.ReservationDTO;
import co.edu.icesiviajes.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/reservations")
public class ReservationRestController {

    @Autowired
    ReservationService service;

    @GetMapping(path = "/getReservation")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservations = service.findAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }


    @GetMapping(path = "/getReservationClient")
    public ResponseEntity<List<ReservationDTO>> getAllReservationsByClientId(@RequestBody Integer clientId) {
        List<ReservationDTO> reservations = service.findByClientID(clientId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(path = "/getReservationPlan")
    public ResponseEntity<List<ReservationDTO>> getAllReservationsByPlanId(@RequestBody Integer planId) {
        List<ReservationDTO> reservations = service.findByPlanID(planId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservation) throws Exception {
        service.save(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<String> deleteReservation(@RequestBody Integer id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<>("Reserva Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/deleteClient")
    public ResponseEntity<String> deleteReservationByClientId(@RequestBody Integer clientId) throws Exception {
        service.deleteByClientID(clientId);
        return new ResponseEntity<>("Reserva Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/deletePlan")
    public ResponseEntity<String> deleteReservationByPlanId(@RequestBody Integer planId) throws Exception {
        service.deleteByPlanID(planId);
        return new ResponseEntity<>("Reserva Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationDTO reservation) throws Exception {
        service.update(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

}