package com.example.backendeksamenv22.Domain.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandModel_id")
    private Long id;


    @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL)
    private List<Car> cars;



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

