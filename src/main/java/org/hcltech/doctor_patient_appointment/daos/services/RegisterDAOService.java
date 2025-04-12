package org.hcltech.doctor_patient_appointment.daos.services;

import org.hcltech.doctor_patient_appointment.models.Patient;
import org.hcltech.doctor_patient_appointment.repositories.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterDAOService {
    @Autowired
    private RegisterRepository registerRepository;

    public Patient fetchUserByEmail(String currEmail) {
        return registerRepository.findByemail(currEmail);
    }

    public Patient savePatient(Patient patient) {
        return registerRepository.save(patient);
    }
}
