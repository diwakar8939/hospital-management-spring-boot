package com.hospital.patient.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class PatientRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String phoneNumber;

    @Email(message = "Enter a valid email address")
    private String email;

    private Integer age;

    private String bloodGroup;

    private String address;

    

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

    public Integer getAge() {
    	return age; 
    	
    }
    public void setAge(Integer age) {
    	this.age = age; 
    	
    }

    public String getBloodGroup() { 
    	return bloodGroup; 
    	
    }
    public void setBloodGroup(String bloodGroup) { 
    	this.bloodGroup = bloodGroup;
    	
    }

    public String getAddress() { 
    	return address; 
    	
    }
    public void setAddress(String address) {
    	this.address = address; 
    	
    }
}
