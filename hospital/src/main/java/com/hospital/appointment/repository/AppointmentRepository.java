package com.hospital.appointment.repository;

import com.hospital.appointment.entity.Appointment;
import com.hospital.appointment.entity.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    List<Appointment> findByPatientId(Long patientId);


    List<Appointment> findByDoctorId(Long doctorId);


    List<Appointment> findByStatus(AppointmentStatus status);


    List<Appointment> findByDoctorIdAndStatus(Long doctorId, AppointmentStatus status);

  

    List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime start, LocalDateTime end);

    long countByDoctorIdAndAppointmentDateTimeBetweenAndStatusNot(Long doctorId, LocalDateTime start, LocalDateTime end, AppointmentStatus status);
}
