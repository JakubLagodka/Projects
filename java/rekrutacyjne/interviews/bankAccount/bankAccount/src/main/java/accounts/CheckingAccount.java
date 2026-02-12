package accounts;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

import java.math.BigDecimal;

public class CheckingAccount  extends BankAccount {
    private final BigDecimal overdraftLimit;
    public CheckingAccount(String accountNumber, String ownerName, BigDecimal balance, BigDecimal overdraftLimit) {
        super(accountNumber, ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw( BigDecimal amount ) {
        if (amount.compareTo(overdraftLimit) < 0) {
            throw new InvalidAmountException("Amount must be greater than or equal to 0");
        }
        BigDecimal availableFunds = balance.add(overdraftLimit);
        if (availableFunds.compareTo(overdraftLimit) > 0) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance = balance.subtract(amount);
        logTransaction( "WITHDRAW " + amount + " -> balance " + balance  );
    }

    @Override
    public String getAccountType() {
        return "Checking Account";
    }
}
