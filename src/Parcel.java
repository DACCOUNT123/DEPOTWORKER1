public class Parcel {
    private String parcelId;
    private double weight;
    private String destination;
    private String status;
    private String customerId; // Added field to associate the parcel with a customer that is required

    public Parcel(String parcelId, double weight, String destination, String customerId) {
        this.parcelId = parcelId;
        this.weight = weight;
        this.destination = destination;
        this.status = "Pending";
        this.customerId = customerId; // Initialize the customerId
    }

    public String getParcelId() {
        return parcelId;
    }

    public double getWeight() {
        return weight;
    }

    public String getDestination() {
        return destination;
    }

    public String getStatus() {
        return status;
    }

    public String getCustomerId() {
        return customerId; // Getter for customerId
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getParcelDetails() {
        return "Parcel ID: " + parcelId + ", Weight: " + weight + ", Destination: " + destination +
                ", Status: " + status + ", Customer ID: " + customerId;
    }
}
