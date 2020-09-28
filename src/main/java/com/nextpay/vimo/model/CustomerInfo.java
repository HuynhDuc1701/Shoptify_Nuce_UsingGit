package com.nextpay.vimo.model;

import com.nextpay.vimo.model.auth.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String phoneNumber;

    private String email;
    @ManyToOne
    private User user;
}
