package com.example.backendeksamenv22.Domain.Service;

import com.example.backendeksamenv22.Domain.Model.BrandModel;
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
    public List<BrandModel> readList(){
        return brandRepo.findAll();
    }
    //read one ById
    public Optional<BrandModel> readone(Long id){
        return brandRepo.findById(id);
    }
    //create
    public BrandModel create(BrandModel model) { return brandRepo.save(model); }
    //update
    public BrandModel update(BrandModel model) { return brandRepo.save(model); }
    //delete
    public void delete(Long id) { brandRepo.deleteById(id); }

}


