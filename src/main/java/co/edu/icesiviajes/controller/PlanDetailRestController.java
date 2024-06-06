package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.PlanDetailDTO;
import co.edu.icesiviajes.service.PlanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/plandetails")
public class PlanDetailRestController {

    @Autowired
    PlanDetailService service;

    @GetMapping(path = "/getPlanDetail")
    public ResponseEntity<List<PlanDetailDTO>> getAllPlanDetails() {
        List<PlanDetailDTO> plandetails = service.findAll();
        return new ResponseEntity<>(plandetails, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<PlanDetailDTO> createPlanDetail(@RequestBody PlanDetailDTO plandetail) throws Exception {
        service.save(plandetail);
        return new ResponseEntity<>(plandetail, HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<String> deletePlanDetail(@RequestBody Integer id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<>("Detalle de Plan Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<PlanDetailDTO> updatePlanDetail(@RequestBody PlanDetailDTO plandetail) throws Exception {
        service.update(plandetail);
        return new ResponseEntity<>(plandetail, HttpStatus.OK);
    }

}