package net.therap.controller;

import net.therap.dao.Cart;
import net.therap.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

/**
 * @author rifatul.islam
 * @since 7/9/14.
 */

@ManagedBean
@ViewScoped
public class CartController {
    private static final Logger log = LoggerFactory.getLogger(CartController.class);
    private ArrayList<Product> products;
    private ArrayList<Product> cartList;
    private Product product;

    @EJB
    private Cart cart;

    @PostConstruct
    public void initialize() {
        products = new ArrayList<Product>();
        Product shirt = new Product();
        shirt.setName("Shirt");


        Product shoe = new Product();
        shoe.setName("Shoe");

        products.add(shirt);
        products.add(shoe);
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void addProductToCart() {
        log.info("Product Added To cart" + getProduct().getName());
       // cart.setCart(getProduct());
    }

    public ArrayList<Product> getCartList() {
        cartList = cart.getCart();
        return cartList;
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroying BEAN");
    }
}
