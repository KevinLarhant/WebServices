package epsi.webservices.beans;

/**
 * Created by Pierre on 28/03/2015.
 */
public class Product {

    private int id;
    private String reference;
    private int quantity;


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
