package com.example.backendeksamenv22.Controller;

import com.example.backendeksamenv22.Domain.Model.Car;
import com.example.backendeksamenv22.Domain.Service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/cars")
public class CarModelController {


        private final CarModelService carModelService;

        @Autowired //dependency injektion
        public CarModelController(CarModelService carModelService) {
            this.carModelService = carModelService;
        }

        @GetMapping()
        public ResponseEntity<List<Car>> readcarModelList() {
            List<Car> carModellist = carModelService.readList();
            return new ResponseEntity<>(carModellist, HttpStatus.OK);
        }


    @GetMapping("/brand/{id}")
    public ResponseEntity<List<Car>> getCarsByBrandId(@PathVariable Long id){
        List<Car> cars = carModelService.getCarsByBrandId(id);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


        @GetMapping("/{id}")
        public Car readcarModel(@PathVariable Long id) {
            Optional<Car> readcarModel = carModelService.readone(id);
            return readcarModel.orElse(null);
        }

        @GetMapping("/sorted")
        public ResponseEntity<List<Car>> sortByEffectsee(){
            List<Car> sortBy = carModelService.findByEffectsee();
            return new ResponseEntity<>(sortBy,HttpStatus.OK);
        }


        @PostMapping
        public ResponseEntity<CarModelController> addcarModel(@RequestBody Car model){
            carModelService.create(model);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Car> updatecarModel(@PathVariable Long id, @RequestBody Car model){
            model.setId(id);
            return new ResponseEntity<>(carModelService.update(model),HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Car> deletecarModel(@PathVariable Long id){
            carModelService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

