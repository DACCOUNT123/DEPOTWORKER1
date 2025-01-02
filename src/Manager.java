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
        // Log system initialization
    	System.out.println("initializeSystem() called.");
        log.logEvent("System initialization started.");

        // Sample customers and parcels
        Customer customer1 = new Customer("C13", "John Doe", "123 Main St");
        Customer customer2 = new Customer("C2", "Jane Smith", "456 Oak St");

        Parcel parcel1 = new Parcel("P1", 10, "123 Main St");
        Parcel parcel2 = new Parcel("P2", 15, "456 Oak St");

        // Add customers and parcels to the system
        queueOfCustomers.addCustomer(customer1);
        log.logEvent("Added customer: " + customer1);
        queueOfCustomers.addCustomer(customer2);
        log.logEvent("Added customer: " + customer2);

        parcelMap.addParcel(parcel1);
        log.logEvent("Added parcel: " + parcel1);
        parcelMap.addParcel(parcel2);
        log.logEvent("Added parcel: " + parcel2);

        // Log the start of customer processing
        log.logEvent("Starting to process customers.");

        // Start processing customers
        worker.processCustomer(); // Process first customer

        // Log completion of processing
        log.logEvent("Customer processing completed.");

        // Write log to a file
        log.writeLogToFile("system_log.txt");
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.initializeSystem();
    }
}
