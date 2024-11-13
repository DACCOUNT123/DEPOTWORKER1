public class Manager {
    private QueueofCustomers queueOfCustomers;
    private ParcelMap parcelMap;
    private Worker worker;

    public Manager() {
        this.queueOfCustomers = new QueueofCustomers();
        this.parcelMap = new ParcelMap();
        this.worker = new Worker(queueOfCustomers, parcelMap);
    }

    public void initializeSystem() {
        // Sample customers and parcels
        Customer customer1 = new Customer("C13", "John Doe", "123 Main St");
        Customer customer2 = new Customer("C2", "Jane Smith", "456 Oak St");

        Parcel parcel1 = new Parcel("P1", 10, "123 Main St");
        Parcel parcel2 = new Parcel("P2", 15, "456 Oak St");

        // Add customers and parcels to the system
        queueOfCustomers.addCustomer(customer1);
        queueOfCustomers.addCustomer(customer2);
        parcelMap.addParcel(parcel1);
        parcelMap.addParcel(parcel2);

        // Start processing customers
        worker.processCustomer(); // Process first customer
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.initializeSystem();
    }
}
