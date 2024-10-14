import java.util.ArrayList;
import java.util.List;

public class TourManagementSystem {
    private List<Customer> customers = new ArrayList<>();
    private List<Tour> tours = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    // Add a new customer
    public void addCustomer(String name, String email, String phone) {
        Customer customer = new Customer(name, email, phone);
        customers.add(customer);
        System.out.println("Customer added: " + name);
    }

    // Add a new tour
    public void addTour(String destination, double price, int duration) {
        Tour tour = new Tour(destination, price, duration);
        tours.add(tour);
        System.out.println("Tour to " + destination + " added successfully.");
    }

    // Book a tour for a customer
    public void bookTour(String customerName, String destination) {
        Customer customer = findCustomerByName(customerName);
        Tour tour = findTourByDestination(destination);

        if (customer != null && tour != null) {
            Booking booking = new Booking(customer, tour);
            bookings.add(booking);
            System.out.println("Tour booked: " + destination + " for customer " + customerName);
        } else {
            System.out.println("Customer or Tour not found.");
        }
    }

    // Cancel a booking
    public void cancelBooking(String customerName, String destination) {
        for (Booking booking : bookings) {
            if (booking.customer.getName().equals(customerName) && booking.tour.getDestination().equals(destination)) {
                booking.cancelBooking();
                System.out.println("Booking cancelled for " + customerName + " to " + destination);
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    // Process a payment
    public void processPayment(double amount, String cardNumber) {
        Payment payment = new CreditCardPayment(amount, cardNumber);
        payment.processPayment();
    }

    // Display all bookings
    public void displayBookings() {
        for (Booking booking : bookings) {
            booking.displayBookingInfo();
            System.out.println();
        }
    }

    // Helper method to find customer by name
    private Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    // Helper method to find tour by destination
    private Tour findTourByDestination(String destination) {
        for (Tour tour : tours) {
            if (tour.getDestination().equals(destination)) {
                return tour;
            }
        }
        return null;
    }
}
