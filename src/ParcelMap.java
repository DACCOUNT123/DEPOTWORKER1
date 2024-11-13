import java.util.HashMap;
import java.util.Map;
// Parcel Map class
public class ParcelMap {
    private Map<String, Parcel> parcelMap;

    public ParcelMap() {
        parcelMap = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelId(), parcel);
    }

    public Parcel getParcel(String parcelId) {
        return parcelMap.get(parcelId);
    }

    public void removeParcel(String parcelId) {
        parcelMap.remove(parcelId);
    }

    public boolean containsParcel(String parcelId) {
        return parcelMap.containsKey(parcelId);
    }
}
