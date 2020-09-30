package com.nextpay.vimo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nextpay.vimo.model.auth.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    private boolean status;

    @ManyToOne
    private User user;
}
