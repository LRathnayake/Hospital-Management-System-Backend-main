package com.apexgroup.eadbackend02.Services;

import com.apexgroup.eadbackend02.Entities.Doctors;
import com.apexgroup.eadbackend02.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServices {
    private DoctorRepository dRepo;
    @Autowired
    public DoctorServices(DoctorRepository dRepo) {
        this.dRepo = dRepo;
    }

    public List<Doctors> findAll() {
        return dRepo.findAll();
    }

    public Doctors findDoctorById(int id) {
        return dRepo.findById(id).orElse(null);
    }

    public Doctors save(Doctors obj) {
        return dRepo.save(obj);
    }

    public Doctors updateDoctor(Doctors doctor) {
        Doctors doctors = dRepo.findById(doctor.getId()).orElse(null);
        doctors.setName(doctor.getName());
        doctors.setAvailable(doctor.getAvailable());
        doctors.setId(doctor.getId());
        doctors.setContact(doctor.getContact());
        doctors.setSpeciality(doctor.getSpeciality());
        doctors.setExperience(doctor.getExperience());
        return dRepo.save(doctors);
    }

    public void deleteDoctorById(int id) {
        dRepo.deleteById(id);
    }
}
