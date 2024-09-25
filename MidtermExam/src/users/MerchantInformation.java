package users;

public class MerchantInformation extends BasicInformation{
    protected Credentials credentials;
    protected CompanyInformation companyInformation;

    public MerchantInformation(String firstName, String lastName, String personalContact, char gender, String dateOfBirth, String emailAddress, Credentials credentials, CompanyInformation companyInformation) {
        super(firstName, lastName, personalContact, gender, dateOfBirth, emailAddress);
        this.credentials = credentials;
        this.companyInformation = companyInformation;
    }
}
