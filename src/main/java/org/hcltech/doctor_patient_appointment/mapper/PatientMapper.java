package org.hcltech.doctor_patient_appointment.mapper;

import org.hcltech.doctor_patient_appointment.daos.services.PatientDAOService;
import org.hcltech.doctor_patient_appointment.dtos.PatientDTO;
import org.hcltech.doctor_patient_appointment.models.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    private final PatientDAOService patientDaoService;

    public PatientMapper(PatientDAOService patientDaoService) {
        this.patientDaoService = patientDaoService;
    }
/*
    public PatientDTO toDto(Patient patient) {
        PatientDTO patientDto = new PatientDTO();

        patientDto.setDoctorId(patient.getDoctor().getId());

        return patientDto;
    }

 */
}
