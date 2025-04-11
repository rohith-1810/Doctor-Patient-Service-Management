package org.hcltech.doctor_patient_appointment.controllers;

import org.hcltech.doctor_patient_appointment.dtos.DoctorDto;
import org.hcltech.doctor_patient_appointment.models.Doctor;
import org.hcltech.doctor_patient_appointment.services.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // create
    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody @Validated DoctorDto doctorDto) {
        DoctorDto createdDoctorDto = doctorService.createDoctor(doctorDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDoctorDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdDoctorDto);
    }

    // read
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctors() {
        List<DoctorDto> doctorDtoList = doctorService.getDoctorsList();

        return ResponseEntity.ok(doctorDtoList);
    }

    // update

    // delete
}
