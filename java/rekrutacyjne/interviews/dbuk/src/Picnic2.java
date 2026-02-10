import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Alice, Sarah, John and Bob decide to go on a camping trip.
 *     Sarah spends £400 buying food and shares it amongst everyone in the group.
 *     John spends £100 buying camping equipment for Alice and Bob
 *
 *     1. Write a program that calculates the final balance of each member of the group (Make sure that you use generic
 *  * processes that can be reused in each scenario)
 *  *
 *  * 2. Find the minimum number of transactions required to resolve the balances (bring everyone back to 0 balance again)
 */

public class Picnic2 {

    static Person Alice;
    static Person Sarah;
    static Person John;
    static Person Bob;
    static List<Person> people;

    @BeforeAll
    public static void init(){
        Alice = new Person("Alice", 0.0);
        Sarah = new Person("Sarah", 0.0);
        John = new Person("John", 0.0);
        Bob = new Person("Bob", 0.0);
        people = Arrays.asList(
                Alice, Sarah, John, Bob
        );
    }

    private static void sendMoney(Double totalAmount, Person from, List<Person> peopleTo){
        Double amount = totalAmount/peopleTo.size();
        from.balance -= totalAmount;
        for(Person to : peopleTo){
            to.balance += amount;
        }
    }



    @Test
    public void testScenario1(){
        sendMoney(400.0, Sarah, Arrays.asList(Alice, Sarah, John, Bob));
        System.out.println("Scenario1:");
        people.forEach(p->System.out.println(" - " + p));
        assert(Alice.balance==100.0);
        assert(Sarah.balance==-300.0);
        assert(John.balance==100.0);
        assert(Bob.balance==100.0);

    }

    @Test
    public void testScenario2(){
        sendMoney(100.0, John, Arrays.asList(Alice, Bob));
        System.out.println("Scenario2:");
        people.forEach(p->System.out.println(" - " + p));
        assert(Alice.balance==150.0);
        assert(Sarah.balance==-300.0);
        assert(John.balance==0.0);
        assert(Bob.balance==150.0);

    }

    private static class Person {
        String name;
        Double balance;

        public Person(String _name, Double _balance) {
            this.name = _name;
            this.balance = _balance;
        }

        @Override
        public String toString() {
            return String.format("%s, %s €", this.name, this.balance);
        }
    }




}


