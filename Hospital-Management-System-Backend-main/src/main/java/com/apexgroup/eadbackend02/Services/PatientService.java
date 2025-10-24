package com.apexgroup.eadbackend02.Services;

import com.apexgroup.eadbackend02.Entities.Appointments;
import com.apexgroup.eadbackend02.Entities.Patients;
import com.apexgroup.eadbackend02.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository pRepo;
    @Autowired
    public PatientService(PatientRepository pRepo) {
        this.pRepo = pRepo;
    }

    public List<Patients> findAll() {
        return pRepo.findAll();
    }

    public Patients findById(int id) {
        return pRepo.findById(id).orElse(null);
    }

    public Patients save(Patients p) {
        return pRepo.save(p);
    }

    public void delete(int id) {
        pRepo.deleteById(id);
    }

    public Patients update(Patients p) {
        Patients obj = pRepo.findById(p.getId()).orElse(null);
        obj.setName(p.getName());
        obj.setGender(p.getGender());
        obj.setContact(p.getContact());
        obj.setMedicalCondition(p.getMedicalCondition());
        obj.setAge(p.getAge());
        return pRepo.save(obj);
    }
}
