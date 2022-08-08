package com.example.backendeksamenv22.Domain.Model;

import javax.persistence.*;

@Entity
public class CarModelModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carModel_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    private String modelname;
    private String acceleration;
    private int topspeed;
    private String effectsee;
    private double milesPrLiter;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }

    public int getTopspeed() {
        return topspeed;
    }

    public void setTopspeed(int topspeed) {
        this.topspeed = topspeed;
    }

    public String getEffectsee() {
        return effectsee;
    }

    public void setEffectsee(String effectsee) {
        this.effectsee = effectsee;
    }

    public double getMilesPrLiter() {
        return milesPrLiter;
    }

    public void setMilesPrLiter(double milesPrLiter) {
        this.milesPrLiter = milesPrLiter;
    }

}
