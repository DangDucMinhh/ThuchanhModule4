package com.codegym.thmodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double area;
    private Long population;
    private double gdp;
    private String describe;
    @ManyToOne
    @JoinColumn(name ="country_id")
    private Country country;
}