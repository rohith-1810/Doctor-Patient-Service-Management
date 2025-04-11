package org.hcltech.doctor_patient_appointment.services;

import org.hcltech.doctor_patient_appointment.daos.services.DoctorDaoService;
import org.hcltech.doctor_patient_appointment.dtos.DoctorDto;
import org.hcltech.doctor_patient_appointment.mapper.DoctorMapper;
import org.hcltech.doctor_patient_appointment.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorDaoService doctorDaoService;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorDaoService doctorDaoService, DoctorMapper doctorMapper) {
        this.doctorDaoService = doctorDaoService;
        this.doctorMapper = doctorMapper;
    }

    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.toEntityWhenCreating(doctorDto);

        Doctor createdDoctor = doctorDaoService.saveDoctor(doctor);

        return doctorMapper.toDto(createdDoctor);
    }

    public List<DoctorDto> getDoctorsList() {
        return doctorDaoService.getAllDoctors()
                .stream()
                .map(doctorMapper::toDto)
                .toList();
    }

    public DoctorDto getDoctorById(Long doctorId) {
        Doctor doctorById = doctorDaoService.getDoctorById(doctorId);

        if(doctorById == null) {
            // TODO: controller advice
            // TODO: custom exception
            throw new RuntimeException("no doctor with that id");
        }

        return doctorMapper.toDto(doctorById);
    }

    public DoctorDto updateDoctorDetails(Long id, DoctorDto doctorDto) {
        // Didn't use the toEntityAfterCreating because we are checking in getAndUpdateById
        Doctor doctor = doctorMapper.toEntityWhenCreating(doctorDto);
        Optional<Doctor> optionalUpdatedDoctor = doctorDaoService.getAndUpdateById(id, doctor);

        if(optionalUpdatedDoctor.isEmpty()) {
            // TODO: controller advice
            // TODO: custom exception
            // TODO: add status code not found
            throw new RuntimeException("User not found");
        }

        return doctorMapper.toDto(optionalUpdatedDoctor.get());
    }

    public void deleteDoctorById(Long id) {
        doctorDaoService.deleteDoctor(id);
    }
}
