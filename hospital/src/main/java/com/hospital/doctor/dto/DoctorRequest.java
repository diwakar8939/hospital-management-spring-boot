package com.hospital.doctor.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class DoctorRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    private String phoneNumber;

    @Email(message = "Enter a valid email address")
    private String email;

    private String bio;

    

    public String getFirstName() {
    	return firstName; 
    	
    }
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; 
    	
    }

    public String getLastName() {
    	return lastName; 
    	
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName; 
    	
    }

    public String getSpecialization() { 
    	return specialization; 
    	
    }
    public void setSpecialization(String specialization) { 
    	this.specialization = specialization;
    	
    }

    public String getPhoneNumber() {
    	return phoneNumber; 
    	
    }
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    	
    }

    public String getEmail() {
    	return email; 
    	
    }
    public void setEmail(String email) {
    	this.email = email; 
    	
    }

    public String getBio() {
    	return bio; 
    	
    }
    public void setBio(String bio) {
    	this.bio = bio; 
    	
    }
}
