public class Payment {
    protected double amount;
    protected String paymentMethod;

    //constructor
    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    //display
    public void processPayment() {
        System.out.println("Processing payment of $" + amount + " using " + paymentMethod);
    }
}
