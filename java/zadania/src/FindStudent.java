import java.util.Comparator;
import java.util.List;

public class FindStudent {
//    static Student findSecondTheBestStudent(List<Student> studentList) {
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
//            }
//        }
//        return found;
//         studentList.stream()
//                 .sorted()
//                 .filter( i -> i.max(Comparator.naturalOrder());
//                .filter(student -> student.getGradesAverage() )
//
//    }
}
