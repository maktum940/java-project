package products;

import users.Customer;

public class Cart extends CartInformation{
    protected Customer customer;
    protected Products[] products;

    public Cart(int quantity, double unitPrice, double grossPrice, Customer customer, Products[] products) {
        super(quantity, unitPrice, grossPrice);
        this.customer = customer;
        this.products = products;
    }
}
