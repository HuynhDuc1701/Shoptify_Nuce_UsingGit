package com.nextpay.vimo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WareHouseBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date createDate;
}
