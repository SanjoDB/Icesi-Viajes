package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.PlanDTO;
import co.edu.icesiviajes.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PostMapping(path = "/delete")
    public ResponseEntity<String> deletePlan(@RequestBody Integer id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<>("Plan Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<PlanDTO> updatePlan(@RequestBody PlanDTO plan) throws Exception {
        service.update(plan);
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }

}