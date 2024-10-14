public class Payment {
    protected double amount;
    protected String paymentMethod;

    // Constructor
    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    // Method to process payment (base implementation)
    public void processPayment() {
        System.out.println("Processing payment of $" + amount + " using " + paymentMethod);
    }
}
