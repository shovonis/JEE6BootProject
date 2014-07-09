package net.therap.dao.impl;

import net.therap.dao.Cart;
import net.therap.domain.Product;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
public class CartBean implements Cart {

    @PersistenceContext(unitName = "persistDB", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    private ArrayList<Product> products;

    @PostConstruct
    private void initializeBean() {
        products = new ArrayList<Product>();
    }

    @Override
    public void setCart(Product product) {
        products.add(product);
    }

    @Override
    public ArrayList<Product> getCart() {
        return products;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void checkOut() {
        for (Product product : products) {
            entityManager.persist(product);
        }
        products.clear();
    }
}