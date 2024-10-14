public class Booking {
    protected Customer customer;
    protected Tour tour;
    protected String status;

    // Constructor
    public Booking(Customer customer, Tour tour) {
        this.customer = customer;
        this.tour = tour;
        this.status = "Confirmed"; // default booking status
    }

    // Method to cancel booking
    public void cancelBooking() {
        this.status = "Cancelled";
    }

    // Display booking information
    public void displayBookingInfo() {
        System.out.println("Booking Information:");
        customer.displayCustomerInfo();
        tour.displayTourInfo();
        System.out.println("Booking Status: " + status);
    }
}
