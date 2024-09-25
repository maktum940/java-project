package users;

import products.Products;

public class Merchant extends MerchantInformation{

    protected Products[] products;

    public Merchant(String firstName, String lastName, String personalContact, char gender, String dateOfBirth, String emailAddress, Credentials credentials, CompanyInformation companyInformation) {
        super(firstName, lastName, personalContact, gender, dateOfBirth, emailAddress, credentials, companyInformation);
        products = new Products[10];
    }
}
