package purchase;

import products.Cart;

public class Purchase {
    protected Cart cart;
    protected Checkout checkout;

    public Purchase(Cart cart, Checkout checkout) {
        this.cart = cart;
        this.checkout = checkout;
    }
}
