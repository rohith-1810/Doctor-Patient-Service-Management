package org.hcltech.doctor_patient_appointment.daos.services;

import org.hcltech.doctor_patient_appointment.models.Patient;
import org.hcltech.doctor_patient_appointment.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientDaoService {

    private final PatientRepository patientRepository;

    public PatientDaoService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatientById(Long id) {
        // TODO: implement this
        return null;
    }
}
