package com.example.techiteasyspringhomework.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "remotecontrollers")
public class RemoteController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String compatibleWith;
    @Setter
    private String batteryType;
    @Setter
    private String name;
    @Setter
    private String brand;
    @Setter
    private Double price;
    @Setter
    private Integer originalStock;

    @Setter
    @OneToOne
    public Television television;


    public RemoteController() {

    }

}
