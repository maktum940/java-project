package users;

public class Customer extends BasicInformation{
    protected Credentials credentials;

    public Customer(String firstName, String lastName, String personalContact, char gender, String dateOfBirth, String emailAddress, Credentials credentials) {
        super(firstName, lastName, personalContact, gender, dateOfBirth, emailAddress);
        this.credentials = credentials;
    }
}
