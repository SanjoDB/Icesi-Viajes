package co.edu.icesiviajes.controller;

import co.edu.icesiviajes.dto.SaleDTO;
import co.edu.icesiviajes.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/v1/sales")
public class SaleRestController {

    @Autowired
    SaleService service;

    @GetMapping(path = "/getSale")
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        List<SaleDTO> sales = service.findAll();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }


    @GetMapping(path = "/getSaleClient")
    public ResponseEntity<List<SaleDTO>> getAllSalesByClientId(@RequestBody Integer clientId) {
        List<SaleDTO> sales = service.findByClientID(clientId);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping(path = "/getSalePlan")
    public ResponseEntity<List<SaleDTO>> getAllSalesByPlanId(@RequestBody Integer planId) {
        List<SaleDTO> sales = service.findByPlanID(planId);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO sale) throws Exception {
        service.save(sale);
        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<String> deleteSale(@RequestBody Integer id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<>("Venta Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/deleteClient")
    public ResponseEntity<String> deleteSaleByClientId(@RequestBody Integer clientId) throws Exception {
        service.deleteByClientID(clientId);
        return new ResponseEntity<>("Venta Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/deletePlan")
    public ResponseEntity<String> deleteSaleByPlanId(@RequestBody Integer planId) throws Exception {
        service.deleteByPlanID(planId);
        return new ResponseEntity<>("Venta Eliminado", HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<SaleDTO> updateSale(@RequestBody SaleDTO sale) throws Exception {
        service.update(sale);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }

    @GetMapping(value = "/getSalesOfTheWeek")
    public ResponseEntity<?> salesOfTheWeek() {
        try {
            List<Object> response = service.findWeeklySales();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No se pudo obtener las ventas de la semana", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getLatestSales")
    public ResponseEntity<?> latestSales() {
        try {
            List<Object[]> response = service.findLatestSales();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No se pudo obtener las últimas ventas", HttpStatus.BAD_REQUEST);
        }
    }

}