package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.domain.Plan;
import co.edu.icesiviajes.dto.PlanDTO;
import co.edu.icesiviajes.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/plans")
public class planController {
    @Autowired
    private PlanService planService;

    @GetMapping(path = "/getPlan")
    public ResponseEntity<List<Plan>> getAllPlansWithImageUrls() {
        List<Plan> plans = planService.findAllPlans();
        System.out.println("ESTA ENTRANDO AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII" + plans);
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }
}
