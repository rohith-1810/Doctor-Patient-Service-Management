package org.hcltech.doctor_patient_appointment.services;

import org.hcltech.doctor_patient_appointment.daos.services.PatientDAOService;
import org.hcltech.doctor_patient_appointment.dtos.PatientDTO;
import org.hcltech.doctor_patient_appointment.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientDAOService patientDaoService;
    public PatientService(PatientDAOService patientDaoService) {
        this.patientDaoService = patientDaoService;
    }

    public List<PatientDTO> getAllPatients() {
        List<Patient> response = patientDaoService.getAllPatients();
        return toDTO(response);
    }

    public PatientDTO updatePatientProfile(PatientDTO patientDTO) {
        Patient patient = toEntity(patientDTO);
        Patient result = patientDaoService.updatePatientProfile(patient);
        return toDTO(result);
    }

    public void deletePatient(Long id) {
        patientDaoService.deletePatient(id);
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
