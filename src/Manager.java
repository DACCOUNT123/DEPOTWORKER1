import java.util.Scanner;
// Defining Manager class
public class Manager {
    private QueueofCustomers queueOfCustomers;
    private ParcelMap parcelMap;
    private Worker worker;
    private Log log; // Instance of the Log class
    private Scanner scanner;

    public Manager() {
        this.queueOfCustomers = new QueueofCustomers();
        this.parcelMap = new ParcelMap();
        this.worker = new Worker(queueOfCustomers, parcelMap);
        this.log = Log.getInstance(); // Initialize the Log instance
        this.scanner = new Scanner(System.in);
    }

    public void initializeSystem() {
        log.logEvent("System initialized.");
        System.out.println("System initialized. Welcome!");
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Parcel");
            System.out.println("3. Show Customers");
            System.out.println("4. Show Parcels");
            System.out.println("5. Process Next Customer");
            System.out.println("6. Show Status");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addParcel();
                    break;
                case 3:
                    showCustomers();
                    break;
                case 4:
                    showParcels();
                    break;
                case 5:
                    processNextCustomer();
                    break;
                case 6:
                    showStatus();
                    break;
                case 7:
                    running = false;
                    log.logEvent("System exited.");
                    log.writeLogToFile("system_log.txt");
                    System.out.println("Exiting. Log saved to system_log.txt.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCustomer() {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(customerId, name, address);
        queueOfCustomers.addCustomer(customer);
        log.logEvent("Added customer: " + customer.getCustomerDetails());
        System.out.println("Customer added successfully.");
    }

    private void addParcel() {
        System.out.print("Enter Parcel ID: ");
        String parcelId = scanner.nextLine();
        System.out.print("Enter Parcel Weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter Parcel Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Customer ID (associated with this parcel): ");
        String customerId = scanner.nextLine();

        Parcel parcel = new Parcel(parcelId, weight, destination, customerId);
        parcelMap.addParcel(parcel);
        log.logEvent("Added parcel: " + parcel.getParcelDetails());
        System.out.println("Parcel added successfully.");
    }

    private void showCustomers() {
        System.out.println("\nList of Customers:");
        for (Customer customer : queueOfCustomers.getAllCustomers()) {
            System.out.println(customer.getCustomerDetails());
        }
    }

    private void showParcels() {
        System.out.println("\nList of Parcels:");
        for (Parcel parcel : parcelMap.getAllParcels()) {
            System.out.println(parcel.getParcelDetails());
        }
    }

    private void processNextCustomer() {
        System.out.println("\nProcessing next customer...");
        worker.processCustomer();
    }

    private void showStatus() {
        System.out.println("\nSystem Log:");
        log.displayLog();
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.initializeSystem();
    }
}
