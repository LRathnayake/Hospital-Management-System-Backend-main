package com.apexgroup.eadbackend02.Controllers;

import com.apexgroup.eadbackend02.Entities.Doctors;
import com.apexgroup.eadbackend02.Services.DoctorServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@Tag(name = "DOctors API", description = "Handles operations related to the doctors")
public class DoctorsController {
    private DoctorServices services;
    @Autowired
    public DoctorsController(DoctorServices services) {
        this.services = services;
    }

    @GetMapping
    @Operation(summary = "Show the list of doctors", description = "Retrieve all the doctors")
    public ResponseEntity<List> getDoctors(){
        List<Doctors> doctors = services.findAll();
        return ResponseEntity.ok().body(doctors);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Show the exact patient using id", description = "Retrieve the patient according to the given id")
    public ResponseEntity<Doctors> getDoctorById(@PathVariable int id){
        Doctors doctors = services.findDoctorById(id);
        return ResponseEntity.ok().body(doctors);
    }

    @PostMapping
    @Operation(summary = "Create new doctors",  description = "Add new doctors to the database")
    public ResponseEntity<Doctors> addDoctor(@RequestBody Doctors obj){
        Doctors doctors = services.save(obj);
        return ResponseEntity.ok().body(doctors);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit doctors",  description = "Edit the availability of doctors")
    public ResponseEntity<Doctors> updateDoctor(@PathVariable int id, @RequestBody Doctors obj){
        obj.setId(id);
        Doctors doctors = services.save(obj);
        return ResponseEntity.ok().body(doctors);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete doctors", description = "Delete the doctors according to the given id")
    public ResponseEntity<Boolean> deleteDoctor(@PathVariable int id){
        services.deleteDoctorById(id);
        return ResponseEntity.ok().body(true);
    }
}
