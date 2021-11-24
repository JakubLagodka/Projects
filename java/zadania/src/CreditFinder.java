import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditFinder implements Finder {
    Map<Long, List<Account>> accounts;

    private DepositFinder depositFinder;
    @Override
    public List<Account> findCustomerAccounts(Long customerId) {
        return accounts.get(customerId);
    }
}
