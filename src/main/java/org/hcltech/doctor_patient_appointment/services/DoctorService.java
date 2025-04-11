package org.hcltech.doctor_patient_appointment.services;

import org.hcltech.doctor_patient_appointment.dtos.DoctorDto;
import org.hcltech.doctor_patient_appointment.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorDto createDoctor(DoctorDto doctorDto) {
        return null;
    }

    public List<DoctorDto> getDoctorsList() {
        return null;
    }
}
