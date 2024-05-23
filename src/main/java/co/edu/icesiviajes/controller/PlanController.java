package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.PlanDTO;
import co.edu.icesiviajes.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlanController {

    @Autowired
    private PlanService service;

    @RequestMapping("/")
    public String mostrarPlanes(Model modelo, @Param("word") String word){

        List<PlanDTO> listPlans = service.listAll(word);

        modelo.addAttribute("listPlans", listPlans);
        modelo.addAttribute("word", word);

        return "index";
    }

}