import accounts.BankAccount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void addAccount( BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void transferFunds( BigDecimal amount, String fromAccount, String toAccount ) {
        BankAccount from = accounts.get( fromAccount );
        BankAccount to = accounts.get( toAccount );

        if ( from == null && to == null )throw new IllegalArgumentException( "Account not found" );

        from.withdraw( amount );
        to.deposit(  amount );

        from.logTransaction( "TRANSFER FROM " + fromAccount + " TO " + toAccount );
        to.logTransaction( "TRANSFER TO " + toAccount );
    }
}
