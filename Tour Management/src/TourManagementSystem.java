import exceptions.PhoneNumberException;
import validators.MailValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TourManagementSystem {
    Scanner s = new Scanner(System.in);

    private ArrayList<String> tourPlace = new ArrayList<>();
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Tour> tours = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Food> foods = new ArrayList<>();

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
        String fileHotel = "home\\good-night\\Desktop\\code\\java-project\\Tour Management\\src\\info\\hotelInfo.csv";
        String fileFood = "home\\good-night\\Desktop\\code\\java-project\\Tour Management\\src\\info\\foodInfo.csv";

        try{
            hotelFileRead(fileHotel);
        }catch (Exception e){
            System.out.println(e);
        }
        int temp = 1;

        for(String line: tourPlace){
            System.out.println(temp + ". " + line);
            temp++;
        }
        System.out.print("Select your Destination: ");
        int destination = s.nextInt();

        int temp1 = destination*2-2;

        for(int i = 0; i < 2; i++){
            System.out.println(i+1 + ") Hotel: " + hotels.get(temp1+i).getName() + ",");
            System.out.println("   Price: " + hotels.get(temp1+i).getPrice() + "tk per day");
        }
        System.out.println();
        System.out.print("Select your hotel: ");
        int hotelNum = s.nextInt();

        System.out.print("Enter the duration of your tour(In days): ");
        int duration = s.nextInt();


        Tour tour = new Tour(tourPlace.get(destination-1), duration, hotels.get(temp1-1+hotelNum).getName(), hotels.get(hotelNum-1+temp1).getPrice());
        tours.add(tour);

        tours.get(0).displayTourInfo();
        int totalTourCost = hotels.get(hotelNum-1+temp1).getPrice()*duration;

        try{
            foodFileRead(fileFood);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println();
        temp = 1;
        for(Food food: foods){
            System.out.println(temp + ") Food Name: " + food.getName() + "\t, price: " + food.getPrice());
            temp++;
        }
        System.out.println("Enter what food will you get and how much:");
        System.out.println("Example: 0(rice), 0(chicken), 0(beef), 0(curry), 0(fish)");
        System.out.println("Enter: ");

        String foodSelection = s.nextLine();
        String[] parts = foodSelection.split(",");
        double totalFoodCost = 100*Integer.parseInt(parts[0])+200*Integer.parseInt(parts[1])+500*Integer.parseInt(parts[2]);
        totalFoodCost = totalFoodCost+300*Integer.parseInt(parts[3])+ 125*Integer.parseInt(parts[4]);

        if(duration > 3){
            if(totalFoodCost >= 10000){
                System.out.println("You got 25% discount");
                System.out.println("Your food cost was: " + totalFoodCost);
                System.out.println("Now your food cost is: " + totalFoodCost*.25);
                totalFoodCost = totalFoodCost*.25;
            }else if(totalFoodCost >= 8000) {
                System.out.println("You got 20% discount");
                System.out.println("Your food cost was: " + totalFoodCost);
                System.out.println("Now your food cost is: " + totalFoodCost*.2);
                totalFoodCost = totalFoodCost*.2;
            } else if (totalFoodCost >= 6000) {
                System.out.println("You got 15% discount");
                System.out.println("Your food cost was: " + totalFoodCost);
                System.out.println("Now your food cost is: " + totalFoodCost*.15);
                totalFoodCost = totalFoodCost*.15;
            } else if (totalFoodCost >= 4000) {
                System.out.println("You got 10% discount");
                System.out.println("Your food cost was: " + totalFoodCost);
                System.out.println("Now your food cost is: " + totalFoodCost*.1);
                totalFoodCost = totalFoodCost*.10;
            } else if (totalFoodCost >= 2000) {
                System.out.println("You got 5% discount");
                System.out.println("Your food cost was: " + totalFoodCost);
                System.out.println("Now your food cost is: " + totalFoodCost*.05);
                totalFoodCost = totalFoodCost*.05;
            }else{
                System.out.println("Bad luck you didn't get any discount");
                System.out.println("Better luck next time");
            }
        }
        System.out.println("Your total cost is: " + totalTourCost+totalFoodCost);
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

    private void hotelFileRead(String fileHotel) throws IOException {
        Path filePath = Paths.get(fileHotel);
        List<String> csvFileContent = Files.readAllLines(filePath);

        for (String line : csvFileContent) {
            String[] parts = line.split(",");
            tourPlace.add(parts[0]);

            Hotel hotel = new Hotel(parts[1], Integer.parseInt(parts[2]));
            hotels.add(hotel);
            Hotel hotel1 = new Hotel(parts[3], Integer.parseInt(parts[4]));
            hotels.add(hotel1);
        }
    }
    private void foodFileRead(String fileFood) throws IOException {
        Path filePath = Paths.get(fileFood);
        List<String> csvFileContent = Files.readAllLines(filePath);
        for (String line : csvFileContent) {
            String[] parts = line.split(",");
            String foodName = parts[0];
            int price = Integer.parseInt(parts[1]);
            Food food = new Food(foodName, price);
            foods.add(food);
        }
    }
}
