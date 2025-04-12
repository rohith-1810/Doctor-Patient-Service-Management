package org.hcltech.doctor_patient_appointment.models;

import jakarta.persistence.*;
import lombok.*;
import org.hcltech.doctor_patient_appointment.enums.Gender;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="doctor")
public class Doctor {

    @Id
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
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "doctor", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Patient> patients;

//    private List<Appointment> appointments;

     */
}
