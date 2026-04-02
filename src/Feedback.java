public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewId;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.completeFeedback = "";
        this.reviewId = "";
        this.longFeedback = false;
    }

    public void analyseFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5) {
        if (isConcatenation == true) {
            this.completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        } else {
            this.completeFeedback = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5).toString();
        }
        checkFeedbackLength(this.completeFeedback);
        createReviewId(this.firstName, this.lastName, this.completeFeedback);
    }

    private String feedbackUsingConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5) {
        String concatenatedFeedback = sent1 + sent2 + sent3 + sent4 + sent5;
        return concatenatedFeedback;
    }

    private StringBuilder feedbackUsingStringBuilder(String sent1, String sent2, String sent3, String sent4, String sent5) {
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(sent2).append(sent3).append(sent4).append(sent5);
        return sb;
    }

    private boolean checkFeedbackLength(String completeFeedback) {
        if (completeFeedback.length() > 500) {
            this.longFeedback = true;
        } else {
            this.longFeedback = false;
        }
        return this.longFeedback;
    }

    private void createReviewId(String firstName, String lastName, String completeFeedback) {
        String part1 = (firstName + lastName).substring(2, 6).toUpperCase();
        String part2 = completeFeedback.substring(10, 15).toLowerCase();
        long timestamp = System.currentTimeMillis();
        this.reviewId = part1 + part2 + "_" + timestamp;
        this.reviewId = this.reviewId.replace(" ", "");
    }

    public String toString() {
        return "First Name: " + firstName + "\n" +
               "Last Name: " + lastName + "\n" +
               "Email: " + email + "\n" +
               "Complete Feedback: " + completeFeedback + "\n" +
               "Long Feedback: " + longFeedback + "\n" +
               "Review ID: " + reviewId;
    }
}
