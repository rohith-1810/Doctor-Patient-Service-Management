package org.hcltech.doctor_patient_appointment.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
//@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id", unique = true)
    private Long id;
    @Column(name = "patient_email", unique = true, nullable = false)
    private String email;
    @Column(name="patient_name", nullable = false, length = 35)
    private String username;
    @Column(name="patient_mobile_number", nullable = false)
    private String mobile;
    @Column(name="patient_gender", nullable = false, length = 10)
    private String gender;
    @Column(name="patient_age", nullable = false)
    private String age;
    @Column(name="patient_address", nullable = false)
    private String address;
    @Column(name="patient_password")
    private String password;


}
