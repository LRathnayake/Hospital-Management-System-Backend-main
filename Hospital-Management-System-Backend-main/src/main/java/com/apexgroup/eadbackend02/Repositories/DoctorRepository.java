package com.apexgroup.eadbackend02.Repositories;

import com.apexgroup.eadbackend02.Entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctors, Integer> {

}
