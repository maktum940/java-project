import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class LibraryManagementSystem {
    Scanner s = new Scanner(System.in);

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    public void initialize() {
        // initializing all the data like 5 users and 11 books.
        //user initializing
        Address address = new Address("123/1", "House_1", "Dhaka1");
        Contact contact = new Contact("Email_1", "Phone_1");
        User user = new User("Maktum1", address, contact);
        users.add(user);

        address = new Address("123/2", "House_2", "Dhaka2");
        contact = new Contact("Email_2", "Phone_2");
        user = new User("Maktum2", address, contact);
        users.add(user);

        address = new Address("123/3", "House_3", "Dhaka3");
        contact = new Contact("Email_3", "Phone_3");
        user = new User("Maktum3", address, contact);
        users.add(user);

        address = new Address("123/4", "House_4", "Dhaka4");
        contact = new Contact("Email_4", "Phone_4");
        user = new User("Maktum4", address, contact);;
        users.add(user);

        address = new Address("123/5", "House_5", "Dhaka5");
        contact = new Contact("Email_5", "Phone_5");
        user = new User("Maktum5", address, contact);
        users.add(user);

        //book initializing
        ArrayList<String> genres = new ArrayList<>();

        Collections.addAll(genres, "science fiction", "Adventure", "Fantasy", "Comedy");
        Book book = new Book("Gulliver's Travels", "Jonathan Swift", genres, true, 1);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("The Art of War", "sun tzu", genres, true, 2);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("Harry Potter", "Joanne Rowling", genres, true, 3);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("Game of Thrones", "George Raymond Martin", genres, true, 4);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("Java: The Complete Reference", "Herbert Schildt", genres, true, 5);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("The C++ Programming Language", "Bjarne Stroustrup", genres, true, 6);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("Pattern Recognition and Machine Learning", "Christopher M. Bishop", genres, true, 7);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("The Laws of Human Nature", "Robert Greene", genres, true, 8);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("The Old Man and The Sea", "Ernest Hemingway", genres, true, 9);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("Lights Of Reality", "Said Nursi", genres, true, 10);
        books.add(book);

        Collections.addAll(genres, "military strategy");
        book = new Book("The Art if Thinking Clearly", "Rolf Dobelli", genres, true, 11);
        books.add(book);
    }

    public void addUser() {
        System.out.print("Enter the name of the user: ");
        String name = s.nextLine();
        System.out.print("Enter your city name: ");
        String city = s.nextLine();
        System.out.print("Enter your road: ");
        String road = s.nextLine();
        System.out.print("Enter your house number: ");
        String house = s.nextLine();
        System.out.print("Enter your email: ");
        String email = s.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = s.nextLine();

        Address address = new Address(road, house, city);
        Contact contact = new Contact(email, phone);
        User user = new User(name, address, contact);
        users.add(user);
    }

    public void addBooks() {

    }

    public void displayUsersInfo() {
        for (User user : users) {
            user.displayUserInfo();
            System.out.println();
        }
    }
    public void displayBooks() {
        for (Book book : books) {
            book.displayBookInfo();
            System.out.println();
        }
    }
}
