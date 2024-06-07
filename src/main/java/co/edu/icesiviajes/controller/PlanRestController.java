package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.DestinationDTO;
import co.edu.icesiviajes.dto.PlanDTO;
import co.edu.icesiviajes.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/plans")
public class PlanRestController {

    @Autowired
    PlanService service;

    @GetMapping(path = "/getPlan")
    public ResponseEntity<List<PlanDTO>> getAllPlansWithImageUrls(@RequestParam(required = false) String word) {
        List<PlanDTO> plans = service.listAll(word);
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<PlanDTO> createPlan(@RequestBody PlanDTO plan) throws Exception {
        service.save(plan);
        return new ResponseEntity<>(plan, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteDestination(@PathVariable Integer id) throws Exception {
        PlanDTO planDTO = service.findById(id);
        planDTO.setState("Inactive");
        service.update(planDTO);
        return new ResponseEntity<>("Destino Eliminado", HttpStatus.OK);
    }


    @PostMapping(path = "/update")
    public ResponseEntity<PlanDTO> updatePlan(@RequestBody PlanDTO plan) throws Exception {
        service.update(plan);
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }

    @GetMapping(value = "/countPlans")
    public ResponseEntity<Long> numberPlans(){
        Long plans = service.count();
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

}