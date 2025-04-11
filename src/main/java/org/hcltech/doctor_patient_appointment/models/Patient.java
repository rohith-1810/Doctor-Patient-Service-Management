package org.hcltech.doctor_patient_appointment.models;

import jakarta.persistence.*;
import lombok.*;
import org.hcltech.doctor_patient_appointment.enums.Gender;

import java.util.List;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseModel {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "fk_appointment_doctor", referencedColumnName = "id")
    private Doctor doctor;

//    private List<Appointment> appointments;

//    private List<Prescription> prescriptions;
}
