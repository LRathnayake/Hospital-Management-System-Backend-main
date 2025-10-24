package com.apexgroup.eadbackend02.Services;

import com.apexgroup.eadbackend02.Entities.Appointments;
import com.apexgroup.eadbackend02.Repositories.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepository aRepo;
    @Autowired
    public AppointmentService(AppointmentRepository aRepo) {
        this.aRepo = aRepo;
    }

    public List<Appointments> findAll() {
        return aRepo.findAll();
    }

    public Appointments findById(int id) {
        return aRepo.findById(id);
    }

    public Appointments save(Appointments obj) {
        return aRepo.save(obj);
    }

    @Transactional
    public void deleteAppointmentById(int id){
        aRepo.deleteById(id);
    }

    public Appointments update(Appointments obj) {
        Appointments appointments = aRepo.findById(obj.getId());
        appointments.setId(obj.getId());
        appointments.setDate(obj.getDate());
        appointments.setTime(obj.getTime());
        appointments.setStatus(obj.getStatus());
        appointments.setDoctor(obj.getDoctor());
        appointments.setPatient(obj.getPatient());
        return aRepo.save(appointments);
    }
}
