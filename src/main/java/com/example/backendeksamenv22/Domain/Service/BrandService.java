package com.example.backendeksamenv22.Domain.Service;

import com.example.backendeksamenv22.Domain.Model.Brand;
import com.example.backendeksamenv22.Repo.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BrandService {
    private final BrandRepo brandRepo;


    @Autowired
    public BrandService(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }
    //read all
    public List<Brand> readList(){
        return brandRepo.findAll();
    }
    //read one ById
    public Optional<Brand> readone(Long id){
        return brandRepo.findById(id);
    }
    //create
    public Brand create(Brand model) { return brandRepo.save(model); }
    //update
    public Brand update(Brand model) { return brandRepo.save(model); }
    //delete
    public void delete(Long id) { brandRepo.deleteById(id); }

}


