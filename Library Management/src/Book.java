import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private String genre;
    private boolean available;
    private int id;

    public Book(String title, String author, String genre, boolean available, int id) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.id = id;
    }

    public void displayBookInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genres: " + genre);
        System.out.println("available: " + available);
        System.out.println("ID: " + id);
    }
}
