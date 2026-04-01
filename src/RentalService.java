// 类：RentalService
// 职责：管理租赁的开始、结束、取消和跟踪
// 注意：本类基于BikeRental类中原有的相关方法逻辑重构而来
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Iterator;

public class RentalService {

    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public void startRental(String bikeID, String userEmail) {
        ActiveRental newRental = new ActiveRental(bikeID, userEmail, LocalDateTime.now());
        activeRentalsList.add(newRental);
        System.out.println("Rental started for bike: " + bikeID);
    }

    public void endRental(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                System.out.println("Rental ended for bike: " + bikeID);
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
}