import java.time.LocalDateTime;

public class BikeService {

    public String findAvailableBike(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested.");
        return null;
    }

    public boolean validateLocation(String location) {
        return findAvailableBike(location) != null;
    }

    public void reserveBike(String bikeID, String userEmail) {
        if (bikeID != null) {
            for (Bike bike : BikeDatabase.bikes) {
                if (bike.getBikeID().equals(bikeID)) {
                    LocalDateTime now = LocalDateTime.now();
                    bike.setIsAvailable(false);
                    bike.setLastUsedTime(now);
                    System.out.println("Reserving the bike with the ID: " + bikeID);
                    break;
                }
            }
        } else {
            System.out.println("Sorry, we're unable to reserve a bike at this time.");
        }
    }

    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Bike " + bikeID + " has been released and is now available.");
                break;
            }
        }
    }
}