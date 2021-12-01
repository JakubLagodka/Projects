import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RorFinder implements Finder{
    Map<Long, List<Account>> accounts;

    private SavingFinder savingFinder;

    RorFinder(){
        accounts = new HashMap<>();

    }

    @Override
    public List<Account> findCustomerAccounts(Long customerId) {
        savingFinder = new SavingFinder();
        List<Account> userAccount = new ArrayList<>();
        userAccount.add(new Credit(1L,AccountType.ROR,1L,0.00));
        accounts.put(1L, userAccount);
        userAccount.addAll(savingFinder.findCustomerAccounts(customerId));
        accounts.put(customerId, userAccount);
        return userAccount;
    }
}
