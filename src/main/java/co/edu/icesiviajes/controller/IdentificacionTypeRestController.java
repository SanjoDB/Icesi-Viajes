package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.IdentificationTypeDTO;
import co.edu.icesiviajes.service.IdentificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/identificationType")
public class IdentificacionTypeRestController {

    @Autowired
    IdentificationTypeService service;

    @GetMapping(path = "/getIdentificationType")
    public ResponseEntity<List<IdentificationTypeDTO>> getAllIdentificationTypesWithImageUrls() {
        List<IdentificationTypeDTO> identificationTypes = service.findAll();
        return new ResponseEntity<>(identificationTypes, HttpStatus.OK);
    }

}