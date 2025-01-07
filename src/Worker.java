import java.util.List;
// This is worker class
public class Worker {
    private QueueofCustomers queue;
    private ParcelMap parcelMap;

    public Worker(QueueofCustomers queue, ParcelMap parcelMap) {
        this.queue = queue;
        this.parcelMap = parcelMap;
    }

    public double calculateFee(Parcel parcel) {
        // Simple fee calculation based on parcel weight input
        return parcel.getWeight() * 2.5;  // $2.5 per weight unit
    }

    public String processCustomer() {
        Customer customer = queue.removeCustomer();
        String s="";
        if (customer != null) {
            List<Parcel> parcels = parcelMap.getParcelsByCustomerId(customer.getCustomerId());
            if (!parcels.isEmpty()) {
                for (Parcel parcel : parcels) {
                    double fee = calculateFee(parcel);
                    System.out.println("Processing customer: " + customer.getCustomerDetails());
                    System.out.println("Parcel details: " + parcel.getParcelDetails());
                    System.out.println("Fee: $" + fee);
                    parcel.updateStatus("Processed");
                    Log.getInstance().logEvent("Customer " + customer.getName() + " processed with Parcel ID: " + parcel.getParcelId());
                    s= "Processing customer: " + customer.getCustomerDetails()+" "+"Parcel details: " + parcel.getParcelDetails()+" "+"Fee: $" + fee;
                }
            } else {
                System.out.println("No parcels found for customer: " + customer.getName());
            s="No parcels found for customer: " + customer.getName();
            }
        } else {
            System.out.println("No customers in the queue.");
        s="No customers in the queue.";
        }
        return s;
    }


}
