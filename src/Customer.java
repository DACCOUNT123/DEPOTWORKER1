public class Customer {
	// Data to be added
    private String customerId;
    private String name;
    private String address;

    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCustomerDetails() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Address: " + address;
    }
}
