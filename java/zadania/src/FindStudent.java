import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindStudent {
    static Student findSecondTheBestStudent(List<Student> studentList) {

        if (studentList == null || studentList.size() < 2)
            return null;

        int higherIndex = 0;
        int secondHigherIndex = -1;
        //zadeklarować 2 studentów, do których można przypisywać wartości z listy, zrobić isEmpty()

//        for (Student student : studentList) {
        for (int i = 1; i < studentList.size(); i++) {
            //przerobić na sprawdzanie drugiej średniej!
            if (studentList.get(i).getGradesAverage() > studentList.get(higherIndex).getGradesAverage()
                    || studentList.get(i).getGradesAverage().equals(studentList.get(higherIndex).getGradesAverage())
                    && studentList.get(higherIndex).getBirthDate().isBefore(studentList.get(i).getBirthDate())) {
                if (!(studentList.get(i).getGradesAverage().equals(studentList.get(higherIndex).getGradesAverage())
                        && studentList.get(higherIndex).getBirthDate().isBefore(studentList.get(i).getBirthDate()))) {

                    secondHigherIndex = higherIndex;
                }

                higherIndex = i;

            } else if ((studentList.get(i).getGradesAverage() < studentList.get(higherIndex).getGradesAverage()
                    && (secondHigherIndex == -1
                    || studentList.get(i).getGradesAverage() > studentList.get(secondHigherIndex).getGradesAverage())
                    || (secondHigherIndex != -1 && studentList.get(i).getGradesAverage().equals(studentList.get(secondHigherIndex).getGradesAverage())
                    && studentList.get(secondHigherIndex).getBirthDate().isBefore(studentList.get(i).getBirthDate())))) {

                secondHigherIndex = i;

            }
        }
        if (secondHigherIndex == -1)
            return null;

        return studentList.get(secondHigherIndex);
    }

    static Student findSecondTheBestStudentStream(List<Student> studentList) {
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
        if (studentList == null)
            return null;
        else {
            List<Student> students = studentList.stream()
//                .sorted(Comparator.comparingDouble(Student::getGradesAverage).reversed())
//                .skip(1)
////                .findFirst() .orElse(null);
//                .filter(Objects::isNull)
                    .collect(Collectors.groupingBy(Student::getGradesAverage, () -> new TreeMap<>(Comparator.comparingDouble(Double::doubleValue).reversed()), Collectors.toList()))
//                .collect(Collectors.groupingBy(Student::getGradesAverage, () -> new LinkedHashMap<>(), Collectors.toList()))
                    .entrySet().stream()
//                .sorted(Comparator.comparingDouble(Student::getGradesAverage).reversed())
//                .values()
//                .stream()
                    .skip(1)
                    .map(Map.Entry::getValue)
//                .map(map -> map.get(1))
//                .filter(Objects::isNull)
//                .map(list -> list.get(1))
//                .sorted(Comparator.comparingDouble(Student::getGradesAverage))
//                .orElse(null)
                    .findFirst()
                    .orElse(null);
            if (students == null)
                return null;
            return students
//                .map(map -> map.get(1))
                    .stream()
//                .collect(Collectors.toSet(TreeSet::new))
                    .sorted(Comparator.comparing(Student::getBirthDate).reversed())

//                .skip(1)
                    .findFirst()
                    .orElse(null);

        }


//        return studentList.stream()
//                .collect(Collectors.toMap(Student::getGradesAverage, Function.identity(), (a, b) -> a,
//                        () -> new TreeMap<>(Comparator.comparing(Double::doubleValue).reversed())))
//                .values()
//                .stream()
//                .skip(1)
//                .findFirst()
//                .orElse(null);
    }
}
