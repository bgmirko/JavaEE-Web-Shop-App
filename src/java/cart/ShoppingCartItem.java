
package cart;

import entity.Artikli;

/**
 *
 * @author Mirko
 */
public class ShoppingCartItem {

    Artikli artikal;
    short kolicina;

    public ShoppingCartItem(Artikli artikal) {
        this.artikal = artikal;
        kolicina = 1;
    }

    public Artikli getProduct() {
        return artikal;
    }

    public short getQuantity() {
        return kolicina;
    }

    public void setQuantity(short quantity) {
        this.kolicina = quantity;
    }

    public void incrementQuantity() {
        kolicina++;
    }

    public void decrementQuantity() {
        kolicina--;
    }

    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * artikal.getCena().doubleValue());
        return amount;
    }
    
}