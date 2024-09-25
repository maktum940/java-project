package products;

import users.CompanyInformation;

public class ProductInformation {
    protected String productName;
    protected String productCategory;
    protected String productSubCategory;
    protected String expireDate;
    protected String purchaseDate;

    protected double productPrice;

    public ProductInformation(String productName, String productCategory, String productSubCategory, String expireDate, String purchaseDate, double productPrice) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productSubCategory = productSubCategory;
        this.expireDate = expireDate;
        this.purchaseDate = purchaseDate;
        this.productPrice = productPrice;
    }
}
