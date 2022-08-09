package com.example.backendeksamenv22.Domain.Service;

import com.example.backendeksamenv22.Domain.Model.Car;
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
    public List<Car> readList(){
        return carModelRepo.findAll();
    }

    /* public Optional<List<rytterModel>> readbikerbyteam(String hold){
         return rytterRepo.findAll().stream().filter(rytterModel-> rytterModel.gethold() != null && rytterModel.gethold() == holdnavn);
     }

     */
    //read one ById
    public Optional<Car> readone(Long id){
        return carModelRepo.findById(id);
    }

    public List<Car> findByEffectsee(){
        return carModelRepo.findAllByOrderByEffectseeAsc();
    }

    //create
    public void create(Car model){
        carModelRepo.save(model);
    }
    //update
    public Car update(Car model){

        return carModelRepo.save(model);
    }
    //delete
    public void delete(Long id){
        carModelRepo.deleteById(id);
    }


    public List<Car> getCarsByBrandId(Long id) {
        return carModelRepo.getCarsByBrandId(id);
    }
}


