import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditFinder implements Finder {
    Map<Long, List<Account>> accounts;

    private DepositFinder depositFinder;

    CreditFinder(){
        accounts = new HashMap<>();

    }

    @Override
    public List<Account> findCustomerAccounts(Long customerId) {
        depositFinder = new DepositFinder();
        List<Account> userAccount = new ArrayList<>();
        userAccount.add(new Credit(1L,AccountType.CREDIT,1L,0.00));
        accounts.put(1L, userAccount);
        userAccount.addAll(depositFinder.findCustomerAccounts(customerId));
        accounts.put(customerId, userAccount);
        return userAccount;
    }
}
