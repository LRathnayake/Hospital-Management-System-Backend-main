package com.apexgroup.eadbackend02.Controllers;

import com.apexgroup.eadbackend02.Entities.Patients;
import com.apexgroup.eadbackend02.Services.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@Tag(name= "Patients API", description = "Handles operations related to the patients")
public class PatientsController {

    private PatientService service;
    @Autowired
    public PatientsController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Show all users", description = "Retrieve all users stored in the database")
    public ResponseEntity<List> getPatients() {
        List<Patients> patients = service.findAll();
        return ResponseEntity.ok().body(patients);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Show the exact patient using id", description = "Retrieve the patient according to the given id")
    public ResponseEntity<Patients> getPatientById(@PathVariable int id) {
        Patients patients = service.findById(id);
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    @Operation(summary = "Create new patients", description = "Add new patients to the database")
    public ResponseEntity<Patients> savePatient(@RequestBody Patients patients) {
        Patients saved = service.save(patients);
        return ResponseEntity.ok().body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit patients", description = "Edit details of users")
    public ResponseEntity<Patients> updatePatient(@PathVariable int id, @RequestBody Patients patients) {
        patients.setId(id);
        Patients updated = service.update(patients);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete patients", description = "Delete the patients according to the given id")
    public ResponseEntity<Patients> deletePatient(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
