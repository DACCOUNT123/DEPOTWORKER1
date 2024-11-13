
public class Parcel {
	// Parcel class
    private String parcelId;
    private double weight;
    private String destination;
    private String status;

    public Parcel(String parcelId, double weight, String destination) {
        this.parcelId = parcelId;
        this.weight = weight;
        this.destination = destination;
        this.status = "Pending";
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

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getParcelDetails() {
        return "Parcel ID: " + parcelId + ", Weight: " + weight + ", Destination: " + destination + ", Status: " + status;
    }
}
