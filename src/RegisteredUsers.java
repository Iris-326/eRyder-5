public class RegisteredUsers {
    String fullName;
    String emailAddress;
    String dateOfBirth;
    long cardNumber;
    String cardExpiryDate;
    String cardProvider;
    int cvv;
    String userType;
    String[] lastThreeTrips = new String[3];
    
    
    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth, long cardNumber,
                          String cardExpiryDate, String cardProvider, int cvv, String userType, String[] lastThreeTrips) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardProvider = cardProvider;
        this.cvv = cvv;
        this.userType = userType;
        this.lastThreeTrips = lastThreeTrips;
    }
    
    public String getFullName() { return fullName; }
    public String getEmailAddress() { return emailAddress; }
    public String getDateOfBirth() { return dateOfBirth; }
    public long getCardNumber() { return cardNumber; }
    public String getCardExpiryDate() { return cardExpiryDate; }
    public String getCardProvider() { return cardProvider; }
    public int getCvv() { return cvv; }
    public String getUserType() { return userType; }
    public String[] getLastThreeTrips() { return lastThreeTrips; }
    
    public void setFullName(String f) { fullName = f; }
    public void setEmailAddress(String e) { emailAddress = e; }
    public void setDateOfBirth(String d) { dateOfBirth = d; }
    public void setCardNumber(long c) { cardNumber = c; }
    public void setCardExpiryDate(String c) { cardExpiryDate = c; }
    public void setCardProvider(String c) { cardProvider = c; }
    public void setCvv(int c) { cvv = c; }
    public void setUserType(String u) { userType = u; }
    public void setLastThreeTrips(String[] t) { lastThreeTrips = t; }
    
    public String toString() {
        String s = "";
        s = s + "Full Name: " + fullName + "\n";
        s = s + "Email: " + emailAddress + "\n";
        s = s + "Date of Birth: " + dateOfBirth + "\n";
        s = s + "Card Number: " + cardNumber + "\n";
        s = s + "Card Expiry: " + cardExpiryDate + "\n";
        s = s + "Card Provider: " + cardProvider + "\n";
        s = s + "CVV: " + cvv + "\n";
        s = s + "User Type: " + userType + "\n";
        s = s + "Last Three Trips:\n";
        for(int i = 0; i < 3; i++) {
            if(lastThreeTrips[i] != null) {
                s = s + "  " + lastThreeTrips[i] + "\n";
            }
        }
        return s;
    }
    
    public double calculateFare(double baseFare) {
        return baseFare;
    }
    
    public void displayUserType() {
        System.out.println("Regular User");
    }
}