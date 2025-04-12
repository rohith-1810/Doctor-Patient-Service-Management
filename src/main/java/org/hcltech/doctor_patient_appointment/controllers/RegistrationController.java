package org.hcltech.doctor_patient_appointment.controllers;

import org.hcltech.doctor_patient_appointment.dtos.PatientDTO;
import org.hcltech.doctor_patient_appointment.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/registerpatient")
    public ResponseEntity<PatientDTO> registerPatient(@RequestBody PatientDTO patientDTO) throws Exception
    {
        String currEmail = patientDTO.getEmail();
        if(currEmail != null || !"".equals(currEmail))
        {
            PatientDTO patientObj = registerService.fetchUserByEmail(currEmail);
            if(patientObj != null)
            {
                throw new Exception("Patient with "+currEmail+" already exists !!!");
            }
        }
        //System.out.println("here");
        PatientDTO patientObj = registerService.savePatient(patientDTO);
        if(patientObj==null){
            return ResponseEntity.internalServerError().build();
        }
        return new ResponseEntity<>(patientObj, HttpStatus.CREATED);
    }

}
