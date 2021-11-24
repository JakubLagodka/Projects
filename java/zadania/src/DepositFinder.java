import java.util.List;
import java.util.Map;

public class DepositFinder implements Finder{
    Map<Long, List<Account>> accounts;

    @Override
    public List<Account> findCustomerAccounts(Long customerId) {
        return accounts.get(customerId);
    }
}
