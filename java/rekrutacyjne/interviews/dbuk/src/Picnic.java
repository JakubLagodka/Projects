import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * John, Mary, Susan and Peter go for a picnic
 * Each of them has an initial budget of 50€
 * John goes to the store and buys some groceries spending 20€ in total, the other 3 pay their part back to him
 * Mary pays 10 € fuel to Susan
 *
 * 1. Write a program that prints the final balance of each member of the group (Make sure that you use generic
 * processes that can be reused in each scenario)
 *
 * 2. Find the minimum number of transactions required to resolve the balances (bring everyone back to 0 balance again)
 */

public class Picnic {

    static Person John;
    static Person Mary;
    static Person Susan;
    static Person Peter;
    static List<Person> people;

    @BeforeAll
    public static void init() {
        John = new Person(PersonNames.John, 50.0);
        Mary = new Person(PersonNames.Mary, 50.0);
        Susan = new Person(PersonNames.Susan, 50.0);
        Peter = new Person(PersonNames.Peter, 50.0);
        people = Arrays.asList(
                John, Mary, Susan, Peter
        );
    }

    private static void distributeMoney(Double totalAmount, List<Person> people, Person to) {
        Double amount = totalAmount / people.size();
        people.forEach(person -> sendMoney(person, to, amount));
    }


    private static void sendMoney(Person from, Person to, Double amount) {
        from.balance = from.balance - amount;
        if (to != null) {
            to.balance = to.balance + amount;
        }
    }

    @Test
    public void testScenario1() {
        //scenario 1: john spends 20 and the other three need to pay him back their part
        distributeMoney(20.0, Arrays.asList(John), null);
        distributeMoney(20.0, Arrays.asList(John, Mary, Susan, Peter), John);
        System.out.println("Scenario1:");
        people.forEach(p -> System.out.println(" - " + p));
        assert (John.balance == 45.0);
        assert (Mary.balance == 45.0);
        assert (Susan.balance == 45.0);
        assert (Peter.balance == 45.0);

    }

    @Test
    public void testScenario2() {
        //scenario 2: Mary pays 10€ to Susan
        distributeMoney(10.0, Arrays.asList(Mary), Susan);
        System.out.println("Scenario2:");
        people.forEach(p -> System.out.println(" - " + p));
        assert (John.balance == 45.0);
        assert (Mary.balance == 35.0);
        assert (Susan.balance == 55.0);
        assert (Peter.balance == 45.0);
    }



    @Test
    public void testMinNumberOfPayments(){
        List<Person> balances = Arrays.asList(
                new Person(PersonNames.John, 300d),
                new Person(PersonNames.Peter, -100d),
                new Person(PersonNames.Mary, -150d),
                new Person(PersonNames.Susan, -50d));

        List<Payment> expectedPayments = Arrays.asList(
                new Payment(PersonNames.Mary, PersonNames.John, 150d),
                new Payment(PersonNames.Peter, PersonNames.John, 100d),
                new Payment(PersonNames.Susan, PersonNames.John, 50d)
        );

        assertMinNumbOfPayemnts(findMinNumbOfPayments(balances), expectedPayments);
    }

    @Test
    public void testMinNumberOfPayments2(){
        List<Person> balances = Arrays.asList(
                new Person(PersonNames.John, 150d),
                new Person(PersonNames.Peter, 80d),
                new Person(PersonNames.Mary, -30d),
                new Person(PersonNames.Susan, -200d));
        List<Payment> expectedPayments = Arrays.asList(
                new Payment(PersonNames.Susan, PersonNames.John, 150d),
                new Payment(PersonNames.Susan, PersonNames.Peter, 50d),
                new Payment(PersonNames.Mary, PersonNames.Peter, 30d)
        );

        assertMinNumbOfPayemnts(findMinNumbOfPayments(balances), expectedPayments);
    }


    private void assertMinNumbOfPayemnts(List<Payment> foundPayments, List<Payment> expectedPayments ){
        assert (foundPayments != null);
        assert (foundPayments.size() == expectedPayments.size());
        foundPayments.stream().forEach(found -> isPaymentInList(found,expectedPayments));
    }

    private boolean isPaymentInList(Payment foundPayment, List<Payment> expectedPayments){
        Payment found = expectedPayments.stream()
                .filter(expectedPayment -> expectedPayment.from.equals(foundPayment.from) && expectedPayment.to.equals(foundPayment.to) && expectedPayment.amt.equals(foundPayment.amt))
                .findFirst().orElse(null);
        return found != null;
    }

    private List<Payment> findMinNumbOfPayments(List<Person> people){

        SplittedBalances balances = orderAndSplitBalances(people);
        List<Payment> payments = new ArrayList<>();
        //TODO it needs to reorder again
        for(int i = 0; i<balances.negativeOrderedBalances.size(); i++){
            payments.addAll(resolveNegativeBalance(balances.negativeOrderedBalances.get(i), balances.positiveOrderedBalances));
        }

        return payments;
    }

    private List<Payment> resolveNegativeBalance(Person from, List<Person> peopleWithPositive){
        int i=0;
        List<Payment> payments = new ArrayList<>();
        Person to = null;
        while(from.balance != 0 && i<peopleWithPositive.size()){
            to  = peopleWithPositive.get(i);
            double amt = Math.abs(from.balance <= to.balance ? from.balance :  to.balance);
            payments.add(new Payment(from.name, peopleWithPositive.get(i).name, amt));
            from.balance += amt;
            to.balance -= amt;
            i++;
        }
        return payments;
    }

    private SplittedBalances orderAndSplitBalances(List<Person> people){
        List<Person> negativeOrderedBalances = new ArrayList<>();
        List<Person> positiveOrderedBalances = new ArrayList<>();

        for (Person person : people){
            if(person.balance > 0 ){
                if(positiveOrderedBalances.size() > 0 && positiveOrderedBalances.get(0).balance < person.balance) {
                    positiveOrderedBalances.add(0, person);
                }else{
                    positiveOrderedBalances.add(person);
                }
            }else if (person.balance < 0){
                if(negativeOrderedBalances.size() > 0 && negativeOrderedBalances.get(0).balance > person.balance) {
                    negativeOrderedBalances.add(0, person);
                }else{
                    negativeOrderedBalances.add(person);
                };
            }
        }
        return new SplittedBalances(positiveOrderedBalances,negativeOrderedBalances);
    }


    private  enum PersonNames{
        John, Mary, Susan , Peter;
    }
    private static class SplittedBalances {
        public List<Person> negativeOrderedBalances;
        public List<Person> positiveOrderedBalances;
        public SplittedBalances(List<Person> positiveOrderedBalances, List<Person> negativeOrderedBalances){
            this.negativeOrderedBalances = negativeOrderedBalances;
            this.positiveOrderedBalances = positiveOrderedBalances;
        }
    }

    private static class Payment{
        public PersonNames from;
        public PersonNames to;
        public Double amt;
        public Payment(PersonNames from, PersonNames to, Double amt){
            this.from=from;
            this.to=to;
            this.amt=amt;
        }
    }

    private static class Person {
        public PersonNames name;
        public Double balance;

        public Person(PersonNames _name, Double _balance) {
            this.name = _name;
            this.balance = _balance;
        }

        @Override
        public String toString() {
            return String.format("%s, %s €", this.name, this.balance);
        }
    }


}

