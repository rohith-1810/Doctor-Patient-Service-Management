package org.hcltech.doctor_patient_appointment.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
