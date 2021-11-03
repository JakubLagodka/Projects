import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditFinder implements Finder {
    Map<Long, List<Long>> accounts;

    @Override
    public List<Long> findCustomerAccounts(Long customerId) {
        return accounts.get(customerId);
    }
}
