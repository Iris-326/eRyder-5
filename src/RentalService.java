import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Iterator;

public class RentalService {

    private static final double BASE_FARE = 3.0;
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private LinkedList<ERyderLog> systemLogs = new LinkedList<>();
    private RegisteredUsers currentUser;

    public void startRental(String bikeID, String userEmail) {
        ActiveRental newRental = new ActiveRental(bikeID, userEmail, LocalDateTime.now());
        activeRentalsList.add(newRental);
        System.out.println("Rental started for bike: " + bikeID);
        ERyderLog log = new ERyderLog("BR" + System.currentTimeMillis(), "Bike with " + bikeID + " was rented by " + userEmail + " from " + "location" + " at " + LocalDateTime.now(), LocalDateTime.now());
        systemLogs.push(log);
    }

    public void cancelRental(String bikeID) {
        endRental(bikeID);
        System.out.println("Rental cancelled for bike: " + bikeID);
    }

    public void trackActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental rental : activeRentalsList) {
                System.out.println(rental);
            }
        }
    }

    public void viewSystemLogs() {
        if (systemLogs.isEmpty()) {
            System.out.println("No system logs available.");
        } else {
            for (ERyderLog log : systemLogs) {
                System.out.println(log);
            }
        }
    }
    
    public void simulateApplicationInput(RegisteredUsers user) {
        this.currentUser = user;
        System.out.println("Application input simulated for user: " + user.getFullName());
        user.displayUserType();
    }
    
    public void endRental(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                System.out.println("Rental ended for bike: " + bikeID);
                ERyderLog log = new ERyderLog("TE" + System.currentTimeMillis(), "Trip ended for bike: " + bikeID, LocalDateTime.now());
                systemLogs.push(log);
                if (currentUser != null) {
                    double fare = currentUser.calculateFare(BASE_FARE);
                    System.out.println("Calculated fare: " + fare);
                }
                break;
            }
        }
    }
}