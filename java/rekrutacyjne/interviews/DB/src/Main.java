import java.util.List;

public class Main {
//    Sarah, Alice, Bob, John, Tom and Elsa are going on holiday.
//    Before they depart they need to buy flights and essentials.
//    They decide to settle up with each other after the holiday.
//
//    Alice spends £600 buying flights for everyone.
//    Sarah spends £300 buying walking shoes for just Alice, Tom and Elsa.
//    John spends £50 on a new suitcase for Alice.
//    Elsa spends £100 paying for the taxi to the airport for only Alice and Bob.
//
//    i.     Calculate the balance for each person just before they fly off on holiday.
//    ii.    Generate the minimum number of money movements required to settle the balances equally once
//    they are back from their holiday.


    public static void main(String[] args) {
        Main main = new Main();
        List<Person> people = List.of(new Person("Alice", 0.0),
                new Person("Sarah", 0.0),
                new Person("Bob", 0.0),
                new Person("John", 0.0),
                new Person("Tom", 0.0),
                new Person("Elsa", 0.0));
        List<Person> proceed = main.proceed(600.0,people,
                List.of(new Transaction("Alice", "Sarah"),
                        new Transaction("Alice", "Alice"),
                        new Transaction("Alice", "Bob"),
                        new Transaction("Alice", "John"),
                        new Transaction("Alice", "Tom"),
                        new Transaction("Alice", "Elsa")));

        proceed = main.proceed(300.0,proceed,
                List.of(new Transaction("Sarah","Alice"),
                        new Transaction("Sarah","Tom"),
                        new Transaction("Sarah","Elsa")));

        proceed = main.proceed(50.0,proceed,
                List.of(new Transaction("John","Alice")));

        proceed = main.proceed(100.0,proceed,
                List.of(new Transaction("Elsa","Alice"),
                        new Transaction("Elsa","Bob")));


    }

    List<Person> proceed(Double totalAmount, List<Person> people,List<Transaction> transactions){
        Double amount = totalAmount/transactions.size();
        for (Person person : people) {
            for (Transaction transaction : transactions) {
                transaction.setAmount(amount);
                if(transaction.getSender().equals(person.getName())){
                    person.setBalance(person.getBalance() - transaction.getAmount());
                }
                if(transaction.getReceiver().equals(person.getName())){
                    person.setBalance(person.getBalance() + transaction.getAmount());
                }
            }
        }
        return people;
    }
//    List<Person> split(List<Person> people){
//        for (Person person : people) {
//            if(person.getBalance() > 0){
//                for (Person person1 : people) {
//                    if(!person1.equals(person) && person1.getBalance() < 0){
//                        person.getBalance() <
//                        person1.setBalance();
//                    }
//                }
//            }
//        }
//    }
}