package accounts;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

    private final BigDecimal interestRate;

    public SavingsAccount(String accountNumber, String ownerName, BigDecimal balance, BigDecimal interestRate, BigDecimal number ) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw( BigDecimal amount ) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException( "Amount must be greater than zero" );
        }
        if (balance.subtract( amount ).compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException( "Insufficient Funds" );
        }
        balance = balance.subtract( amount );
        logTransaction( "WITHDRAW " + amount + " -> balance " + balance  );
    }

    @Override
    public String getAccountType() {
        return "Saving Account";
    }
    public void applyInterest()  {
        BigDecimal interest = balance.multiply( interestRate );
        balance = balance.add( interest );
        logTransaction( "APPLYING INTEREST " + interest);
    }
}
