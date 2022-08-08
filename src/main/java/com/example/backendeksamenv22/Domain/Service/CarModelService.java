package com.example.backendeksamenv22.Domain.Service;

import com.example.backendeksamenv22.Domain.Model.CarModelModel;
import com.example.backendeksamenv22.Repo.CarModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CarModelService {

    private final CarModelRepo carModelRepo;



    @Autowired
    public CarModelService(CarModelRepo carModelRepo) {
        this.carModelRepo = carModelRepo;
    }

    //read all
    public List<CarModelModel> readList(){
        return carModelRepo.findAll();
    }

    /* public Optional<List<rytterModel>> readbikerbyteam(String hold){
         return rytterRepo.findAll().stream().filter(rytterModel-> rytterModel.gethold() != null && rytterModel.gethold() == holdnavn);
     }

     */
    //read one ById
    public Optional<CarModelModel> readone(Long id){
        return carModelRepo.findById(id);
    }
    //create
    public void create(CarModelModel model){
        carModelRepo.save(model);
    }
    //update
    public CarModelModel update(CarModelModel model){

        return carModelRepo.save(model);
    }
    //delete
    public void delete(Long id){
        carModelRepo.deleteById(id);
    }


}


