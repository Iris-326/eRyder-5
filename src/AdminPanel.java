import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {
    List<RegisteredUsers> registeredUsers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService(registeredUsers);
    BikeService bikeService = new BikeService();
    RentalService rentalService = new RentalService();

    public void userManagementOptions() {
        int choice = 0;
        do {
            System.out.println("Welcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. View System Logs");
            System.out.println("6. Manage Pending Bike Requests");
            System.out.println("7. EXIT");
            System.out.print("Choose: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Add New Users logic should be here, calling UserService.");
                    break;
                case 2:
                    userService.retrieveUsers();
                    break;
                case 3:
                    System.out.print("Enter email to remove: ");
                    String emailToRemove = scanner.nextLine();
                    userService.removeUser(emailToRemove);
                    break;
                case 4:
                    System.out.print("Enter email to update: ");
                    String emailToUpdate = scanner.nextLine();
                    userService.updateUser(emailToUpdate, scanner);
                    break;
                case 5:
                    rentalService.viewSystemLogs();
                    break;
                case 6:
                    managePendingBikeRequests();
                    break;
                case 7:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 7);
    }

    public void managePendingBikeRequests() {
        int choice = 0;
        do {
            System.out.println("Manage Pending Bike Requests");
            System.out.println("1. View Queue");
            System.out.println("2. Update Queue");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bikeService.viewRequestQueue();
                    break;
                case 2:
                    bikeService.updateRequestQueue();
                    break;
                case 3:
                    System.out.println("Exiting Manage Pending Bike Requests");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 3);
    }
}