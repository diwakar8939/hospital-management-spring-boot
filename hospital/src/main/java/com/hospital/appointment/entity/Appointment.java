package com.hospital.appointment.entity;

import com.hospital.doctor.entity.Doctor;
import com.hospital.patient.entity.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    
    
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    
    @NotNull(message = "Appointment date and time is required")
    @Column(name = "appointment_date_time", nullable = false)
    private LocalDateTime appointmentDateTime;

    
    @Column(name = "reason", length = 500)
    private String reason;


    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AppointmentStatus status = AppointmentStatus.PENDING; 


    
    @Column(name = "doctor_notes", length = 1000)
    private String doctorNotes;


    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    

    public Appointment() {
    	
    }

    

    public Long getId() { 
    	return id; 
    	
    }
    public void setId(Long id) {
    	this.id = id;
    	
    }

    public Patient getPatient() {
    	return patient; 
    	
    }
    public void setPatient(Patient patient) { 
    	this.patient = patient; 
    	
    }

    public Doctor getDoctor() { 
    	return doctor;
    	
    }
    public void setDoctor(Doctor doctor) { 
    	this.doctor = doctor;
    	
    }

    public LocalDateTime getAppointmentDateTime() {
    	return appointmentDateTime;
    	
    }
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
    	this.appointmentDateTime = appointmentDateTime;
    	
    }

    public String getReason() { 
    	return reason;
    	
    }
    public void setReason(String reason) {
    	this.reason = reason; 
    	
    }

    public AppointmentStatus getStatus() {
    	return status; 
    	
    }
    public void setStatus(AppointmentStatus status) { 
    	this.status = status; 
    	
    }

    public String getDoctorNotes() {
    	return doctorNotes; 
    	
    }
    public void setDoctorNotes(String doctorNotes) { 
    	this.doctorNotes = doctorNotes;
    	
    }

    public LocalDateTime getCreatedAt() {
    	return createdAt; 
    	
    }
    public void setCreatedAt(LocalDateTime createdAt) { 
    	this.createdAt = createdAt; 
    	
    }
}
