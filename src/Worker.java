public class Worker {
    private QueueofCustomers queue;
    private ParcelMap parcelMap;

    public Worker(QueueofCustomers queue, ParcelMap parcelMap) {
        this.queue = queue;
        this.parcelMap = parcelMap;
    }

    public double calculateFee(Parcel parcel) {
        // Simple fee calculation based on parcel weight
        return parcel.getWeight() * 2.5;  // $2.5 per weight unit
    }

    public void processCustomer() {
        Customer customer = queue.removeCustomer();
        if (customer != null) {
            Parcel parcel = parcelMap.getParcel(customer.getCustomerId());
            if (parcel != null) {
                double fee = calculateFee(parcel);
                System.out.println("Processing customer: " + customer.getCustomerDetails());
                System.out.println("Parcel details: " + parcel.getParcelDetails());
                System.out.println("Fee: $" + fee);
                parcel.updateStatus("Processed");
                Log.getInstance().logEvent("Customer " + customer.getName() + " processed with Parcel ID: " + parcel.getParcelId());
            } else {
                System.out.println("No parcel found for customer: " + customer.getName());
            }
        } else {
            System.out.println("No customers in the queue.");
        }
    }
}
