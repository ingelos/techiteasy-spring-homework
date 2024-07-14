package com.example.techiteasyspringhomework.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Table(name = "cimodules")
public class CIModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    private String type;
    @Setter
    private Double price;

    @OneToMany(mappedBy = "ciModule")
    List<Television> televisions;

    public CIModule() {

    }

}
