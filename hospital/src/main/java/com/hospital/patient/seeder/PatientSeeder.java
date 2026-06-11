package com.hospital.patient.seeder;

import com.hospital.patient.entity.Patient;
import com.hospital.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Order(2)
public class PatientSeeder implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) {

        if (patientRepository.count() > 0) {
            System.out.println("Patients already exist. Skipping seed.");
            return;
        }

        List<Patient> patients = List.of(
                createPatient("Rohit",    "Sharma",    "+91-9000000001", "rohit.sharma@gmail.com",    28, "B+",  "12 MG Road, Bengaluru"),
                createPatient("Ananya",   "Singh",     "+91-9000000002", "ananya.singh@gmail.com",    34, "O+",  "45 Anna Salai, Chennai"),
                createPatient("Karthik",  "Menon",     "+91-9000000003", "karthik.menon@gmail.com",   52, "A+",  "7 Linking Road, Mumbai"),
                createPatient("Divya",    "Pillai",    "+91-9000000004", "divya.pillai@gmail.com",    25, "AB-", "23 Sector 17, Chandigarh"),
                createPatient("Manoj",    "Tiwari",    "+91-9000000005", "manoj.tiwari@gmail.com",    41, "B-",  "88 Civil Lines, Nagpur"),
                createPatient("Pooja",    "Desai",     "+91-9000000006", "pooja.desai@gmail.com",     31, "O-",  "56 SG Highway, Ahmedabad"),
                createPatient("Sanjay",   "Kulkarni",  "+91-9000000007", "sanjay.kulkarni@gmail.com", 47, "A-",  "19 FC Road, Pune"),
                createPatient("Nisha",    "Bose",      "+91-9000000008", "nisha.bose@gmail.com",      22, "O+",  "33 Park Street, Kolkata"),
                createPatient("Arjun",    "Das",       "+91-9000000009", "arjun.das@gmail.com",       38, "B+",  "5 Connaught Place, Delhi"),
                createPatient("Preethi",  "Narayanan", "+91-9000000010", "preethi.n@gmail.com",       29, "AB+", "67 Jubilee Hills, Hyderabad")
        );

        patientRepository.saveAll(patients);
        System.out.println(" Seeded " + patients.size() + " sample patients.");
    }

    private Patient createPatient(String firstName, String lastName, String phone,
                                   String email, Integer age, String bloodGroup, String address) {
        Patient p = new Patient();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setPhoneNumber(phone);
        p.setEmail(email);
        p.setAge(age);
        p.setBloodGroup(bloodGroup);
        p.setAddress(address);
        return p;
    }
}
