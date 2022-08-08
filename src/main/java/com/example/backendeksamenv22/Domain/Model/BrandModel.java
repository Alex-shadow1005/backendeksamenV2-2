package com.example.backendeksamenv22.Domain.Model;

import javax.persistence.*;

@Entity
public class brandModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;
    private String brandname;
    private String nationality;




    public brandModel() {
    }



    public brandModel(Long id, String brandname, String nationality) {
        this.id = id;
        this.brandname = brandname;
        this.nationality = nationality;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoldnavn() {
        return brandname;
    }

    public void setHoldnavn(String brandname) {
        this.brandname = brandname;
    }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }




}

