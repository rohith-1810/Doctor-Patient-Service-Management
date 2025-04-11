package org.hcltech.doctor_patient_appointment.daos.services;

import org.hcltech.doctor_patient_appointment.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorDaoService {

    private final DoctorRepository doctorRepository;

    public DoctorDaoService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
}
