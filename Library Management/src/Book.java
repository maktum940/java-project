import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String givenTo;
    private boolean available;
    private int id;

    public Book(String title, String author, String genre, boolean available, int id) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.id = id;
    }

    //getter
    public String getTitle() {return this.title;}
    public String getAuthor() {return this.author;}
    public String getGenre() {return this.genre;}
    public String getGivenTo() {return this.givenTo;}
    public boolean isAvailable() {return this.available;}
    public int getId() {return this.id;}

    //setter
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setGivenTo(String givenTo) {this.givenTo = givenTo;}
    public void setAvailable(boolean available) {this.available = available;}
    public void setId(int id) {this.id = id;}

    public void displayBookInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genres: " + genre);
        if(available){
            System.out.println("Book available");
        }else
            System.out.println("Book not available");
    }
    public void displayBooksId() {
        if (available) {
            System.out.print("Book name: " + title + "\t");
            System.out.println(" Book id: " + id);
        }
    }
}
