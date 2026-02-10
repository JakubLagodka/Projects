import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *
 * The course is over in a school and the students are receiving the final notes. As part of an
 * evaluation monitoring process, the teachers need to have a generic process that generates
 * some stats based both on the students and the subjects
 *
 * - For each subject, it is needed to know :
 *      + the average note for all students
 *      + the best note (and the students who got it)
 *      + the worst note (and the students who got it)
 * - For each students, it is needed to know :
 *      + the average note of all subjects
 *      + the best note (and its related subject)
 *      + the worst note (and its related subject)
 *
 *
 * For example, given a class with these distribution of notes
 *
 *    +------------+------+------+---------+------+
 *    |   Notes    | John | Mary | Steven  | Lucy |
 *    +------------+------+------+---------+------+
 *    | Maths      |    5 |    9 |       6 |    6 |
 *    | Art        |    6 |    5 |       6 |    7 |
 *    | Music      |    9 |    5 |       4 |    7 |
 *    | Literature |    7 |    5 |       5 |    8 |
 *    +------------+------+------+---------+------+
 *
 *
 * The output for the given input should be:
 *
 * - Maths -->      avg: 6'5 , best: 9 (Mary) , worst: 5 (John)
 * - Art -->        avg: 6,  , best: 7 (Lucy) , worst: 5 (Mary)
 * - Music -->      avg: 6,25, best: 9 (John) , worst: 4 (Steven)
 * - Literature --> avg: 6'25, best: 8 (Lucy) , worst: 5 (Steven,Mary)
 *
 * - John -->   avg: 6'75 , best: 9 (Music) ,      worst: 5 (Maths)
 * - Mary -->   avg: 6 ,    best: 9 (Maths) ,      worst: 5 (Art, Music, Literature)
 * - Steven --> avg: 5'25 , best: 6 (Maths, Art) , worst: 4 (Music)
 * - Lucy -->   avg: 7 ,    best: 8 (Literature) ,  worst: 6 (Maths)
 */

public class AcademicNotes {

    static List<AcademicNote> notes = new ArrayList<>();
    static Map<Subjects,SubjectStats> subjectStats = new HashMap<>();
    static Map<Students,StudentStats> studentStats = new HashMap<>();


    @Test
    public void testStats(){

        notes = new ArrayList<>();

        //John
        notes.add(new AcademicNote(Subjects.Maths, 5d, Students.John));
        notes.add(new AcademicNote(Subjects.Art, 6d, Students.John));
        notes.add(new AcademicNote(Subjects.Music, 9d, Students.John));
        notes.add(new AcademicNote(Subjects.Literature, 7d, Students.John));

        //Mary
        notes.add(new AcademicNote(Subjects.Maths, 9d, Students.Mary));
        notes.add(new AcademicNote(Subjects.Art, 5d, Students.Mary));
        notes.add(new AcademicNote(Subjects.Music, 5d, Students.Mary));
        notes.add(new AcademicNote(Subjects.Literature, 5d, Students.Mary));

        //Steven
        notes.add(new AcademicNote(Subjects.Maths, 6d, Students.Steven));
        notes.add(new AcademicNote(Subjects.Art, 6d, Students.Steven));
        notes.add(new AcademicNote(Subjects.Music, 4d, Students.Steven));
        notes.add(new AcademicNote(Subjects.Literature, 5d, Students.Steven));

        //Lucy
        notes.add(new AcademicNote(Subjects.Maths, 6d, Students.Lucy));
        notes.add(new AcademicNote(Subjects.Art, 7d, Students.Lucy));
        notes.add(new AcademicNote(Subjects.Music, 7d, Students.Lucy));
        notes.add(new AcademicNote(Subjects.Literature, 8d, Students.Lucy));

        calculateStats(notes);

        //students
        assertStudentStats(Students.John, 6.75d, 9, Arrays.asList(Subjects.Music), 5, Arrays.asList(Subjects.Maths));
        assertStudentStats(Students.Mary, 6d,9, Arrays.asList(Subjects.Maths), 5, Arrays.asList(Subjects.Art, Subjects.Music, Subjects.Literature));
        assertStudentStats(Students.Steven, 5.25d,6, Arrays.asList(Subjects.Maths, Subjects.Art), 4, Arrays.asList(Subjects.Music));
        assertStudentStats(Students.Lucy, 7d,8, Arrays.asList(Subjects.Literature), 6, Arrays.asList(Subjects.Maths));

        //subjects
        assertSubjectStats(Subjects.Maths, 6.5d, 9, Arrays.asList(Students.Mary), 5d, Arrays.asList(Students.John));
        assertSubjectStats(Subjects.Art, 6d, 7, Arrays.asList(Students.Lucy), 5d, Arrays.asList(Students.Mary));
        assertSubjectStats(Subjects.Music, 6.25d, 9, Arrays.asList(Students.John), 4d, Arrays.asList(Students.Steven));
        assertSubjectStats(Subjects.Literature, 6.25d, 8, Arrays.asList(Students.Lucy), 5d, Arrays.asList(Students.Steven, Students.Mary));


    }//test


    private void calculateStats(List<AcademicNote> notes){

        for (AcademicNote note : notes){

            SubjectStats currentSubjStats = getSubjectStatsBySubjectName(note.subject);

            if(currentSubjStats == null){
                currentSubjStats = initSubjectStats(note);
            }

            //identify the bottom student
            if(note.note < currentSubjStats.bottom){
                currentSubjStats.bottom=note.note;
                currentSubjStats.bottomStudents = new ArrayList<>();
                currentSubjStats.bottomStudents.add(note.student);
            }else if(note.note == currentSubjStats.bottom){
                //in case of more than one student with the same bottom note, the name is concatenated
                currentSubjStats.bottomStudents.add(note.student);
            }

            //identify the top student
            if(note.note > currentSubjStats.top){
                currentSubjStats.top=note.note;
                currentSubjStats.topStudents = new ArrayList<>();
                currentSubjStats.topStudents.add(note.student);
            }else if(note.note == currentSubjStats.top){
                //in case of more than one student with the same top note, the name is concatenated
                currentSubjStats.topStudents.add(note.student);
            }

            //the note is simply aggregated and the average will be calculated in the last step
            currentSubjStats.average += note.note;

            StudentStats currentStudStats = getStudentStatsByStudentName(note.student);
            if(currentStudStats == null){
                currentStudStats = initStudentStats(note);
            }
            if(note.note < currentStudStats.bottom){
                currentStudStats.bottom = note.note;
                currentStudStats.bottomSubjects = new ArrayList<>();
                currentStudStats.bottomSubjects.add(note.subject);
            }else if (note.note == currentStudStats.bottom){
                currentStudStats.bottom = note.note;
                currentStudStats.bottomSubjects.add(note.subject);
            }
            if(note.note > currentStudStats.top){
                currentStudStats.top = note.note;
                currentStudStats.topSubjects = new ArrayList<>();
                currentStudStats.topSubjects.add(note.subject);
            }else if (note.note == currentStudStats.top){
                currentStudStats.top = note.note;
                currentStudStats.topSubjects.add(note.subject);
            }
            //the note is simply aggregated and the average will be calculated in the last step
            currentStudStats.average += note.note;

        }//for

        //calculate avgs using the length of the enums that serve as 'catalogues' of studends & subjects
        for(StudentStats studentStats : studentStats.values()){
            studentStats.average = studentStats.average /Subjects.values().length;
        }
        for(SubjectStats subjectStats : subjectStats.values()){
            subjectStats.average = subjectStats.average/ Students.values().length;
        }

    }




    private StudentStats initStudentStats(AcademicNote note){
        StudentStats initialStats = new StudentStats(note.note, note.note, note.student);
        studentStats.put(note.student,initialStats);
        return initialStats;
    }
    private SubjectStats initSubjectStats(AcademicNote note){
        SubjectStats initialStats = new SubjectStats(note.note, note.note, note.subject);
        subjectStats.put(note.subject,initialStats);
        return initialStats;
    }

    private void assertSubjectStats(Subjects subject, double avg, double top, List<Students> topStudents, double bottom, List<Students> bottomStudents){
        SubjectStats subjectStats = getSubjectStatsBySubjectName(subject);
        assert(subjectStats != null);
        assert(subjectStats.average==avg);
        assert(subjectStats.top == top);
        assert(subjectStats.bottom == bottom);
        assertListInList(subjectStats.topStudents, topStudents);
        assertListInList(subjectStats.bottomStudents, bottomStudents);
    }

    private void assertStudentStats(Students student, double avgNote, double best, List<Subjects> bestSubjects, double worst, List<Subjects> worstSubjects){
        StudentStats studentStats = getStudentStatsByStudentName(student);
        assert(studentStats != null);
        assert(studentStats.average == avgNote);
        assert(studentStats.top == best);
        assert(studentStats.bottom == worst);
        assertListInList(studentStats.topSubjects, bestSubjects);
        assertListInList(studentStats.bottomSubjects, worstSubjects);
    }

    private void assertListInList(List statsList, List assertList){
        assert(statsList != null && !statsList.isEmpty() && assertList != null && !assertList.isEmpty());
        assert(statsList.size() == assertList.size());
        for(Object obj : assertList){
            assert(statsList.contains(obj));
        }
    }

    private static SubjectStats getSubjectStatsBySubjectName(Subjects subjectName){
        return subjectStats.get(subjectName);
    }

    private static StudentStats getStudentStatsByStudentName(Students studentName){
        return studentStats.get(studentName);
    }

}

class AcademicNote {
    Subjects subject;
    double note;
    Students student;
    AcademicNote(Subjects subj, double not, Students student){
        this.subject=subj;
        this.note = not;
        this.student =student;
    }
}
enum Subjects{
    Maths, Art, Music, Literature;
}
enum Students {
    John, Mary, Steven, Lucy
}
class StudentStats extends Stats{
    Students student;
    List<Subjects> topSubjects;
    List<Subjects> bottomSubjects;
    public StudentStats(double top, double bottom, Students student){
        this.student = student;
        this.top = top;
        this.bottom = bottom;
        this.topSubjects=new ArrayList<>();
        this.bottomSubjects = new ArrayList<>();
    }
}
class SubjectStats extends Stats{
    Subjects subject;
    List<Students> topStudents;
    List<Students> bottomStudents;
    public SubjectStats(double top, double bottom, Subjects subject){
        this.subject = subject;
        this.top=top;
        this.bottom=bottom;
        this.topStudents=new ArrayList<>();
        this.bottomStudents = new ArrayList<>();
    }
}
class Stats{
    protected double bottom;
    protected double average;
    protected double top;
}

