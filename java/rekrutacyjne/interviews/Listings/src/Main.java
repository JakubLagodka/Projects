import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
class A{
    A() {  print();   }
    void print() { System.out.print("A "); }
}
class B extends A{
    int i =   4;
    final int fi =   4;
    public static void main(String[] args){
        A a = new B();
        a.print();
    }
    void print() { System.out.print(i+" "+fi); }
}
class Base{
    static void m(){ }
    void n(){ }
    static void x(){ }
    void y(){ }
}
class Sub extends Base{
    //void m(){ } //WILL NOT COMPILE
    //static void n(){ } //WILL NOT COMPILE
    static void x(){ } //VALID, x() of base is hidden
    void y(){ } //VALID, y() of base is overridden
}
interface BaseI{
    public static final int UNIT = 100;
    static void o(){ }
    static void m(){ }
    void n();
    static void x(){ }
    void y();
    default void d(){}
    public default int geti(){return 0;}
    public static int getsi(){return 0;}
}
interface SubI extends BaseI{
    boolean equals(Object o);
    void m();
    static void o(){}
    void n();
    //static void n(){ } //WILL NOT COMPILE
    default void x(){ BaseI.x();} //VALID, x() of base is hidden
    default void y(){}
    //static void d(){}
    void d();
}
class Impl implements SubI, BaseI{

    public void o(){
        SubI.o();
    }


    @Override
    public void m() {

    }

    @Override
    public void n() {

    }

    @Override
    public void x() { //not needed
        SubI.super.x();
    }

    @Override
    public void y() { //not needed
        SubI.super.y();
    }

    @Override
    public void d() {

    }
}
interface Readable{
}
interface I{}
interface I2 extends Readable,I{}
sealed class Document implements Readable, I2 permits Book1{ }
non-sealed class Book1 extends Document implements Readable, I2 { }
final class Journal extends Book1{ }
public class Main {
    static final int in = 1000;
    public static void main( String[] args ) {
        Object o = null;
        String result = switch (o){
//            case Integer i && i > 0 -> "integer";
            case Integer i -> "integer";
            case null -> "null";
            default -> "default";
        };
        int index = 5;
        index = index++ + index++;
        System.out.println(index);
        System.out.println(trickyMethod());
        char ch = 'a';
        System.out.println(ch+1);
        byte a = 1, be =2;
        byte c = ( byte ) (a+be);
        try{
            throw new IOException();
        } catch ( IOException | RuntimeException e ){
//            e = new IOException();
        }
        StringBuilder stringBuilder = new StringBuilder("abcdef");
        stringBuilder.delete( 2,5 );
        System.out.println(stringBuilder);
        String s = " java ";
        System.out.println(s.strip());
        System.out.println(s.trim());
        s = """
                Hello
                World
                """;
        System.out.println(s.length());
        var books = new ArrayList<Book>( List.of(
           new Book( "The Outsider", LocalDate.of( 2019,1,1 ),"" ) ,
            new Book( "Becoming", LocalDate.of( 2018,1,1 ),"" ),
            new Book( "Uri",LocalDate.of( 2017,1,1 ),"" )
    ));
        Predicate<Book> p = b->b.releaseDate().isAfter( IsoChronology.INSTANCE.date(2018,1,1) );
        Set<String> newBooks = books.stream().collect( filtering(p,Collectors.mapping( Book::title, toSet() )) );
        Set<String> newBooksPartitioningBySatisfied = books.stream().collect( Collectors.partitioningBy(p)).get( true ).stream().map( Book::title ).collect( Collectors.toCollection( TreeSet::new ));
        Set<String> newBooksPartitioningByNotSatisfied = books.stream().collect( Collectors.partitioningBy(p)).get( false ).stream().map( Book::title ).collect( Collectors.toCollection( TreeSet::new ));
        System.out.println(newBooks);
        System.out.println(newBooksPartitioningBySatisfied);
        System.out.println(newBooksPartitioningByNotSatisfied);
        var employees = new ArrayList<Employee>( List.of(
                new Employee( "The Outsider",2000.0, Department.HR ) ,
                new Employee( "Becoming",  2100.0, Department.DEVELOPMENT ),
                new Employee( "Uri", 20000.0, Department.HR )
        ));
        System.out.println(employees.add( new Employee( "",0.0,Department.HR ) ));
        System.out.println(IntStream.range( 1,5 ).parallel().mapToDouble( i->i ).average().getAsDouble());
        Map<Department, Set<Employee>> wellPaidEmployeesByDepartment = employees.stream().collect( groupingBy(Employee::department, filtering( e -> e.salary() > 2000, toSet())));
        System.out.println(wellPaidEmployeesByDepartment);
        System.out.println(employees.stream().filter(x->x.salary()>100000).mapToDouble( x->x.salary() ).sum());
        IntFunction<IntUnaryOperator> intUnaryOperatorIntFunction = ai->b->ai-b;
        Locale.getDefault();
        int i;
        int j;
        for (i = 0, j = 0 ; j < 1 ; ++j , ++i){
            System.out.println( i + " " + j );
        }
        System.out.println( i + " " + j );
        for ( i = 0; i < 5; ++i) {
            System.out.println(i);
        }
        LocalDate ld = LocalDate.parse("2024-06-01");
        LocalDateTime ldt1 = ld.atTime( LocalTime.of(10, 10));
        LocalDateTime ldt2 = ldt1.plus( Period.ofDays(-1)).withHour(23);
        if(ldt1.isAfter(ldt2) &! ldt1.getMonth().equals(ldt2.getMonth())){
            System.out.println(ldt1.format( DateTimeFormatter.ofPattern("HHMM")));
        }else{
            System.out.println(ldt2.format(DateTimeFormatter.ofPattern("HHMM")));
        }
        books.sort( Comparator.comparing( Book::title ) ); //1
        books.sort( ( b1, b2 ) -> b1.title().compareTo( b2.title() ) ); //1
        Collections.sort(books, ( b1, b2)->b1.title().compareTo(b2.title())); //1
        // Collections.sort(books); //2
        final int in2 = 1000;
        char cha;
        cha = in;  //4
        cha = in2;  //4
//        cha = 'a';//1
        cha++;    //5
        System.out.println(cha);
        var numA = new Integer[]{1, 2};
        var list1 = new ArrayList<Integer>(List.of(numA));

        list1.add(null);
        var list2 = Collections.unmodifiableList(list1);
        list1.set(2, 3);
        List<List<Integer>> list3 = List.of(list1, list2);
        System.out.println(list3);
        Comparator<Student> studentNameComparator = Comparator.comparing(Student::name);
        Student[] student =new Student[]{
                new Student( "The Outsider",2000.0) ,
                new Student( "Becoming",  2100.0),
                new Student( "Uri", 20000.0)};
        Arrays.sort(student, studentNameComparator);
        Comparator<Student> customStudentNameComparator = Comparator.comparing(Student::name, (s1, s2) -> s2.compareTo(s1));
        Arrays.sort(student, customStudentNameComparator);
        Comparator<Student> reversedStudentNameComparator = Comparator.comparing(Student::name, Comparator.reverseOrder() );
        Arrays.sort(student, reversedStudentNameComparator);
        Comparator<Student> byAge = new Comparator<>() {
            @Override
            public int compare(Student p1, Student p2) {
                return Integer.compare( ( int ) p1.age(), ( int ) p2.age() );
            }
        };
        Comparator<Student> byAgeLambda = ( p1, p2 ) -> Integer.compare( ( int ) p1.age(), ( int ) p2.age() );
        Comparator<Student> byAgeLambdaInt = Comparator.comparingInt( p2 -> ( int ) p2.age() );
        AtomicInteger at;
        File f;
        String st[][][] = {{{null},{"",""}},{{""}}};
        System.out.println(st[0][0][0]);
        st[0][0].equals(  st[0][0]);
        st[0][0].clone();
        int length = st[0][0].length;
        SequencedCollection<String> subjects = new TreeSet<>();
        subjects.add( "q" );
        subjects.add( "a" );
        subjects.add( "z" );
        System.out.println(subjects);
        Spliterator<String> stringSpliterator = Stream.of("1","2","3","4","5").spliterator();
        System.out.println(stringSpliterator.estimateSize());
        Spliterator<String> stringSpliterator2 = stringSpliterator.trySplit();
        System.out.println(stringSpliterator.estimateSize());
        System.out.println(stringSpliterator2.estimateSize());
        AtomicInteger ai = new AtomicInteger();
    }
    static int trickyMethod(){
        try{
            return 1;
        } finally {
            return 2;
        }
    }
}
