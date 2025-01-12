public class Contact {
    private String email;
    private String phone;

    public Contact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    //getter
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }

    //setter
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void displayContactInfo() {
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}
