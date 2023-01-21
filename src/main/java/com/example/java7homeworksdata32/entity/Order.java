package com.example.java7homeworksdata32.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(optional = false)
//    @Column(nullable = false, name = "customers_id")
    private Customer customer;

    @Column(nullable = false, name = "product_name")
    private String productName;

    @Column(nullable = false)
    @Min(1)
    private int amount;


}
