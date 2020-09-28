package com.nextpay.vimo.model;

import com.nextpay.vimo.model.auth.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;
}
