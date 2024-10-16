import exceptions.PhoneNumberException;
import validators.MailValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TourManagementSystem {
    Scanner s = new Scanner(System.in);

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Tour> tours = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public void addCustomer() {
        System.out.print("Enter your customer name: ");
        String name = s.next();
        System.out.print("Enter your customer email: ");
        String email = s.next();
        System.out.print("Enter your customer phone number: ");
        String phone = s.next();

        if(phone.length()==11){
            // pass
        }else{
            throw new PhoneNumberException("Invalid phone number!!");
        }
        MailValidator mv = new MailValidator(email);
        mv.validate();

        Customer customer = new Customer(name, email, phone);
        customers.add(customer);
        System.out.println("Customer added: " + name);
        System.out.println();
    }

    public void addTour() {
        System.out.print("Enter your Destination: ");
        String destination = s.next();
        System.out.print("Enter price to go to tour at " + destination + " (In dollars): ");
        double price = s.nextDouble();
        System.out.print("Enter the duration of your tour(In days): ");
        int duration = s.nextInt();

        Tour tour = new Tour(destination, price, duration);
        tours.add(tour);
        System.out.println("Tour to " + destination + " added successfully.");
    }

    public void bookTour() {
        System.out.print("Enter your customer name: ");
        String customerName = s.next();
        System.out.print("Enter your destination: ");
        String destination = s.next();

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

    public void cancelBooking() {
        System.out.print("Enter your customer name: ");
        String customerName = s.next();
        System.out.print("Enter your destination: ");
        String destination = s.next();

        for (Booking booking : bookings) {
            if (booking.customer.getName().equals(customerName) && booking.tour.getDestination().equals(destination)) {
                booking.cancelBooking();
                System.out.println("Booking cancelled for " + customerName + " to " + destination);
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    public void processPayment() {
        System.out.print("Enter amount: ");
        double amount = s.nextDouble();
        System.out.print("Enter credit card number: ");
        String cardNumber = s.next();

        Payment payment = new CreditCardPayment(amount, cardNumber);
        payment.processPayment();
    }

    public void displayBookings() {
        for (Booking booking : bookings) {
            booking.displayBookingInfo();
            System.out.println();
        }
    }

    private Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    private Tour findTourByDestination(String destination) {
        for (Tour tour : tours) {
            if (tour.getDestination().equals(destination)) {
                return tour;
            }
        }
        return null;
    }
}
