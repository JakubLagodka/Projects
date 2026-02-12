import accounts.CheckingAccount;
import accounts.SavingsAccount;
import exceptions.InvalidAmountException;

void main() {
    Bank bank = new Bank();

    CheckingAccount checkingAccount = new CheckingAccount( "1","Jan Kowalski",new BigDecimal( 1000 ),new BigDecimal( 500 ) );
    SavingsAccount savingsAccount = new SavingsAccount( "2","Jan Kowalski", new BigDecimal( 5000 ),new BigDecimal( "0.05" ),new BigDecimal( 100 ) );

    bank.addAccount(checkingAccount);
    bank.addAccount(savingsAccount);

    checkingAccount.deposit(  new BigDecimal( 1 ) );
    savingsAccount.deposit(  new BigDecimal( 1 ) );

    try {
        bank.transferFunds( new BigDecimal( 300 ),"1","2" );
        checkingAccount.withdraw(  new BigDecimal( 1 ) );
    } catch( InvalidAmountException e ) {
        System.err.println("Caught InsufficientFundsException");
    }


    checkingAccount.printStatement();
    savingsAccount.printStatement();
}
