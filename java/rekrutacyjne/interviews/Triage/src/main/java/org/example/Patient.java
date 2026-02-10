package org.example;

class Patient implements Runnable{
    private final int severity;
    private final int treatmentTime;

    private boolean cured;

    public Patient(int severity, int treatmentTime) {
        this.severity = severity;
        this.treatmentTime = treatmentTime;
        this.cured = false;
    }

    public int getSeverity() {
        return severity;
    }

    public int getTreatmentTime() {
        return treatmentTime;
    }
    public synchronized void cure(){
        this.cured = true;
    }
    @Override
    public void run() {
        cure();
    }
}
