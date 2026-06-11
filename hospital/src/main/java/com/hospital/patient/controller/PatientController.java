package com.hospital.patient.controller;

import com.hospital.patient.dto.PatientRequest;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatients(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String bloodGroup
    ) {
        List<Patient> results = patientService.searchPatients(keyword, bloodGroup);
        return ResponseEntity.ok(results);
    }


    @PostMapping
    public ResponseEntity<Patient> registerPatient(@RequestBody @Valid PatientRequest request) {
        Patient saved = patientService.registerPatient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Long id,
            @RequestBody PatientRequest request) {
        Patient updated = patientService.updatePatient(id, request);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        String message = patientService.deletePatient(id);
        return ResponseEntity.ok(message);
    }
}
