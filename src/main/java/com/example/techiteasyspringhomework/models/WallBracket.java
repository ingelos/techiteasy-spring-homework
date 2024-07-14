package com.example.techiteasyspringhomework.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "wallbrackets")
public class WallBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String size;
    @Setter
    private Boolean adjustable;
    @Setter
    private String name;
    @Setter
    private Double price;

    public WallBracket() {

    }

}
