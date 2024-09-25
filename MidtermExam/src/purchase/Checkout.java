package purchase;

import users.Address;

public class Checkout extends Address {
    protected Payments payments;

    public Checkout(Payments payments) {
        this.payments = payments;
    }
}
