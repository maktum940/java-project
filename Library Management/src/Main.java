import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();

        system.initialize();

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add User");
            System.out.println("2. Display All Users Info");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = s.nextInt();// Consume newline

            switch (choice) {
                case 1:
                    system.addUser();
                    break;
                case 2:
                    system.displayUsersInfo();
                    break;
                case 3:
                    system.addBooks();
                    break;
                case 4:
                    system.displayBooks();
                    break;
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