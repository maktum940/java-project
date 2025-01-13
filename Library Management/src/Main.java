import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();

        system.initialize();

        Scanner s = new Scanner(System.in);

        System.out.println("\nLibrary Management System");
        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Display All Users Info");
            System.out.println("3. Display Basic Users Info");
            System.out.println("4. Add Books");
            System.out.println("5. Display Books Info");
            System.out.println("6. Checkout Books");
            System.out.println("999. Test");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = s.nextInt();// Consume newline

            switch (choice) {
                case 1:
                    system.addUser();
                    break;
                case 2:
                    system.displayUsersDetailInfo();
                    break;
                case 3:
                    system.displayUsersBasicInfo();
                    break;
                case 4:
                    system.addBooks();
                    break;
                case 5:
                    system.displayBooks();
                    break;
                case 6:
                    system.giveBooksToUser();
                    break;
//                case 999:
//                    system.test();
//                    break;
                case 0:
                    System.out.println("Exiting...");
                    s.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}