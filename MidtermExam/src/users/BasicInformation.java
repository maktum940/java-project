package users;

public class BasicInformation extends Address{
    protected String firstName;
    protected String lastName;
    String personalContact;
    protected char gender;
    protected String dateOfBirth;

    protected String emailAddress;

    public BasicInformation(String firstName, String lastName, String personalContact, char gender, String dateOfBirth, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalContact = personalContact;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
    }
}
