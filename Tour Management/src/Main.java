public class Main {
    public static void main(String[] args) {
        TourManagementSystem system = new TourManagementSystem();

        // Add some customers and tours
        system.addCustomer("Alice", "alice@example.com", "123456789");
        system.addCustomer("Bob", "bob@example.com", "987654321");
        system.addTour("Paris", 1500.0, 7);
        system.addTour("Tokyo", 2000.0, 10);

        // Book tours
        system.bookTour("Alice", "Paris");
        system.bookTour("Bob", "Tokyo");

        // Display bookings
        system.displayBookings();

        // Cancel a booking
        system.cancelBooking("Alice", "Paris");

        // Display bookings after cancellation
        system.displayBookings();

        // Process a payment
        system.processPayment(1500.0, "1234-5678-9876-5432");
    }
}
