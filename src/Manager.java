public class Manager {
    private QueueofCustomers queueOfCustomers;
    private ParcelMap parcelMap;
    private Worker worker;
    private Log log; // Instance of the Log class

    public Manager() {
        this.queueOfCustomers = new QueueofCustomers();
        this.parcelMap = new ParcelMap();
        this.worker = new Worker(queueOfCustomers, parcelMap);
        this.log = Log.getInstance(); // Initialize the Log instance
    }

    public void initializeSystem() {
    	  log.logEvent("System initialization started.");

    	    // Sample customers
    	    Customer customer1 = new Customer("C13", "John Doe", "123 Main St");
    	    Customer customer2 = new Customer("C2", "Jane Smith", "456 Oak St");

    	    // Sample parcels associated with customers
    	    Parcel parcel1 = new Parcel("P1", 10, "123 Main St", "C13"); // Linked to customer1
    	    Parcel parcel2 = new Parcel("P2", 15, "456 Oak St", "C2"); // Linked to customer2

    	    // Add customers and parcels to the system
    	    queueOfCustomers.addCustomer(customer1);
    	    log.logEvent("Added customer: " + customer1.getCustomerDetails());
    	    queueOfCustomers.addCustomer(customer2);
    	    log.logEvent("Added customer: " + customer2.getCustomerDetails());

    	    parcelMap.addParcel(parcel1);
    	    log.logEvent("Added parcel: " + parcel1.getParcelDetails());
    	    parcelMap.addParcel(parcel2);
    	    log.logEvent("Added parcel: " + parcel2.getParcelDetails());

    	    log.logEvent("Starting to process customers.");
    	    worker.processCustomer(); // Process first customer
    	    log.logEvent("Customer processing completed.");

    	    log.writeLogToFile("system_log.txt");
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.initializeSystem();
    }
}
