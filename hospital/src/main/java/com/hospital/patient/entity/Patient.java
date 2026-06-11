package com.hospital.patient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.appointment.entity.Appointment;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Email(message = "Enter a valid email address")
    @Column(name = "email", unique = true)
    private String email;

    
    @Column(name = "age")
    private Integer age;

    
    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "address")
    private String address;

    
    
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Appointment> appointments = new ArrayList<>();

    

    public Patient() {
    	
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

    public List<Appointment> getAppointments() { 
    	return appointments; 
    	
    }
    public void setAppointments(List<Appointment> appointments) {
    	this.appointments = appointments;
    	
    }
}
