public class Booking {
    protected Customer customer;
    protected Tour tour;
    protected String status;

    //constructor
    public Booking(Customer customer, Tour tour) {
        this.customer = customer;
        this.tour = tour;
        this.status = "Confirmed";
    }

    public void cancelBooking() {
        this.status = "Cancelled";
    }

    public void displayBookingInfo() {
        System.out.println("Booking Information:");
        customer.displayCustomerInfo();
        tour.displayTourInfo();
        System.out.println("Booking Status: " + status);
    }
}
