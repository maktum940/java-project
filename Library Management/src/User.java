import java.util.ArrayList;

public class User{
    private String name;
    private Contact contact;
    private Address address;
    private ArrayList<Book> takenBooks;

    public User(String name, Address address, Contact contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {return name;}
    public Contact getContact() {return contact;}
    public Address getAddress() {return address;}
    public ArrayList<Book> getTakenBooks() {return takenBooks;}

    public void setName(String name) {this.name = name;}
    public void setContact(Contact contact) {this.contact = contact;}
    public void setAddress(Address address) {this.address = address;}
    public void setTakenBooks(ArrayList<Book> takenBooks) {this.takenBooks = takenBooks;}

    public void displayBasicUserInfo(){
        System.out.println("Name: " + name);
        System.out.println("Email: " + contact.getEmail());
    }
    public void displayUserInfo() {
        System.out.println("Name: " + name);
        contact.displayContactInfo();
        address.displayAddressInfo();
    }

}
