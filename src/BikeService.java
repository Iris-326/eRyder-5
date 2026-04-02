import java.time.LocalDateTime;
import java.util.Queue;
import java.util.ArrayDeque;

public class BikeService {

    private Queue<BikeRequest> bikeRequest = new ArrayDeque<>();

    public String findAvailableBike(String location, String userEmail) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested.");
        addToRequestQueue(userEmail, location);
        return null;
    }

    public void addToRequestQueue(String userEmail, String location) {
        BikeRequest request = new BikeRequest(userEmail, location, LocalDateTime.now());
        bikeRequest.offer(request);
        System.out.println("Your request has been added to the queue.");
    }

    public boolean validateLocation(String location, String userEmail) {
        return findAvailableBike(location, userEmail) != null;
    }

    public void reserveBike(String bikeID, String userEmail, String location) {
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
            BikeRequest request = new BikeRequest(userEmail, location, LocalDateTime.now());
            bikeRequest.offer(request);
            System.out.println("Your request has been added to the queue.");
        }
    }

    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Bike " + bikeID + " has been released and is now available.");
                removeTrip();
                break;
            }
        }
    }

    public void removeTrip() {
        if (!bikeRequest.isEmpty()) {
            BikeRequest nextRequest = bikeRequest.poll();
            System.out.println("Assigning bike to next user: " + nextRequest.getUserEmail() + " at " + nextRequest.getLocation());
        }
    }

    public void viewRequestQueue() {
        if (bikeRequest.isEmpty()) {
            System.out.println("No pending bike requests.");
        } else {
            for (BikeRequest request : bikeRequest) {
                System.out.println(request);
            }
        }
    }

    public void updateRequestQueue() {
        if (!bikeRequest.isEmpty()) {
            BikeRequest nextRequest = bikeRequest.poll();
            System.out.println("Removed request: " + nextRequest);
        } else {
            System.out.println("No pending bike requests to update.");
        }
    }
}