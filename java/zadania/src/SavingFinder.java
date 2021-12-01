import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SavingFinder implements Finder{
    Map<Long, List<Account>> accounts;

    private CreditFinder creditFinder;

    SavingFinder(){
        accounts = new HashMap<>();

    }

    @Override
    public List<Account> findCustomerAccounts(Long customerId) {
        creditFinder = new CreditFinder();
        List<Account> userAccount = new ArrayList<>();
        userAccount.add(new Credit(1L,AccountType.SAVING,1L,0.00));
        accounts.put(1L, userAccount);
        userAccount.addAll(creditFinder.findCustomerAccounts(customerId));
        accounts.put(customerId, userAccount);
        return userAccount;
    }
}
