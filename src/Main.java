public class Main {
    public static void main(String[] args)  {
        ERyder bike1 = new ERyder("001", 85, true, 10, "user123", "1234567890");
        bike1.printBikeDetails();
        bike1.printRideDetails();
        bike1.ride();
        System.out.println("Calculating fare for bike1: " + bike1.calculateFare(30) + " dollars");


        ERyder bike2 = new ERyder("002", 32, true, 6, "user456", "0987654321");
        bike2.printBikeDetails();
        bike2.printRideDetails();
        bike2.ride();
        System.out.println("Calculating fare for bike2: " + bike2.calculateFare(30) + " dollars");
    
        String sent1 = "I was very satisfied with the service.";
        String sent2 = "The e-Bike is quite comfortable to ride.";
        String sent3 = "The battery life of the e-Bike is impressive.";
        String sent4 = "The customer support was helpful and responsive.";
        String sent5 = "I would recommend this e-Bike to my friends and family.";
        
        UserRegistration user = new UserRegistration();
        user.registration();
        System.out.println(user);

        Feedback feedback = new Feedback("John", "Doe", "john.doe@example.com");
        feedback.analyseFeedback(true, sent1, sent2, sent3, sent4, sent5); 
        System.out.println(feedback);

        AdminPanel panel = new AdminPanel();
        panel.userManagementOptions(); 
    }
        
}
