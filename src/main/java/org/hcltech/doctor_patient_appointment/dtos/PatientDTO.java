package org.hcltech.doctor_patient_appointment.dtos;

import lombok.*;

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
