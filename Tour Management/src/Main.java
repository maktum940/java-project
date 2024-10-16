import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean temp = true;
        int a;

        System.out.println("Tour management system.");

        TourManagementSystem system = new TourManagementSystem();

        while (temp){
            Scanner s = new Scanner(System.in);
            System.out.println("1. Add Customer.");
            System.out.println("2. Add Tour.");
            System.out.println("3. Book Tour.");
            System.out.println("4. Display Booking.");
            System.out.println("5. Cancel Booking.");
            System.out.println("6. Process Payment.");
            System.out.println("0. Exit");

            System.out.println();
            System.out.print("Enter your choice: ");
            a = s.nextInt();
            switch (a){
                case 1:
                    system.addCustomer();
                    break;
                case 2:
                    system.addTour();
                    break;
                case 3:
                    system.bookTour();
                    break;
                case 4:
                    system.displayBookings();
                    break;
                case 5:
                    system.cancelBooking();
                    break;
                case 6:
                    system.processPayment();
                    break;
                case 0:
                    temp = false;
                    break;
            }
        }
    }
}
