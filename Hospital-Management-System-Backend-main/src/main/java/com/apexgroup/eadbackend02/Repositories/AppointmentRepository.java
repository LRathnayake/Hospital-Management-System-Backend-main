package com.apexgroup.eadbackend02.Repositories;

import com.apexgroup.eadbackend02.Entities.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, String> {

    Appointments findById(int id);

    void deleteById(int id);

    List<Appointments> id(int id);
}
