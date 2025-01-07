import java.util.HashMap;
import java.util.Map;

public class CustomerManager {
    private Map<String, Customer> customerMap;

    public CustomerManager() {
        customerMap = new HashMap<>();
    }

    // Add a customer to the collection
    public void addCustomer(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
    }

    // Get a customer by their ID
    public Customer getCustomerById(String customerId) {
        return customerMap.get(customerId); // Returns null if customer not found
    }

    // Check if a customer already exists
    public boolean customerExists(String customerId) {
        return customerMap.containsKey(customerId);
    }

    // Get all customers (for displaying)
    public Iterable<Customer> getAllCustomers() {
        return customerMap.values();
    }
}
