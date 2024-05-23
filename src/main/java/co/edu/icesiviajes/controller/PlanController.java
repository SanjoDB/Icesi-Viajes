package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.domain.Plan;
import co.edu.icesiviajes.dto.PlanDTO;
import co.edu.icesiviajes.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/plans")
public class planController {
    @Autowired
    private PlanService service;

    @GetMapping(path = "/getPlan")
    public ResponseEntity<List<PlanDTO>> getAllPlansWithImageUrls(@RequestParam(required = false) String word) {
        List<PlanDTO> plans = service.listAll(word);
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

    @RequestMapping("/")
    public String mostrarPlanes(Model modelo, @Param("word") String word){

        List<PlanDTO> listPlans = service.listAll(word);

        modelo.addAttribute("listPlans", listPlans);
        modelo.addAttribute("word", word);

        return "index";
    }

}
