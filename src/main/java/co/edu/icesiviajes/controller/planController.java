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
public class planController {

    @Autowired
    private PlanService service;

    @GetMapping(path = "/getPlan")
    public ResponseEntity<List<PlanDTO>> getAllPlansWithImageUrls(@RequestParam(required = false) String word) {
        List<PlanDTO> plans = service.listAll(word);
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

}