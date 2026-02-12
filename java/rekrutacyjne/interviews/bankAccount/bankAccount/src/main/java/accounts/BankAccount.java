package accounts;

import exceptions.InvalidAmountException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private final  String accountNumber;
    private final  String ownerName;
    protected BigDecimal balance;
    private final List<String> transactions = new ArrayList<>();
    public BankAccount( String accountNumber, String ownerName, BigDecimal initialBalance ) {
        if(accountNumber == null || accountNumber.isEmpty()){
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
        logTransaction("INITIAL DEPOSIT " + initialBalance + "-> balance " + balance);
    }

    public void deposit(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO ) <= 0){
            throw new InvalidAmountException("Amount cannot be null");
        }
        balance = balance.add(amount);
        logTransaction("DEPOSIT " + amount + "-> balance " + balance);
    }

    public abstract void withdraw(BigDecimal amount);

    public abstract String getAccountType();

    public void logTransaction( String message ){
        transactions.add( message );
    }

    public void printStatement(){
        System.out.println("Statement for "+  accountNumber + " " + ownerName );
        transactions.forEach(System.out::println);
        System.out.println("Final Balance: " + balance);
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public BigDecimal getBalance() {
        return balance;
    }
}
