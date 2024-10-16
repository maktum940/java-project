public class CreditCardPayment extends Payment {

    private String cardNumber;

    public CreditCardPayment(double amount, String cardNumber) {
        super(amount, "Credit Card");
        this.cardNumber = cardNumber;
    }

    public void processPayment() {
        System.out.println("Processing Credit Card payment of $" + amount);
        System.out.println("Card Number: " + cardNumber);
    }
}
