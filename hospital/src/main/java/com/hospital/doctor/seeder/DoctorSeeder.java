package com.hospital.doctor.seeder;

import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@Order(1)
public class DoctorSeeder implements CommandLineRunner {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void run(String... args) {

        
        if (doctorRepository.count() > 0) {
            System.out.println("Doctors already exist. Skipping seed.");
            return;
        }

        List<Doctor> doctors = List.of(
                createDoctor("Arjun",   "Sharma",    "Cardiology",      "+91-9876543201", "arjun.sharma@hospital.com",    "Senior cardiologist with 15 years of experience."),
                createDoctor("Priya",   "Nair",      "Neurology",       "+91-9876543202", "priya.nair@hospital.com",      "Specialist in brain and nervous system disorders."),
                createDoctor("Ravi",    "Kumar",     "Orthopedics",     "+91-9876543203", "ravi.kumar@hospital.com",      "Expert in bone, joint and muscle treatments."),
                createDoctor("Sneha",   "Patel",     "Pediatrics",      "+91-9876543204", "sneha.patel@hospital.com",     "Child health specialist with a gentle approach."),
                createDoctor("Vikram",  "Mehta",     "Dermatology",     "+91-9876543205", "vikram.mehta@hospital.com",    "Skin and hair treatment specialist."),
                createDoctor("Kavita",  "Reddy",     "Gynecology",      "+91-9876543206", "kavita.reddy@hospital.com",    "Women's health and maternity care expert."),
                createDoctor("Anil",    "Gupta",     "Ophthalmology",   "+91-9876543207", "anil.gupta@hospital.com",      "Eye specialist with expertise in LASIK surgery."),
                createDoctor("Meena",   "Iyer",      "Psychiatry",      "+91-9876543208", "meena.iyer@hospital.com",      "Mental health counselor and psychiatrist."),
                createDoctor("Suresh",  "Joshi",     "General Medicine","+91-9876543209", "suresh.joshi@hospital.com",    "General physician for all common illnesses."),
                createDoctor("Lakshmi", "Venkat",    "ENT",             "+91-9876543210", "lakshmi.venkat@hospital.com",  "Ear, nose and throat specialist.")
        );

        doctorRepository.saveAll(doctors);
        System.out.println("Seeded " + doctors.size() + " sample doctors.");
    }

    
    private Doctor createDoctor(String firstName, String lastName, String specialization,
                                 String phone, String email, String bio) {
        Doctor d = new Doctor();
        d.setFirstName(firstName);
        d.setLastName(lastName);
        d.setSpecialization(specialization);
        d.setPhoneNumber(phone);
        d.setEmail(email);
        d.setBio(bio);
        return d;
    }
}
