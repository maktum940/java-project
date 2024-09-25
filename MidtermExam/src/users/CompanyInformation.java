package users;

public class CompanyInformation extends Address{
    protected String companyName;
    protected String tradeLicenceNumber;
    protected String tinNumber;

    public CompanyInformation(String companyName, String tradeLicenceNumber, String tinNumber) {
        this.companyName = companyName;
        this.tradeLicenceNumber = tradeLicenceNumber;
        this.tinNumber = tinNumber;
    }
}
