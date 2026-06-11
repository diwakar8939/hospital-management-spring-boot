package com.hospital.doctor.service;

import com.hospital.doctor.dto.DoctorRequest;
import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorService {


    @Autowired
    private DoctorRepository doctorRepository;

    

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    

    public Doctor getDoctorById(Long id) {
        
        
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }



    public List<Doctor> searchDoctors(String specialization, String keyword) {

        
        if (keyword != null && !keyword.isEmpty()) {
            return doctorRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                            keyword, keyword);
        }

        
        if (specialization != null && !specialization.isEmpty()) {
            return doctorRepository.findBySpecialization(specialization);
        }

        
        return doctorRepository.findAll();
    }

    

    public Doctor addDoctor(DoctorRequest request) {

        
        if (request.getEmail() != null && doctorRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("A doctor with this email already exists: " + request.getEmail());
        }

        
        Doctor doctor = new Doctor();
        doctor.setFirstName(request.getFirstName());
        doctor.setLastName(request.getLastName());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setPhoneNumber(request.getPhoneNumber());
        doctor.setEmail(request.getEmail());
        doctor.setBio(request.getBio());

        
        return doctorRepository.save(doctor);
    }

    

    public Doctor updateDoctor(Long id, DoctorRequest request) {

        
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        
        
        if (request.getFirstName() != null) doctor.setFirstName(request.getFirstName());
        if (request.getLastName() != null) doctor.setLastName(request.getLastName());
        if (request.getSpecialization() != null) doctor.setSpecialization(request.getSpecialization());
        if (request.getPhoneNumber() != null) doctor.setPhoneNumber(request.getPhoneNumber());
        if (request.getEmail() != null) doctor.setEmail(request.getEmail());
        if (request.getBio() != null) doctor.setBio(request.getBio());

        
        return doctorRepository.save(doctor);
    }

    

    public String deleteDoctor(Long id) {

        
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Doctor not found with id: " + id);
        }

        doctorRepository.deleteById(id);
        return "Doctor deleted successfully!";
    }
}
