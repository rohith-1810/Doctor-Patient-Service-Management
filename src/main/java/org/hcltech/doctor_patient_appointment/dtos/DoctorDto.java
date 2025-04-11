package org.hcltech.doctor_patient_appointment.dtos;

import lombok.*;
import org.hcltech.doctor_patient_appointment.enums.Gender;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String name;
    private String specialization;
    private Gender gender;
    private List<PatientDto> patientDtos;
}
