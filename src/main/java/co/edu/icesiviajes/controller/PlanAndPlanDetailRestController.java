package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.Plan_PlanDetailDTO;
import co.edu.icesiviajes.service.Plan_PlanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/planAndplandetail")
public class PlanAndPlanDetailRestController {

    @Autowired
    Plan_PlanDetailService service;

    @GetMapping(path = "/getpAdPlan")
    public ResponseEntity<List<Plan_PlanDetailDTO>> getAllpAdsByPlanId(@RequestBody Integer planId) {
        List<Plan_PlanDetailDTO> pAds = service.findByPlanId_plan(planId);
        return new ResponseEntity<>(pAds, HttpStatus.OK);
    }

    @GetMapping(path = "/getpAdPlanDetail")
    public ResponseEntity<List<Plan_PlanDetailDTO>> getAllpAdsByPlanDetailId(@RequestBody Integer planDetailId) {
        List<Plan_PlanDetailDTO> pAds = service.findByPlanDetailId_planDetail(planDetailId);
        return new ResponseEntity<>(pAds, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Plan_PlanDetailDTO> createPlanAndPlanDetail(@RequestBody Plan_PlanDetailDTO plan_plandetail) throws Exception {
        System.out.println("ESTE ES EL PLAN Y EL DETALLE DEL PLAN: " + plan_plandetail);
        service.save(plan_plandetail);
        return new ResponseEntity<>(plan_plandetail, HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<String> deletePlanAndPlanDetail(@RequestBody Integer id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<>("Plan y Plan Detalle Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/deletePlan")
    public ResponseEntity<String> deletepAdsByPlanId(@RequestBody Integer planId) throws Exception {
        service.deleteByPlanId_plan(planId);
        return new ResponseEntity<>("Plan y Plan Detalle Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/deletePlanDetail")
    public ResponseEntity<String> deletepAdsByPlanDetailId(@RequestBody Integer planDetailId) throws Exception {
        service.deleteByPlanDetailId_planDetail(planDetailId);
        return new ResponseEntity<>("Plan y Plan Detalle Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<Plan_PlanDetailDTO> updatePlanAndPlanDetail(@RequestBody Plan_PlanDetailDTO plan_plandetail) throws Exception {
        service.update(plan_plandetail);
        return new ResponseEntity<>(plan_plandetail, HttpStatus.OK);
    }

}