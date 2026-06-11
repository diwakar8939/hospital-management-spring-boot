package com.hospital.appointment.seeder;

import com.hospital.appointment.entity.Appointment;
import com.hospital.appointment.entity.AppointmentStatus;
import com.hospital.appointment.repository.AppointmentRepository;
import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.repository.DoctorRepository;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
@Order(3)
public class AppointmentSeeder implements CommandLineRunner {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) {

        if (appointmentRepository.count() > 0) {
            System.out.println("Appointments already exist. Skipping seed.");
            return;
        }

        
        
        List<Doctor> doctors   = doctorRepository.findAll();
        List<Patient> patients = patientRepository.findAll();

        
        if (doctors.isEmpty() || patients.isEmpty()) {
            System.out.println("No doctors or patients found. Skipping appointment seed.");
            return;
        }

        List<Appointment> appointments = List.of(

                
                createAppointment(patients.get(0), doctors.get(0),
                        LocalDateTime.now().minusDays(5),
                        "Chest pain and shortness of breath",
                        AppointmentStatus.COMPLETED,
                        "ECG normal. Prescribed antacid. Follow up in 2 weeks."),

                
                createAppointment(patients.get(1), doctors.get(1),
                        LocalDateTime.now().minusDays(3),
                        "Frequent headaches",
                        AppointmentStatus.COMPLETED,
                        "Tension headache. Prescribed ibuprofen. Avoid screen time."),

                
                createAppointment(patients.get(2), doctors.get(2),
                        LocalDateTime.now().minusDays(1),
                        "Knee pain",
                        AppointmentStatus.CANCELLED,
                        null),

                
                createAppointment(patients.get(3), doctors.get(3),
                        LocalDateTime.now().plusDays(1),
                        "Routine checkup for child",
                        AppointmentStatus.CONFIRMED,
                        null),

                createAppointment(patients.get(4), doctors.get(4),
                        LocalDateTime.now().plusDays(2),
                        "Skin rash on arms",
                        AppointmentStatus.CONFIRMED,
                        null),

                
                createAppointment(patients.get(5), doctors.get(5),
                        LocalDateTime.now().plusDays(3),
                        "Irregular periods",
                        AppointmentStatus.PENDING,
                        null),

                createAppointment(patients.get(6), doctors.get(6),
                        LocalDateTime.now().plusDays(4),
                        "Vision blurry in right eye",
                        AppointmentStatus.PENDING,
                        null),

                createAppointment(patients.get(7), doctors.get(7),
                        LocalDateTime.now().plusDays(5),
                        "Anxiety and sleep issues",
                        AppointmentStatus.PENDING,
                        null),

                createAppointment(patients.get(8), doctors.get(8),
                        LocalDateTime.now().plusDays(6),
                        "Fever and body ache",
                        AppointmentStatus.PENDING,
                        null),

                createAppointment(patients.get(9), doctors.get(9),
                        LocalDateTime.now().plusDays(7),
                        "Ear pain and ringing",
                        AppointmentStatus.PENDING,
                        null)
        );

        appointmentRepository.saveAll(appointments);
        System.out.println(" Seeded " + appointments.size() + " sample appointments.");
    }

    private Appointment createAppointment(Patient patient, Doctor doctor,
                                           LocalDateTime dateTime, String reason,
                                           AppointmentStatus status, String notes) {
        Appointment a = new Appointment();
        a.setPatient(patient);
        a.setDoctor(doctor);
        a.setAppointmentDateTime(dateTime);
        a.setReason(reason);
        a.setStatus(status);
        a.setDoctorNotes(notes);
        return a;
    }
}
