public class ERyder {
    private String  bikeID;
    public int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    private final String LINKED_ACCOUNT;
    private final String LINCKED_PHONE_NUMBER;
    private int totalUsageInMinutes;
    private double totalFare;

    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;


    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven, String linkedAccount, String linkedPhoneNumber) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = "user123";
        this.LINCKED_PHONE_NUMBER = "1234567890";
        this.totalUsageInMinutes = 0;
        this.totalFare = 0.0;
    }
    public void ride(){
        if (isAvailable && batteryLevel > 0) {
            System.out.println("The bike is available.");
        } else {
            System.out.println("The bike is not available.");
        }
    }
    public void printBikeDetails() {
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Kilometers Driven: " + kmDriven + " km");
    }
    public String getBikeID() {
        return bikeID;
    }
    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel){
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Battery level must be between 0 and 100.");
        }
    }
    public boolean isAvaliable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public double getKmDriven() {
        return kmDriven;
    }
    public void setKmDriven(double kmDriven){
        this.kmDriven = kmDriven;
    }
    public void printRideDetails() {
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINCKED_PHONE_NUMBER);
        System.out.println("Total Usage in Minutes: " + totalUsageInMinutes);
        System.out.println("Total Fare: $" + totalFare);
    }
    public double calculateFare(int usageInMinutes) {
        return totalFare = BASE_FARE + (PER_MINUTE_FARE * totalUsageInMinutes);
    }
}
