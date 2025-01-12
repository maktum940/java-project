import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private ArrayList<String> genres;
    private int ID;

    public Book(String title, String author, ArrayList<String> genres, int ID) {
        this.title = title;
        this.author = author;
        this.genres = genres;
        this.ID = ID;
    }

    public void displayBookInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genres: " + genres);
        System.out.println("ID: " + ID);
    }
}
