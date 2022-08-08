package com.example.backendeksamenv22.Domain.Model;

import javax.persistence.*;

@Entity
public class BrandModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;
    @Column(name = "brandname")
    private String brandname;
    private String nationality;









    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getNationality() { return nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }




}

