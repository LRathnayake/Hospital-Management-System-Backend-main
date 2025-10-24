package com.apexgroup.eadbackend02.Repositories;

import com.apexgroup.eadbackend02.Entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patients, Integer> {

}
