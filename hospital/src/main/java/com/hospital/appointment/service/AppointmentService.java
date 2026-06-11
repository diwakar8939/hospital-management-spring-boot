package com.hospital.appointment.service;

import com.hospital.appointment.dto.BookAppointmentRequest;
import com.hospital.appointment.dto.UpdateAppointmentRequest;
import com.hospital.appointment.entity.Appointment;
import com.hospital.appointment.entity.AppointmentStatus;
import com.hospital.appointment.repository.AppointmentRepository;
import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.repository.DoctorRepository;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;



    public Appointment bookAppointment(BookAppointmentRequest request) {

        
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + request.getPatientId()));

        
        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + request.getDoctorId()));

        
        
        LocalDateTime startOfDay = request.getAppointmentDateTime().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay   = startOfDay.plusDays(1).minusSeconds(1);

        long appointmentsOnThatDay = appointmentRepository.countByDoctorIdAndAppointmentDateTimeBetweenAndStatusNot(
                doctor.getId(), startOfDay, endOfDay,AppointmentStatus.CANCELLED
        );

        if (appointmentsOnThatDay >= 10) {
            throw new RuntimeException(
                "Dr. " + doctor.getLastName() + " is fully booked on " +
                request.getAppointmentDateTime().toLocalDate() +
                ". Please choose a different date."
            );
        }

        
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDateTime(request.getAppointmentDateTime());
        appointment.setReason(request.getReason());
        appointment.setStatus(AppointmentStatus.PENDING); 


        
        return appointmentRepository.save(appointment);
    }

    

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        
        if (!patientRepository.existsById(patientId)) {
            throw new RuntimeException("Patient not found with id: " + patientId);
        }
        return appointmentRepository.findByPatientId(patientId);
    }

    

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        if (!doctorRepository.existsById(doctorId)) {
            throw new RuntimeException("Doctor not found with id: " + doctorId);
        }
        return appointmentRepository.findByDoctorId(doctorId);
    }


    public List<Appointment> getAppointmentsByStatus(AppointmentStatus status) {
        return appointmentRepository.findByStatus(status);
    }


    public Appointment updateAppointment(Long id, UpdateAppointmentRequest request) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));

        
        if (appointment.getStatus() == AppointmentStatus.COMPLETED ||
            appointment.getStatus() == AppointmentStatus.CANCELLED) {
            throw new RuntimeException(
                "Cannot update an appointment that is already " + appointment.getStatus()
            );
        }

        
        if (request.getStatus() != null) {
            appointment.setStatus(request.getStatus());
        }

        if (request.getDoctorNotes() != null) {
            appointment.setDoctorNotes(request.getDoctorNotes());
        }

        if (request.getAppointmentDateTime() != null) {
            
            if (request.getAppointmentDateTime().isBefore(LocalDateTime.now())) {
                throw new RuntimeException("New appointment time must be in the future.");
            }
            appointment.setAppointmentDateTime(request.getAppointmentDateTime());
        }

        
        return appointmentRepository.save(appointment);
    }



    public Appointment cancelAppointment(Long id) {
        UpdateAppointmentRequest cancelRequest = new UpdateAppointmentRequest();
        cancelRequest.setStatus(AppointmentStatus.CANCELLED);
        return updateAppointment(id, cancelRequest);
    }



    public List<Appointment> getAppointmentsBetweenDates(LocalDateTime start, LocalDateTime end) {

        if (start.isAfter(end)) {
            throw new RuntimeException("Start date must be before end date.");
        }

        return appointmentRepository.findByAppointmentDateTimeBetween(start, end);
    }
}
