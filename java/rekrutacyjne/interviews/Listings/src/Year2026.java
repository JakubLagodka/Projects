import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static com.sun.tools.javac.main.Option.X;

public class Year2026 {
    public static void main( String[] args ) throws IOException, InterruptedException {
        BiFunction<Integer, Integer, Integer> x = ( var a, var b) -> a+b;   // works fine, but all have to be vars (cannot be i.e. var a, int b), can be used with annotations like @Nonnull var a
        var a = new int[]{1,2,3};   // compile fine and type var is type of int[]
        final var xx=10;   // it's ok
        System.out.println(1+2);   // prints 3, but it there were at least one string, then no (i.e. "1"+2 -> 12, "" + 1 + 2 -> 12)

// cannot create instance fields in records
        // sealed classes allows only for final/sealed/non-sealed subtype declaration, i.e.
//        sealed class Animal permits Dog, Cat{};   // valid is final/sealed/non-sealed Dog extends Animal{}


// strip() vs trim()?   // strip() removes Unicode chars (from JDK11), trim() just ASCII

        class A { Number f(){
            return null; //must be else compilation error
        }}
        class B extends A { Integer f(){
            return 0;
        }}
        new B().f();   // compiles and prints whatever is in that function

// classes A B with print method (with or without static), what will be printed
// A static
// B static
// A instance
// A constructor
// B instance
// B constructor

//catch (FileNotFoundException | IOException e);   // compilation error, cannot use the same catch for parent/child exceptions, FileNotFoundException should be separated & before or just removed

// Throwing checked exceptions   // fewer/narrower (i.e. nothing or IOException instead of Exception), broaded/new (causes compilation error), that's only for checked exceptions, unchecked can be added/changed as you like

        List<Integer> ints = List.of(1,2);
       // List<Number> nums = ints;    // not compile, generics are invariant

        List<? extends Number> xs;   // allowed xs.add(null), but only when not initialized using List.of() :: not allowed xs.add(1), xs.add(1.0), xs.add(new Object()) --> that's PECS (? extends T, ? super T)

        //Set<X> s = new HashSet<>();
        //s.add(new X()); s.add(new X());   // size=2 (if we don't have impl of X = cannot assume they are the same), size=1 (if X has impl both equals() & hashcode())

        //adding to TreeSet without comparability   // RuntimeException (ClassCastException), to avoid: X should implement Comparable<X> or we'd provide Comparator

        List.of(1,2,3).stream().reduce(0, Integer::sum);   // returns Optional<Integer> (value is 6, but we don't print that)

        Stream.of("a","a").collect( Collectors.toMap(s->s, s->1));   // Runtime exception (stream's toMap cannot handle duplicates without 3rd argument's remapping function)

        Collectors.toMap(s->s, s->1, Integer::sum);   // Merges values

        int xxx=10;
        IntSupplier s = () -> xxx+1;   // lambda varaibles must be effectively final

        Integer[] aa = {1,2,3};
        var list = Arrays.asList(aa);   // doesn't copy, it's a wrapper
        aa[0] = 9;
        System.out.println(list);   // prints [9,2,3]

        Path p = Path.of("a/./b/../c");
        System.out.println(p.normalize());   // prints a/c (removes ., then removes b/..)

        Files.readString(Path.of( "" ));   // Reads entire file as a String
        //empty not working readString

        LocalDate.of(2026,1,8).format( DateTimeFormatter.ofPattern("dd/MM/yyyy"));   // prints 08/01/2026

        Thread t = Thread.startVirtualThread(() -> System.out.println("v"));
        t.join();
        System.out.println("done");   // prints 'vdone'

        Executors.newVirtualThreadPerTaskExecutor();   // creates one virtual thread per task
    }
}
