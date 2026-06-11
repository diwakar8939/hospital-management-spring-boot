package com.hospital.appointment.dto;

import com.hospital.appointment.entity.AppointmentStatus;

import java.time.LocalDateTime;


public class UpdateAppointmentRequest {

    private AppointmentStatus status;

    private String doctorNotes;

    private LocalDateTime appointmentDateTime;

    

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

    public LocalDateTime getAppointmentDateTime() {
    	
    	return appointmentDateTime; 
    	
    }
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
    	this.appointmentDateTime = appointmentDateTime; 
    	
    
    }
}
