package com.apexgroup.eadbackend02.Controllers;

import com.apexgroup.eadbackend02.Entities.Appointments;
import com.apexgroup.eadbackend02.Services.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@Tag(name="Appointment API", description = "Handles operations related to the patients")
public class AppointmentsController {

    private AppointmentService service;
    @Autowired
    public AppointmentsController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Show the exact appointment using id", description ="Retrieve the appointment according to the given id" )
    public ResponseEntity<List> getAppointments() {
        List<Appointments> appointments = service.findAll();
        return ResponseEntity.ok().body(appointments);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Show the excat appointment using id", description = "Retrieve the patient according to the given id" )
    public ResponseEntity<Appointments> getAppointmentById(@PathVariable int id) {
        Appointments appointments = service.findById(id);
        return ResponseEntity.ok().body(appointments);
    }

    @PostMapping
    @Operation(summary = "Create new appointments",  description = "Add new appointments to the databse")
    public ResponseEntity<Appointments> addAppointment(@RequestBody Appointments obj) {
        Appointments saved = service.save(obj);
        return ResponseEntity.ok().body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit appointment status", description = "Edit the appointment status confirm, pending or delete")
    public ResponseEntity<Appointments> updateAppointment(@PathVariable int id, @RequestBody Appointments obj) {
        obj.setId(id);
        Appointments saved = service.save(obj);
        return ResponseEntity.ok().body(saved);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete appointments", description = "Delete the appointments according to the given id")
    public ResponseEntity<Appointments> deleteAppointmentById(@PathVariable int id) {
        service.deleteAppointmentById(id);
        return ResponseEntity.ok().build();
    }
}
