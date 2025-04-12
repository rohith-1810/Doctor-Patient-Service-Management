package org.hcltech.doctor_patient_appointment.dtos;

import jakarta.persistence.Column;
import lombok.*;
import org.hcltech.doctor_patient_appointment.enums.Gender;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String email;
    private String username;
    private String mobile;
    private String gender;
    private String age;
    private String address;
    private String password;
}
