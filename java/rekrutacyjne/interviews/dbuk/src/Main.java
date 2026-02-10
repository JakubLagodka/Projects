import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Transaction> transactionList;

    public static void main(String[] args) {
//        transactionList.add(new Transaction("Alice","John",100));
//        transactionList.add(new Transaction("Alice","Sarah",100));
//        transactionList.add(new Transaction("Alice","Alice",100));
//        transactionList.add(new Transaction("John","Alice",100));
        Main main = new Main();
        List<Transaction> transactionList = main.getTransactionList("Alice", List.of("Alice","John","Sarah","Elsa","Bob","Tom"),600);
        transactionList.addAll(main.getTransactionList("Sarah",List.of("Alice","Tom","Elsa"),300));
        transactionList.addAll(main.getTransactionList("John",List.of("Alice"),50));
        transactionList.addAll(main.getTransactionList("Elsa",List.of("Alice","Bob"),100));

        System.out.println(main.calculateBalances(List.of(new Person("Alice",0.0),
                new Person("Bob",0.0),
                new Person("Elsa",0.0),
                new Person("Sarah",0.0),
                new Person("John",0.0),
                new Person("Tom",0.0)),transactionList));
    }
    //funkcja przyjmująca 3 parametry: nadawca, lista odbiorców i wartość - ma być wartość / ilość
    //zbudował po liście i obliczył balanse
    public List<Transaction> getTransactionList(String sender, List<String> receivers, Integer amount){
        Double transactionAmount = amount.doubleValue()/receivers.size();
        List<Transaction> transactionList = new ArrayList<>();
        for (String receiver : receivers) {
            transactionList.add(new Transaction(sender,receiver,transactionAmount));
        }
        return transactionList;
    }
    public List<Person> calculateBalances(List<Person> personList, List<Transaction> transactionList){

        for (Person person : personList) {
            for (Transaction transaction : transactionList) {
                if(transaction.getSender().equals(person.getName())){
                    person.setBalance(person.getBalance() - transaction.getAmount());
                }
                if(transaction.getReceiver().equals(person.getName())){
                    person.setBalance(person.getBalance() + transaction.getAmount());
                }
            }
        }
        return personList;
    }
}