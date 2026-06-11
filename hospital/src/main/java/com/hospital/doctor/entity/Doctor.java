package com.hospital.doctor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.appointment.entity.Appointment;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "doctors")
public class Doctor {

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    
    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Specialization is required")
    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "phone_number")
    private String phoneNumber;

    
    @Email(message = "Enter a valid email address")
    @Column(name = "email", unique = true)
    private String email;

    
    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Appointment> appointments = new ArrayList<>();

    

    public Doctor() {
    	
    }

    

    public Long getId() { 
    	return id; 
    	
    }
    public void setId(Long id) {
    	this.id = id;
    	
    }

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

    public List<Appointment> getAppointments() {
    	return appointments; 
    	
    }
    public void setAppointments(List<Appointment> appointments) { 
    	this.appointments = appointments; 
    	
    }
}
