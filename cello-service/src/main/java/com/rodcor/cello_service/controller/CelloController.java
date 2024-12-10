package com.rodcor.cello_service.controller;

import com.rodcor.cello_service.model.Cello;
import com.rodcor.cello_service.service.ICelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cellos")
public class CelloController {

    @Autowired
    private ICelloService celloService;

    // Create a new Cello
    @PostMapping("/create")
    public ResponseEntity<Cello> createCello(@RequestBody Cello cello) {
        celloService.saveCello(cello);
        return ResponseEntity.ok(cello);
    }

    // Get a Cello by ID
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Cello> getCelloById(@PathVariable String id) {
        Cello cello = celloService.getOneCello(id);
        if (cello != null) {
            return ResponseEntity.ok(cello);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all Cellos
    @GetMapping("/getAll")
    public ResponseEntity<List<Cello>> getAllCellos() {
        List<Cello> cellos = celloService.getAllCellos();
        return ResponseEntity.ok(cellos);
    }

    // Update a Cello
    @PutMapping("/update/{id}")
    public ResponseEntity<Cello> updateCello(@PathVariable String id, @RequestBody Cello cello) {
        celloService.editCello(id, cello);
        return ResponseEntity.ok(cello);
    }

    // Delete a Cello
    @DeleteMapping("/delete/{id}")
    public String deleteCello(@PathVariable String id) {
        celloService.deleteCello(id);
        return "The Cello has being deleted";
    }

    // Search for Cellos based on criteria
    @GetMapping("/search")
    public ResponseEntity<List<Cello>> searchCellos(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) Integer costMin,
            @RequestParam(required = false) Integer costMax,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String sortField,
            @RequestParam(required = false) String sortOrder) {
        List<Cello> cellos = celloService.searchCellos(name, size, costMin, costMax, limit, sortField, sortOrder);
        return ResponseEntity.ok(cellos);
    }

}
