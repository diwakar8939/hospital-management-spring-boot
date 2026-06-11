package com.hospital.patient.service;

import com.hospital.patient.dto.PatientRequest;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }


    public List<Patient> searchPatients(String keyword, String bloodGroup) {

        if (keyword != null && !keyword.isEmpty()) {
            return patientRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                            keyword, keyword);
        }

        if (bloodGroup != null && !bloodGroup.isEmpty()) {
            return patientRepository.findByBloodGroup(bloodGroup);
        }

        return patientRepository.findAll();
    }

    

    public Patient registerPatient(PatientRequest request) {

        
        if (request.getEmail() != null && patientRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("A patient with this email already exists: " + request.getEmail());
        }

        
        Patient patient = new Patient();
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setEmail(request.getEmail());
        patient.setAge(request.getAge());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setAddress(request.getAddress());

        
        return patientRepository.save(patient);
    }

    

    public Patient updatePatient(Long id, PatientRequest request) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        
        if (request.getFirstName() != null) patient.setFirstName(request.getFirstName());
        if (request.getLastName() != null) patient.setLastName(request.getLastName());
        if (request.getPhoneNumber() != null) patient.setPhoneNumber(request.getPhoneNumber());
        if (request.getEmail() != null) patient.setEmail(request.getEmail());
        if (request.getAge() != null) patient.setAge(request.getAge());
        if (request.getBloodGroup() != null) patient.setBloodGroup(request.getBloodGroup());
        if (request.getAddress() != null) patient.setAddress(request.getAddress());

        
        return patientRepository.save(patient);
    }

    

    public String deletePatient(Long id) {

        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }

        patientRepository.deleteById(id);
        return "Patient deleted successfully!";
    }
}
