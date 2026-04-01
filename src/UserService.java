import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

public class UserService {
    private List<RegisteredUsers> userList;

    public UserService(List<RegisteredUsers> userList) {
        this.userList = userList;
    }

    public void addUser(RegisteredUsers newUser) {
        userList.add(newUser);
        System.out.println("User added.");
    }

    public void removeUser(String email) {
        boolean found = false;
        Iterator<RegisteredUsers> it = userList.iterator();
        while (it.hasNext()) {
            RegisteredUsers user = it.next();
            if (user.getEmailAddress().equals(email)) {
                it.remove();
                System.out.println("Removed user: " + email);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    public void updateUser(String email, Scanner scanner) {
        boolean found = false;
        for (RegisteredUsers user : userList) {
            if (user.getEmailAddress().equals(email)) {
                found = true;

                System.out.print("Type new full name:(Press ENTER for no change)");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    user.setFullName(newName);
                }

                System.out.print("Type new email:(Press ENTER for no change)");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty()) {
                    user.setEmailAddress(newEmail);
                }

                System.out.print("Type new date of birth:(Press ENTER for no change)");
                String newDob = scanner.nextLine();
                if (!newDob.isEmpty()) {
                    user.setDateOfBirth(newDob);
                }

                System.out.print("Type new card number:(Enter 0 for no change)");
                String cardStr = scanner.nextLine();
                if (!cardStr.equals("0")) {
                    user.setCardNumber(Long.parseLong(cardStr));
                }

                System.out.print("Type new card provider:(Press ENTER for no change)");
                String newProv = scanner.nextLine();
                if (!newProv.isEmpty()) {
                    user.setCardProvider(newProv);
                }

                System.out.print("Type new card expiry date:(Press ENTER for no change)");
                String newExp = scanner.nextLine();
                if (!newExp.isEmpty()) {
                    user.setCardExpiryDate(newExp);
                }

                System.out.print("Type new CVV:(Enter 0 for no change)");
                String cvvStr = scanner.nextLine();
                if (!cvvStr.equals("0")) {
                    user.setCvv(Integer.parseInt(cvvStr));
                }

                System.out.print("Type new user type:(Press ENTER for no change)");
                String newType = scanner.nextLine();
                if (!newType.isEmpty()) {
                    user.setUserType(newType);
                }

                System.out.println("User updated.");
                break;
            }
        }
        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    public void retrieveUsers() {
        if (userList.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }
        for (RegisteredUsers user : userList) {
            System.out.println(user);
            System.out.println("---");
        }
    }
}