import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class LibraryManagementSystem {
//    Scanner s = new Scanner(System.in);

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    public void addUser() {
//        String name = s.next();
//        String road = s.next();
//        String city = s.next();
//        String house = s.next();
//        String email = s.next();
//        String phone = s.next();

        String name, road, city, house, email, phone;

        name = "Maktum1";
        road = "123/1";
        city = "Dhaka1";
        house = "House_1";
        email = "Email_1";
        phone = "Phone_1";
        
        Address address = new Address(road, house, city);
        Contact contact = new Contact(email, phone);
        User user = new User(name, address, contact);
        users.add(user);

        name = "Maktum2";
        road = "123/2";
        city = "Dhaka";
        house = "House_2";
        email = "Email_2";
        phone = "Phone_2";

        address = new Address(road, house, city);
        contact = new Contact(email, phone);
        user = new User(name, address, contact);
        users.add(user);

        name = "Maktum3";
        road = "123/3";
        city = "Dhaka_3";
        house = "House_3";
        email = "Email_3";
        phone = "Phone_3";

        address = new Address(road, house, city);
        contact = new Contact(email, phone);
        user = new User(name, address, contact);
        users.add(user);

        name = "Makutm4";
        road = "123/4";
        city = "Dhaka_4";
        house = "House_4";
        email = "Email_4";
        phone = "Phone_4";

        address = new Address(road, house, city);
        contact = new Contact(email, phone);
        user = new User(name, address, contact);
        users.add(user);

        name = "Makutm5";
        road = "123/5";
        city = "Dhaka_5";
        house = "House_5";
        email = "Email_5";
        phone = "Phone_5";

        address = new Address(road, house, city);
        contact = new Contact(email, phone);
        user = new User(name, address, contact);
        users.add(user);
    }

    public void addBooks() {
        String title, author, type;
        ArrayList<String> genres = new ArrayList<>();
        int ID;

        //1
        title = "Solo Leveling";
        author = "Sung-Lak Jang";
        type = "manhwa";
        Collections.addAll(genres, "Action", "Adventure", "Fantasy");
        ID = 10001;

        Book book = new Book(title, author, genres, ID);
        books.add(book);

        //2
        title = "Bleach";
        author = "Kubo Tite";
        type = "manga";
        Collections.addAll(genres, "Action", "Adventure", "Fantasy", "Comedy", "Drama", "Horror");
        ID = 10002;

        book = new Book(title, author, genres, ID);
        books.add(book);

        //3
        title = "Gulliver's Travels";
        author = "Jonathan Swift";
        Collections.addAll(genres, "science fiction", "Adventure", "Fantasy", "Comedy");
        ID = 10003;

        book = new Book(title, author, genres, ID);
        books.add(book);

        //4
        title = "The Art of War";
        author = "sun tzu";
        type = "book";
        Collections.addAll(genres, "military strategy");
        ID = 10004;

        book = new Book(title, author, genres, ID);
        books.add(book);

        //5
        title = "Noblesse";
        author = "Kubo Tite";
        type = "manhwa";
        Collections.addAll(genres, "Action", "Adventure", "Fantasy", "Comedy", "Drama", "Horror");
        ID = 10004;

        book = new Book(title, author, genres, ID);
        books.add(book);

        //6
        title = "Bleach";
        author = "Kubo Tite";
        type = "manhwa";
        Collections.addAll(genres, "Action", "Adventure", "Fantasy", "Comedy", "Drama", "Horror");
        ID = 10004;

        book = new Book(title, author, genres, ID);
        books.add(book);

        //7
        title = "Bleach";
        author = "Kubo Tite";
        type = "manhwa";
        Collections.addAll(genres, "Action", "Adventure", "Fantasy", "Comedy", "Drama", "Horror");
        ID = 10004;

        book = new Book(title, author, genres, ID);
        books.add(book);

        //8
        title = "Bleach";
        author = "Kubo Tite";
        type = "manhwa";
        Collections.addAll(genres, "Action", "Adventure", "Fantasy", "Comedy", "Drama", "Horror");
        ID = 10004;

        book = new Book(title, author,genres, ID);
        books.add(book);

        //9
        title = "Bleach";
        author = "Kubo Tite";
        type = "manhwa";
        Collections.addAll(genres, "Action", "Adventure", "Fantasy", "Comedy", "Drama", "Horror");
        ID = 10004;

        book = new Book(title, author, genres, ID);
        books.add(book);

        //10
        title = "Bleach";
        author = "Kubo Tite";
        type = "manhwa";
        Collections.addAll(genres, "Action", "Adventure", "Fantasy", "Comedy", "Drama", "Horror");
        ID = 10004;

        book = new Book(title, author, genres, ID);
        books.add(book);
    }

    public void displayUsersInfo() {
        for (User user : users) {
            user.displayUserInfo();
            System.out.println();
        }
    }

}
