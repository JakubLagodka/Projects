package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Hospital {

    public static void main(String[] args) {
        // Create some doctors
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Dr. Smith"));
        doctors.add(new Doctor("Dr. Jones"));
        doctors.add(new Doctor("Dr. Lee"));

        // Create some patients
        List<Patient> patients = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            patients.add(new Patient(random.nextInt(4) + 1, random.nextInt(10) + 1));
        }

        // Assign patients to doctors
        assignPatients(patients, doctors);

        // Print doctor assignments
        for (Doctor doctor : doctors) {
            System.out.println("Doctor " + doctor.getName() + ":");
            for (Patient patient : doctor.getPatients()) {
                System.out.println("\t- Severity: " + patient.getSeverity() + ", Treatment Time: " + patient.getTreatmentTime() + " seconds");
            }
        }
    }

    private static void assignPatients(List<Patient> patients, List<Doctor> doctors) {
        // Sort patients by severity (highest first)
        patients.sort(Comparator.comparingInt(Patient::getSeverity).reversed());

        // Assign patients to doctors round robin style
        int doctorIndex = 0;
        for (Patient patient : patients) {
            doctors.get(doctorIndex % doctors.size()).addPatient(patient);
            doctorIndex++;
        }
    }
}