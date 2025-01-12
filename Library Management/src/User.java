public class User {
    private String name;
    private Contact contact;
    private Address address;

    public User(String name, Address address, Contact contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
    public void displayUserInfo() {
        System.out.println("Name: " + name);
        contact.displayContactInfo();
        address.displayAddressInfo();
    }
}
