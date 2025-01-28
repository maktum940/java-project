import exceptions.PhoneNumberException;
import validators.MailValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    Scanner s = new Scanner(System.in);

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Log> logs = new ArrayList<>();

    public void initialize() {
        try{
            String fileUser = "C:\\Users\\Masud\\Desktop\\Library Management\\src\\information\\users.csv";
            String fileBook = "C:\\Users\\Masud\\Desktop\\Library Management\\src\\information\\books.csv";
            String fileLog = "C:\\Users\\Masud\\Desktop\\Library Management\\src\\information\\log.csv";
            usersFileRead(fileUser);
            bookFileRead(fileBook);
            logFileRead(fileLog);
        }catch (Exception e){
            System.out.println(e);
        }
        ArrayList<Book> tempBooks = new ArrayList<>();
        ArrayList<Integer> idList = new ArrayList<>();
        Collections.addAll(idList, 1010 ,1020, 1030);
        for (Integer integer : idList) {
            for (Book booktemp : books) {
                if (integer == booktemp.getId()) {
                    tempBooks.add(booktemp);
                    booktemp.setAvailable(false);
                    booktemp.setGivenTo(users.get(0).getName());
                }
            }
        }
        for (User usertemp : users) {
            if (usertemp.getName().equals(users.get(0).getName())) {
                usertemp.setTakenBooks(tempBooks);
            }
        }
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
        MailValidator mv = new MailValidator(email);
        mv.validate();
        System.out.print("Enter your phone number: ");
        String phone = s.nextLine();

        if(phone.length()!=11) {
            throw new PhoneNumberException("Invalid phone number!!");
        }

        Address address = new Address(road, house, city);
        Contact contact = new Contact(email, phone);
        User user = new User(name, address, contact);
        users.add(user);
        try{
            String fileUser = "C:\\Users\\Masud\\Desktop\\Library Management\\src\\information\\users.csv";
            String fileLog = "C:\\Users\\Masud\\Desktop\\Library Management\\src\\information\\log.csv";
            Path fileLogPath = Paths.get(fileLog);
            Path fileUserPath = Paths.get(fileUser);
            String log = "\n"+name;
            Files.writeString(fileLogPath,log, StandardOpenOption.APPEND);
            String content = "\n"+road+","+house+","+city+","+email+","+phone+","+name;
            Files.writeString(fileUserPath,content, StandardOpenOption.APPEND);
        }catch (Exception e){
            System.out.println(e);
        }
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
        int id = books.get(temp).getId()+10;

        try{
            String fileBook = "C:\\Users\\Masud\\Desktop\\Library Management\\src\\information\\books.csv";
            Path filePath = Paths.get(fileBook);
            String content = "\n"+title+","+author+","+genre+",true,"+id;
            Files.writeString(filePath,content, StandardOpenOption.APPEND);
        }catch (Exception e){
            System.out.println(e);
        }
        Book book = new Book(title, author, genre, available, id);
        books.add(book);
    }

    public void giveBooksToUser() {
        ArrayList<Book> tempBooks = new ArrayList<>();

        System.out.print("Enter the user name: ");
        String name = s.nextLine();
        displayBooksId();
        System.out.print("Enter the book id that user want (ex: 1020 1050 1030): ");
        String idInSting = s.nextLine();
        ArrayList<Integer> idList = stringToInt(idInSting);
        System.out.println("Giving " + idList.size() + " books to " + name);

        Log log = new Log(name, idList);
        logs.add(log);

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
        try{
            String fileLog = "C:\\Users\\Masud\\Desktop\\Library Management\\src\\information\\log.csv";
            Path filePath = Paths.get(fileLog);
            String content = "\n"+name+","+idInSting;
            Files.writeString(filePath,content, StandardOpenOption.APPEND);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void givingBackBooks(){
        givenBooks();
        System.out.print("Enter the user name who want to give his book back: ");
        String name = s.nextLine();
        System.out.print("Enter the book id that user giving back (ex: 1020 1050 1030): ");
        String idInSting = s.nextLine();
        ArrayList<Integer> idList = stringToInt(idInSting);
        System.out.println(name+" giving back " + idInSting);

        for (Log log : logs) {
            if(log.getName().equals(name)) {
                for(Integer integer : idList) {
                    log.getId().remove(integer);
                }
            }
        }
        for (Integer integer : idList) {
            for (Book book : books) {
                if (integer == book.getId()) {
                    book.setAvailable(true);
                }
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
    public void givenBooks(){
        for(Log log: logs){
            log.displayLogInfo();
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

    private void usersFileRead(String usersfile) throws IOException {
        Path filePath = Paths.get(usersfile);
        List<String> csvFileContent = Files.readAllLines(filePath);

        for (String line : csvFileContent) {
            String[] parts = line.split(",");

            Address address = new Address(parts[0], parts[1], parts[2]);
            Contact contact = new Contact(parts[3], parts[4]);
            User user = new User(parts[5], address, contact);
            users.add(user);
        }
    }

    private void bookFileRead(String bookfile) throws IOException {
        Path filePath = Paths.get(bookfile);
        List<String> csvFileContent = Files.readAllLines(filePath);

        for (String line : csvFileContent) {
            String[] parts = line.split(",");

            Book book = new Book(parts[0], parts[1], parts[2], true, Integer.parseInt(parts[4]));
            books.add(book);
        }
    }
    private void logFileRead(String logfile) throws IOException {
        Path filePath = Paths.get(logfile);
        List<String> csvFileContent = Files.readAllLines(filePath);

        for (String line : csvFileContent) {
            String[] parts = line.split(",");

            ArrayList<Integer> temp = stringToInt(parts[1]);
            Log log = new Log(parts[0], temp);
            logs.add(log);
        }
    }
}
