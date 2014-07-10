package net.therap.controller;

import net.therap.dao.Cart;
import net.therap.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

/**
 * @author rifatul.islam
 * @since 7/9/14.
 */

@ManagedBean
@SessionScoped
public class CartController {

    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    private ArrayList<Product> products;
    private ArrayList<Product> cartList;
    private Product product;

    private Product cartProduct;


    @EJB
    private Cart cart;

    @PostConstruct
    public void initialize() {
        log.info("Cart Initialized");
        products = new ArrayList<Product>();
        cartList = new ArrayList<Product>();
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

    public String addProductToCart() {
        log.info("Product Added To cart" + getProduct().getName());
        cart.setCart(cartProduct);
        return "home.xhtml?faces-redirect=true";
    }

    public ArrayList<Product> getCartList() {
        return cart.getCart();
    }

    public Product getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(Product cartProduct) {
        this.cartProduct = cartProduct;
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroying BEAN");
    }
}
