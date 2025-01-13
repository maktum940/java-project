import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LibraryManagementSystem {
    Scanner s = new Scanner(System.in);

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    public void initialize() {
        // initializing all the data like 5 users and 11 books.
        //-------------------------------------------user initializing-------------------------------------------//
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

        //---------------------------------------------book initializing--------------------------------------//
        Book book = new Book("Gulliver's Travels", "Jonathan Swift", "Adventure", true, 1001);
        books.add(book);

        book = new Book("The Art of War", "sun tzu", "military strategy", true, 1002);
        books.add(book);

        book = new Book("Harry Potter", "Joanne Rowling", "Fantasy", true, 1003);
        books.add(book);

        book = new Book("Game of Thrones", "George Raymond Martin", "Fantasy", true, 1004);
        books.add(book);

        book = new Book("Java: The Complete Reference", "Herbert Schildt", "Computer Science", true, 1005);
        books.add(book);

        book = new Book("The C++ Programming Language", "Bjarne Stroustrup", "Computer Science", true, 1006);
        books.add(book);

        book = new Book("Pattern Recognition and Machine Learning", "Christopher M. Bishop", "Computer Science", true, 1007);
        books.add(book);

        book = new Book("The Laws of Human Nature", "Robert Greene", "psychology", true, 1008);
        books.add(book);

        book = new Book("The Old Man and The Sea", "Ernest Hemingway", "Adventure", true, 1009);
        books.add(book);

        book = new Book("Lights Of Reality", "Said Nursi", "religions", true, 1010);
        books.add(book);

        book = new Book("The Art of Thinking Clearly", "Rolf Dobelli", "non-fiction", true, 1011);
        books.add(book);

        //----------------------------------------------Giving Books to user---------------------------------//
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
        System.out.print("Enter the name of the book: ");
        String title = s.nextLine();
        System.out.print("Enter the author name: ");
        String author = s.nextLine();
        System.out.print("Enter all the genre the book belongs to: ");
        String genre = s.nextLine();
        boolean available = true;
        int temp = books.size()-1;
        int id = books.get(temp).getId()+1;

        Book book = new Book(title, author, genre, available, id);
        books.add(book);
    }

//    public void test() {
//        ArrayList<Book> tempBooks = new ArrayList<>();
//        Collections.addAll(tempBooks, books.get(0), books.get(1));
//        books.get(0).setAvailable(false);
//        books.get(0).setGivenTo(users.get(0).getName());
//        books.get(1).setAvailable(false);
//        books.get(1).setGivenTo(users.get(0).getName());
//        users.get(0).setTakenBooks(tempBooks);
//    }
    public void giveBooksToUser() {
        System.out.flush();
        ArrayList<Book> tempBooks = new ArrayList<>();

        System.out.print("Enter the user name: ");
        String name = s.nextLine();
        displayBooksId();
        System.out.print("Enter the book id that user want (ex: 1002 1005 1003): ");
        String idInSting = s.nextLine();
        ArrayList<Integer> idList = stringToInt(idInSting);
        System.out.println("Giving " + idList.size() + " books to " + name);

        for (Integer integer : idList) {
            for (Book book : books) {
                if (integer == book.getId()) {
                    tempBooks.add(book);
                    book.setAvailable(false);
                    book.setGivenTo(name);
                }
            }
        }
        for (User user : users) {
            if (user.getName().equals(name)) {
                user.setTakenBooks(tempBooks);
            }
        }
    }


    public void displayUsersBasicInfo() {
        for (User user : users) {
            user.displayBasicUserInfo();
            System.out.println();
        }
    }
    public void displayUsersDetailInfo() {
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
    public void displayBooksId() {
        for (Book book : books) {
            book.displayBooksId();
            System.out.println();
        }
    }
    public ArrayList<Integer> stringToInt(String str) {
        String[] numbers = str.split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String number : numbers) {
            arrayList.add(Integer.parseInt(number));
        }
        return arrayList;
    }
}
