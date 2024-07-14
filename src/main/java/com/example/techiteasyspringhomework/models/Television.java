package com.example.techiteasyspringhomework.models;

import com.example.techiteasyspringhomework.enums.AvailableSize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "televisions")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    private String brand;
    @Setter
    private Double price;
    @Setter
    private int originalStock;
    @Setter
    private int sold;
    @Setter
    private String type;
    @Setter
    private AvailableSize availableSize;
    @Setter
    private int refreshRate;
    @Setter
    private String screenType;
    @Setter
    private String screenQuality;
    @Setter
    private boolean smartTv;
    @Setter
    private boolean wifi;
    @Setter
    private boolean voiceControl;
    @Setter
    private boolean hdr;
    @Setter
    private boolean bluetooth;
    @Setter
    private boolean ambiLight;

    @Setter
    @OneToOne
    public RemoteController remoteController;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ci_module_id")
    private CIModule ciModule;


    public Television() {

    }



}
