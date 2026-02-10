public record Student(String name, double age) implements Comparable<Student> {
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.age, other.age);
    }

// Getters and setters
}