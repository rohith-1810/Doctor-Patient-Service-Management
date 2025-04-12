package org.hcltech.doctor_patient_appointment.controllers;

import org.hcltech.doctor_patient_appointment.dtos.PatientDTO;
import org.hcltech.doctor_patient_appointment.models.Patient;
import org.hcltech.doctor_patient_appointment.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PutMapping("/updatepatient")
    public ResponseEntity<PatientDTO> updatePatientProfile(@RequestBody PatientDTO patientDTO) throws Exception
    {
        PatientDTO response = patientService.updatePatientProfile(patientDTO);
        if(response==null){
            return ResponseEntity.internalServerError().build();
        }
        return new ResponseEntity<PatientDTO>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deletepatient")
    public ResponseEntity<Void> deletePatient(Long id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/patientlist")
    public ResponseEntity<List<PatientDTO>> getAllPatients() throws Exception
    {
        List<PatientDTO> patientList = patientService.getAllPatients();
        if(patientList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<List<PatientDTO>>(patientList, HttpStatus.OK);
    }


}
