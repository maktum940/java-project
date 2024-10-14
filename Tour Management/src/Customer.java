public class Customer extends Person {

    // Constructor
    public Customer(String name, String email, String phone) {
        super(name, email, phone);
    }

    // Display Customer Info (inherits from Person)
    public void displayCustomerInfo() {
        System.out.println("Customer Information:");
        displayPersonInfo();
    }
}
