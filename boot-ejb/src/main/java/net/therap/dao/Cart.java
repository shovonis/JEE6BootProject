package net.therap.dao;

import net.therap.domain.Product;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface Cart {

    void setCart(Product product);

    ArrayList<Product> getCart();

    void checkOut();

}