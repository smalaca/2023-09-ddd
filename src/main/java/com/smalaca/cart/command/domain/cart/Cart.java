package com.smalaca.cart.command.domain.cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private UUID cartId;

    public void addProduct() {

    }

    public void removeProduct() {

    }
}
