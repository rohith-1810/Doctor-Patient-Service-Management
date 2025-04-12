package org.hcltech.doctor_patient_appointment.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long id;
    private String patientid;
    private String patientname;
    private String email;
    private String doctorname;
    private String specialization;
    private String date;
    private String age;
    private String gender;
    private String problem;
    private String slot;
    private String appointmentstatus;
    private String admissionstatus;
}
