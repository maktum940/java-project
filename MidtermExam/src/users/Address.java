package users;

public class Address {
    protected String houseNumber;
    protected String roadNumber;
    protected String blockNumber;
    protected String address;

    protected boolean isItShopAddress;

    protected boolean sameAsBillingAddress;

    public Address(){
        this.isItShopAddress = false;
        this.sameAsBillingAddress = true;
    }


}
