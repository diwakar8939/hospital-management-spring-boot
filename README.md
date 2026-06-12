# 🏥 Hospital Management System

A full-stack **Hospital Management REST API** built with **Spring Boot** and **MySQL**, with a plain **HTML/CSS/JavaScript** frontend. This project manages doctors, patients, and appointments for a hospital.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 17, Spring Boot 3.2 |
| Database | MySQL 8 |
| ORM | Spring Data JPA / Hibernate |
| Validation | Jakarta Validation (@NotBlank, @Email, @Future) |
| API Documentation | Springdoc OpenAPI (Swagger UI) |
| Dev Tools | Spring Boot DevTools |
| Build Tool | Maven |
| Frontend | HTML, CSS, JavaScript (single file) |

---

## 📁 Project Structure

```
hospital-management/
├── src/main/java/com/hospital/
│   ├── HospitalManagementApplication.java
│   ├── doctor/
│   │   ├── entity/       Doctor.java
│   │   ├── repository/   DoctorRepository.java
│   │   ├── dto/          DoctorRequest.java
│   │   ├── service/      DoctorService.java
│   │   ├── controller/   DoctorController.java
│   │   └── seeder/       DoctorSeeder.java
│   ├── patient/
│   │   ├── entity/       Patient.java
│   │   ├── repository/   PatientRepository.java
│   │   ├── dto/          PatientRequest.java
│   │   ├── service/      PatientService.java
│   │   ├── controller/   PatientController.java
│   │   └── seeder/       PatientSeeder.java
│   ├── appointment/
│   │   ├── entity/       Appointment.java, AppointmentStatus.java
│   │   ├── repository/   AppointmentRepository.java
│   │   ├── dto/          BookAppointmentRequest.java, UpdateAppointmentRequest.java
│   │   ├── service/      AppointmentService.java
│   │   ├── controller/   AppointmentController.java
│   │   └── seeder/       AppointmentSeeder.java
│   ├── config/           WebConfig.java
│   └── exception/        GlobalExceptionHandler.java
├── src/main/resources/
│   ├── static/
│   │   └── index.html
│   └── application.properties
└── pom.xml
```

---

## ⚙️ Getting Started

### Prerequisites
- Java 17+
- Maven
- MySQL 8+

### 1. Clone the repository
```bash
git clone https://github.com/your-username/hospital-management.git
cd hospital-management
```

### 2. Create the MySQL database
```sql
CREATE DATABASE hospital_db;
```

### 3. Update application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```

### 4. Run the application
```bash
mvn spring-boot:run
```

### 5. Open the frontend
Visit: http://localhost:8080/index.html

> The app automatically seeds **10 doctors**, **10 patients**, and **10 appointments** on first run.

> ### 6. Open Swagger UI
Visit: http://localhost:8080/swagger-ui/index.html

---

## 🔗 API Endpoints

### Doctors — /api/doctors

| Method | Endpoint | Description |
|---|---|---|
| GET | /api/doctors | Get all doctors |
| GET | /api/doctors/{id} | Get doctor by ID |
| GET | /api/doctors/search?keyword=&specialization= | Search doctors |
| POST | /api/doctors | Add a new doctor |
| PUT | /api/doctors/{id} | Update doctor details |
| DELETE | /api/doctors/{id} | Delete a doctor |

### Patients — /api/patients

| Method | Endpoint | Description |
|---|---|---|
| GET | /api/patients | Get all patients |
| GET | /api/patients/{id} | Get patient by ID |
| GET | /api/patients/search?keyword=&bloodGroup= | Search patients |
| POST | /api/patients | Register a new patient |
| PUT | /api/patients/{id} | Update patient details |
| DELETE | /api/patients/{id} | Delete a patient |

### Appointments — /api/appointments

| Method | Endpoint | Description |
|---|---|---|
| GET | /api/appointments | Get all appointments |
| GET | /api/appointments/{id} | Get appointment by ID |
| GET | /api/appointments/patient/{patientId} | Get by patient |
| GET | /api/appointments/doctor/{doctorId} | Get by doctor |
| GET | /api/appointments/status?status=PENDING | Filter by status |
| GET | /api/appointments/range?start=&end= | Filter by date range |
| POST | /api/appointments | Book a new appointment |
| PUT | /api/appointments/{id} | Update status / add notes |
| PUT | /api/appointments/{id}/cancel | Cancel an appointment |

---

## 💡 Key Business Rules

- A doctor cannot have more than **10 appointments per day** (cancelled ones excluded)
- Appointments must be scheduled for a **future date and time**
- No two doctors or patients can share the **same email**
- A **COMPLETED** or **CANCELLED** appointment cannot be updated

---

## 🔄 Appointment Status Flow

```
PENDING → CONFIRMED → IN_PROGRESS → COMPLETED
                            ↘
                          CANCELLED
```

---

## 🌱 Sample Data (Auto-seeded on first run)

| Type | Count |
|---|---|
| Doctors | 10 (Cardiology, Neurology, Orthopedics, Pediatrics...) |
| Patients | 10 (across different cities and blood groups) |
| Appointments | 10 (mix of PENDING, CONFIRMED, COMPLETED, CANCELLED) |

---

## 📬 Sample API Requests

**Book an appointment:**
```json
POST /api/appointments
{
  "patientId": 1,
  "doctorId": 2,
  "appointmentDateTime": "2025-12-20T10:30:00",
  "reason": "Chest pain"
}
```

**Update appointment status:**
```json
PUT /api/appointments/1
{
  "status": "COMPLETED",
  "doctorNotes": "Prescribed paracetamol 500mg. Follow up in 1 week."
}
```

---

## 👨‍💻 Author

**Diwakar S**
- [GitHub](https://github.com/diwakar8939)
- [LinkedIn](https://www.linkedin.com/in/diwakar-s-6654342b2/)

---


