import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindStudent {
    static Student findSecondTheBestStudent(List<Student> studentList) {
//        Student found = null;
//        double higher = 0.0;
//        int higherIndex = 0;
//        int secondHigherIndex = 0;
//        double secondHigher = 0.0;
//        for (Student student : studentList) {
//            boolean condition = (found != null && student.gradesAverage == higher && found.birthDate.isBefore(student.birthDate));
//            //przerobić na sprawdzanie drugiej średniej!
//            if (student.gradesAverage > higher || condition) {
//                if (!condition) {
//                    secondHigher = higher;
//                    secondHigherIndex = higherIndex;
//                }
//                higher = student.gradesAverage;
//                higherIndex = studentList.indexOf(student);
//                found = studentList.get(secondHigherIndex);
//            } else if ((student.gradesAverage < higher && student.gradesAverage > secondHigher) || (found != null && student.gradesAverage == secondHigher && found.birthDate.isBefore(student.birthDate))) {
//                secondHigher = student.gradesAverage;
//                secondHigherIndex = studentList.indexOf(student);
//                found = studentList.get(studentList.indexOf(student));
//
//            }
//        }
//        return found;
        return studentList.stream()
                 .sorted(Comparator.comparingDouble(Student::getGradesAverage))
                 .collect(Collectors.groupingBy(Student::getGradesAverage))
                 .entrySet().stream()
                 .skip(1)
                 .findFirst()
                .stream()
                .map(map -> map.getValue())
                .map(map -> map.get(0))
                .sorted(Comparator.comparingDouble(Student::getGradesAverage))
                .findFirst()
                .get();

//                 .filter( map -> map.getKey().equals());
//                .filter(student -> student.getGradesAverage() )

    }
}
