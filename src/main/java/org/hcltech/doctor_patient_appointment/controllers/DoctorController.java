package org.hcltech.doctor_patient_appointment.controllers;

import org.hcltech.doctor_patient_appointment.dtos.DoctorDto;
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

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody @Validated DoctorDto doctorDto) {
        DoctorDto createdDoctorDto = doctorService.createDoctor(doctorDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDoctorDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdDoctorDto);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctors() {
        List<DoctorDto> doctorDtoList = doctorService.getDoctorsList();

        return ResponseEntity.ok(doctorDtoList);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorByDoctorId(@PathVariable Long doctorId) {
        DoctorDto doctorDto = doctorService.getDoctorById(doctorId);

        return ResponseEntity.ok(doctorDto);
    }

    // update details of the doctor
    // for allocating the patient,
    // use allocate doctor route in the patient controller
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDoctorDetails(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
        doctorService.updateDoctorDetails(id, doctorDto);

        return ResponseEntity.ok("Resource updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);

        return ResponseEntity.ok("Resource deleted successfully");
    }
}
