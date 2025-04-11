package org.hcltech.doctor_patient_appointment.repositories;

import org.hcltech.doctor_patient_appointment.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
