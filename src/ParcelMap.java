import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class ParcelMap {
    private Map<String, Parcel> parcelMapById; // Map by Parcel ID
    private Map<String, List<Parcel>> parcelMapByCustomerId; // Map by Customer ID

    public ParcelMap() {
        parcelMapById = new HashMap<>();
        parcelMapByCustomerId = new HashMap<>();
    }

    // Add a parcel to the maps
    public void addParcel(Parcel parcel) {
        parcelMapById.put(parcel.getParcelId(), parcel);

        // Add parcel to the customer's list of parcels
        String customerId = parcel.getCustomerId();
        parcelMapByCustomerId.putIfAbsent(customerId, new ArrayList<>());
        parcelMapByCustomerId.get(customerId).add(parcel);
    }

    // Retrieve a parcel by its ID
    public Parcel getParcelById(String parcelId) {
        return parcelMapById.get(parcelId);
    }

    // Retrieve all parcels associated with a customer ID
    public List<Parcel> getParcelsByCustomerId(String customerId) {
        return parcelMapByCustomerId.getOrDefault(customerId, new ArrayList<>());
    }
    public List<Parcel> getAllParcels() {
        return new ArrayList<>(parcelMapById.values());
    }

    // Remove a parcel from the maps
    public void removeParcel(String parcelId) {
        Parcel parcel = parcelMapById.get(parcelId);
        if (parcel != null) {
            parcelMapById.remove(parcelId);
            String customerId = parcel.getCustomerId();
            parcelMapByCustomerId.getOrDefault(customerId, new ArrayList<>()).remove(parcel);

            // Clean up if the customer has no more parcels
            if (parcelMapByCustomerId.get(customerId).isEmpty()) {
                parcelMapByCustomerId.remove(customerId);
            }
        }
    }

    // Check if a parcel exists by its ID
    public boolean containsParcelById(String parcelId) {
        return parcelMapById.containsKey(parcelId);
    }
}
