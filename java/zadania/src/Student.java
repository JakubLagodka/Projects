import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Student {
    private String name;

    private String surname;

    private LocalDate birthDate;

    private double gradesAverage;

    public Student(String name, String surname, LocalDate birthDate, double gradesAverage) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gradesAverage = gradesAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getGradesAverage() {
        return gradesAverage;
    }

    public void setGradesAverage(double gradesAverage) {
        this.gradesAverage = gradesAverage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", gradesAverage=" + gradesAverage +
                '}';
    }

    static Student findSecondTheBestStudent(List<Student> studentList) {
        Student found = null;
        double higher = 0.0;
        int higherIndex = 0;
        int secondHigherIndex = 0;
        double secondHigher = 0.0;
        for (Student student : studentList) {
            if (student.gradesAverage > higher || (student.gradesAverage == higher && found.birthDate.isBefore(student.birthDate))) {
                secondHigher = higher;
                secondHigherIndex = higherIndex;
                higher = student.gradesAverage;
                higherIndex = studentList.indexOf(student);
                found = studentList.get(secondHigherIndex);
            }
        }
        return found;
    }
}
