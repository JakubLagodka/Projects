public abstract class Account {
    private Long accountNumber;
    private AccountType accountType;
    private Long customerNumber;
    private Double accountState;

    public Account(Long accountNumber, AccountType accountType, Long customerNumber, Double accountState) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.customerNumber = customerNumber;
        this.accountState = accountState;
    }
}
