package com.example.demo.service;

import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Patient;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repo.PatientRepo;
import com.example.demo.repo.PatientRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private ModelMapper modelMapper;

    public PatientDTO savePatient(PatientDTO patientDTO) {
        patientRepo.save(modelMapper.map(patientDTO, Patient.class));
        return patientDTO;
    }

    public List<PatientDTO> getAllPatients() {
        List<Patient> doctorList = patientRepo.findAll();
        return modelMapper.map(doctorList, new TypeToken<List<PatientDTO>>() {
        }.getType());
    }

    public PatientDTO getPatient(String id) {
        Optional<Patient> doctor = patientRepo.findById(id);

        if (doctor.isPresent()) {
            return modelMapper.map(doctor.get(), PatientDTO.class);
        } else {
            // Handle the case where the user is not found
            throw new UserNotFoundException(id);
        }
    }

    public PatientDTO updatePatient(PatientDTO patientDTO) {
        patientRepo.save(modelMapper.map(patientDTO, Patient.class));
        return patientDTO;
    }

    public boolean deletePatient(String id) {
        if (!patientRepo.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        patientRepo.deleteById(id);
        return true;
    }

}
