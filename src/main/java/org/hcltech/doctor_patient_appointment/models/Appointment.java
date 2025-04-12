package org.hcltech.doctor_patient_appointment.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
//@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="appointment")
public class Appointment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appointment_id", unique = true)
    private Long id;
    @Column(name = "patient_id", nullable = false)
    private String patientid;
    @Column(name="patient_name", nullable = false, length = 35)
    private String patientname;
    @Column(name = "patient_email", unique = true, nullable = false)
    private String email;
    @Column(name="doctor_name", nullable = false, length = 35)
    private String doctorname;
    @Column(name = "doctor_specialization", nullable = false, length = 35)
    private String specialization;
    @Column(name = "appointment_date", nullable = false)
    private String date;
    @Column(name="patient_age", nullable = false)
    private String age;
    @Column(name="patient_gender", nullable = false, length = 10)
    private String gender;
    @Column(name="problem", nullable = false, length = 255)
    private String problem;
    @Column(name = "appointment_slot", nullable = false)
    private String slot;
    @Column(name = "appointment_status", nullable = false)
    private String appointmentstatus;
    @Column(name="admission_status", nullable = false)
    private String admissionstatus;

    /*
    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private Patient patient;

//    @Column(nullable = false)
//    private Prescription prescription;
*/

}
