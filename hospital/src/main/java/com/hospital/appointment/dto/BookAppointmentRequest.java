package com.hospital.appointment.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public class BookAppointmentRequest {

    
    @NotNull(message = "Patient ID is required")
    private Long patientId;

    
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    
    @NotNull(message = "Appointment date and time is required")
    @Future(message = "Appointment must be scheduled for a future date and time")
    private LocalDateTime appointmentDateTime;

    
    private String reason;

    

    public Long getPatientId() {
    	return patientId; 
    	
    }
    public void setPatientId(Long patientId) { 
    	this.patientId = patientId;
    	
    }

    public Long getDoctorId() {
    	return doctorId; 
    	
    }
    public void setDoctorId(Long doctorId) { 
    	this.doctorId = doctorId;
    	
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
}
