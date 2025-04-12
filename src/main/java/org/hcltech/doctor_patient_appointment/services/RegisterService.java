package org.hcltech.doctor_patient_appointment.services;

import org.hcltech.doctor_patient_appointment.daos.services.RegisterDAOService;
import org.hcltech.doctor_patient_appointment.dtos.PatientDTO;
import org.hcltech.doctor_patient_appointment.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {
    private RegisterDAOService registerDAOService;
    public RegisterService(RegisterDAOService registerDAOService){
        this.registerDAOService=registerDAOService;
    }

    public PatientDTO fetchUserByEmail(String currEmail) {
        Patient patient = registerDAOService.fetchUserByEmail(currEmail);
        if (patient != null) {
            return toDTO(patient);
        }
        return null;
    }

    public PatientDTO savePatient(PatientDTO patientDTO) {
        Patient patient = toEntity(patientDTO);
        Patient response = registerDAOService.savePatient(patient);
        return toDTO(response);
    }

    public static PatientDTO toDTO(Patient patient){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setUsername(patient.getUsername());
        patientDTO.setMobile(patient.getMobile());
        patientDTO.setGender(patient.getGender());
        patientDTO.setAge(patient.getAge());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setPassword(patient.getPassword());
        return patientDTO;
    }

    public static Patient toEntity(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setEmail(patientDTO.getEmail());
        patient.setUsername(patientDTO.getUsername());
        patient.setMobile(patientDTO.getMobile());
        patient.setGender(patientDTO.getGender());
        patient.setAge(patientDTO.getAge());
        patient.setAddress(patientDTO.getAddress());
        patient.setPassword(patientDTO.getPassword());
        return patient;
    }

    public static List<Patient> toEntity(List<PatientDTO> patientDTOS){
        return patientDTOS.stream().map(b->toEntity(b)).toList();
    }

    public static List<PatientDTO> toDTO(List<Patient> patients){
        return patients.stream().map(p->toDTO(p)).toList();
    }

}
