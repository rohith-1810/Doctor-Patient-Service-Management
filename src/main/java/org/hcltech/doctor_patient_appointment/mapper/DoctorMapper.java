package org.hcltech.doctor_patient_appointment.mapper;

import org.hcltech.doctor_patient_appointment.daos.services.DoctorDaoService;
import org.hcltech.doctor_patient_appointment.daos.services.PatientDAOService;
import org.hcltech.doctor_patient_appointment.dtos.DoctorDto;
import org.hcltech.doctor_patient_appointment.dtos.PatientDTO;
import org.hcltech.doctor_patient_appointment.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorMapper {

    private final DoctorDaoService doctorDaoService;
    private final PatientDAOService patientDaoService;
    private final PatientMapper patientMapper;

    public DoctorMapper(DoctorDaoService doctorDaoService, PatientDAOService patientDaoService, PatientMapper patientMapper) {
        this.doctorDaoService = doctorDaoService;
        this.patientDaoService = patientDaoService;
        this.patientMapper = patientMapper;
    }

    public DoctorDto toDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();

        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setGender(doctor.getGender());

//        if(doctor.getPatients() == null) {
//            doctor.setPatients(new ArrayList<>());
//        }

        /*else {
            List<PatientDTO> patientDtos = doctor.getPatients()
                    .stream()
                    .map(patientMapper::toDto)
                    .toList();
            doctorDto.setPatientDtos(patientDtos);
        }

         */

        return doctorDto;
    }

    public Doctor toEntityWhenCreating(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setGender(doctorDto.getGender());

        return doctor;
    }

    public Doctor toEntityAfterCreation(DoctorDto doctorDto) {
        if(doctorDto.getId() == null) {
            // TODO: controller advice
            // TODO: custom exception
            // TODO: status code: bad request
            // TODO: change the error message too
            throw new RuntimeException("Error converting dto to dao");
        }

        Doctor doctorFromDb = doctorDaoService.getDoctorById(doctorDto.getId());

        if(doctorFromDb == null) {
            // TODO: controller advice
            // TODO: custom exception
            // TODO: status code: bad request
            throw new RuntimeException("entity not found");
        }

        Doctor doctor = new Doctor();

        doctor.setId(doctorFromDb.getId());
        doctor.setName(doctorFromDb.getName());
        doctor.setGender(doctorFromDb.getGender());
        doctor.setSpecialization(doctorFromDb.getSpecialization());
//        doctor.setPatients(doctorFromDb.getPatients());

        return doctor;
    }

}
