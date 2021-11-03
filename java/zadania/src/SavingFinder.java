import java.util.List;
import java.util.Map;

public class SavingFinder implements Finder{
    Map<Long, List<Long>> accounts;

    @Override
    public List<Long> findCustomerAccounts(Long customerId) {
        return accounts.get(customerId);
    }
}
