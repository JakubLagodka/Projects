import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepositFinder implements Finder{
    Map<Long, List<Account>> accounts;

    private RorFinder rorFinder;

    DepositFinder(){
        accounts = new HashMap<>();

    }

    @Override
    public List<Account> findCustomerAccounts(Long customerId) {
        rorFinder = new RorFinder();
        List<Account> userAccount = new ArrayList<>();
        userAccount.add(new Credit(1L,AccountType.DEPOSIT,1L,0.00));
        accounts.put(1L, userAccount);
        userAccount.addAll(rorFinder.findCustomerAccounts(customerId));
        accounts.put(customerId, userAccount);
        return userAccount;
    }
}
