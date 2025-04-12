package org.hcltech.doctor_patient_appointment.dtos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hcltech.doctor_patient_appointment.enums.Gender;
import org.hcltech.doctor_patient_appointment.models.Patient;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String email;
    private String doctorname;
    private String mobile;
    private String gender;
    private String experience;
    private String specialization;
    private String previoushospital;
    private String address;
    private String password;
    private String status;
    /*
    private Long id;
    private String name;
    private String specialization;
    private Gender gender;
    private List<Patient> patients;

     */
}
