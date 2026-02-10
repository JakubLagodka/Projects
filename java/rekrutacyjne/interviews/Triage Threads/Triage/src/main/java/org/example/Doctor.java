package org.example;

import java.util.ArrayList;
import java.util.List;

class Doctor {
    private final String name;
    private final List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
