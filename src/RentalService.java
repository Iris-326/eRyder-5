import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Iterator;

public class RentalService {

    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private LinkedList<ERyderLog> systemLogs = new LinkedList<>();

    public void startRental(String bikeID, String userEmail) {
        ActiveRental newRental = new ActiveRental(bikeID, userEmail, LocalDateTime.now());
        activeRentalsList.add(newRental);
        System.out.println("Rental started for bike: " + bikeID);
        ERyderLog log = new ERyderLog("BR" + System.currentTimeMillis(), "Bike with " + bikeID + " was rented by " + userEmail + " from " + "location" + " at " + LocalDateTime.now(), LocalDateTime.now());
        systemLogs.push(log);
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
                break;
            }
        }
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
}