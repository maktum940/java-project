public class Customer extends Person {

    public Customer(String name, String email, String phone) {
        super(name, email, phone);
    }

    public void displayCustomerInfo() {
        System.out.println("Customer Information:");
        displayPersonInfo();
    }
}
