import java.util.*;

public class AdminPanel {
    List<RegisteredUsers> registeredUsers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    
    public void userManagementOptions() {
        int choice = 0;
        
        do {
            System.out.println("Welcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");
            System.out.print("Choose: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); 
            
            if(choice == 1) {
                addNewUsers();
            } else if(choice == 2) {
                viewRegisteredUsers();
            } else if(choice == 3) {
                removeRegisteredUsers();
            } else if(choice == 4) {
                updateRegisteredUsers();
            } else if(choice == 5) {
                System.out.println("Bye");
            } else {
                System.out.println("Invalid choice. Please try again");
            }
        } while(choice != 5);
    }
    
    private void addNewUsers() {
        System.out.print("How many users? ");
        int count = scanner.nextInt();
        scanner.nextLine();
        
        for(int u = 0; u < count; u++) {
            System.out.println("\n--- User " + (u+1) + " ---");
            
            System.out.print("Full name: ");
            String name = scanner.nextLine();
            
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Date of birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();
            
            System.out.print("Card number: ");
            long cardNum = scanner.nextLong();
            scanner.nextLine();
            
            System.out.print("Card provider: ");  
            String provider = scanner.nextLine();
            
            System.out.print("Card expiry date (MM/YY): "); 
            String expiry = scanner.nextLine();
            
            System.out.print("CVV: ");
            int cvvNum = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("User type: ");
            String type = scanner.nextLine();
            
           
            String[] trips = new String[3];
            for(int t = 0; t < 3; t++) {
                System.out.println("\n  Trip " + (t+1) + ":");
                
                System.out.print("  Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                
                System.out.print("  Source: ");
                String src = scanner.nextLine();
                
                System.out.print("  Destination: ");
                String dest = scanner.nextLine();
                
                System.out.print("  Fare: ");
                String fare = scanner.nextLine();
                
                System.out.print("  Feedback (NULL if none): ");
                String fb = scanner.nextLine();
                if(fb.isEmpty()) fb = "NULL";
                
                
                StringBuilder sb = new StringBuilder();
                sb.append("Date:");
                sb.append(date);
                sb.append(",Source:");
                sb.append(src);
                sb.append(",Destination:");
                sb.append(dest);
                sb.append(",Fare:");
                sb.append(fare);
                sb.append(",Feedback:");
                sb.append(fb);
                
                trips[t] = sb.toString();  
            }
            
           
            RegisteredUsers newUser = new RegisteredUsers(name, email, dob, cardNum, 
                                                          expiry, provider, cvvNum, type, trips);
            registeredUsers.add(newUser);
            System.out.println("User added.");
        }
    }
    
    private void viewRegisteredUsers() {
        if(registeredUsers.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }
        
        for(RegisteredUsers user : registeredUsers) {
            System.out.println(user);
            System.out.println("---");
        }
    }
    
    private void removeRegisteredUsers() {
        if(registeredUsers.isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }
        
        System.out.print("Enter email to remove: ");
        String email = scanner.nextLine();
        
        boolean found = false;
        Iterator<RegisteredUsers> it = registeredUsers.iterator(); 
        while(it.hasNext()) {
            RegisteredUsers user = it.next();
            if(user.getEmailAddress().equals(email)) {
                it.remove(); 
                System.out.println("Removed user: " + email);
                found = true;
                break;
            }
        }
        
        if(!found) {
            System.out.println("No user found with this email address");
        }
    }
    
    private void updateRegisteredUsers() {
        if(registeredUsers.isEmpty()) {
            System.out.println("No registered users to remove"); 
            return;
        }
        
        System.out.print("Enter email to update: ");
        String email = scanner.nextLine();
        
        boolean found = false;
        for(RegisteredUsers user : registeredUsers) {
            if(user.getEmailAddress().equals(email)) {
                found = true;
                
               
                System.out.print("Type new full name:(Press ENTER for no change)");
                String newName = scanner.nextLine();
                if(!newName.isEmpty()) {
                    user.setFullName(newName);
                }
                
                System.out.print("Type new email:(Press ENTER for no change)");
                String newEmail = scanner.nextLine();
                if(!newEmail.isEmpty()) {
                    user.setEmailAddress(newEmail);
                }
                
                System.out.print("Type new date of birth:(Press ENTER for no change)");
                String newDob = scanner.nextLine();
                if(!newDob.isEmpty()) {
                    user.setDateOfBirth(newDob);
                }
                
                System.out.print("Type new card number:(Enter 0 for no change)");
                String cardStr = scanner.nextLine();
                if(!cardStr.equals("0")) {
                    user.setCardNumber(Long.parseLong(cardStr));
                }
                
                System.out.print("Type new card provider:(Press ENTER for no change)");
                String newProv = scanner.nextLine();
                if(!newProv.isEmpty()) {
                    user.setCardProvider(newProv);
                }
                
                System.out.print("Type new card expiry date:(Press ENTER for no change)");
                String newExp = scanner.nextLine();
                if(!newExp.isEmpty()) {
                    user.setCardExpiryDate(newExp);
                }
                
                System.out.print("Type new CVV:(Enter 0 for no change)");
                String cvvStr = scanner.nextLine();
                if(!cvvStr.equals("0")) {
                    user.setCvv(Integer.parseInt(cvvStr));
                }
                
                System.out.print("Type new user type:(Press ENTER for no change)");
                String newType = scanner.nextLine();
                if(!newType.isEmpty()) {
                    user.setUserType(newType);
                }
                
                System.out.println("User updated.");
                break;
            }
        }
        
        if(!found) {
            System.out.println("No user found with this email address");
        }
    }
}