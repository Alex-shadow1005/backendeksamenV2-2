package com.example.backendeksamenv22.Controller;

import com.example.backendeksamenv22.Domain.Model.CarModelModel;
import com.example.backendeksamenv22.Domain.Service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/model")
public class CarModelController {


        private final CarModelService carModelService;

        @Autowired //dependency injektion
        public CarModelController(CarModelService carModelService) {
            this.carModelService = carModelService;
        }

        @GetMapping()
        public ResponseEntity<List<CarModelModel>> readcarModelList() {
            List<CarModelModel> carModellist = carModelService.readList();
            return new ResponseEntity<>(carModellist, HttpStatus.OK);
        }
   /* @GetMapping("/{hold")
    public ResponseEntity<List<rytterModel>> readbikerlistbyTeam(@PathVariable ("hold") String name ) {
        Optional<rytterModel> bikerlistbyteam = rytterService.readbikerbyteam(Long.valueOf(name));
        //List<rytterModel> bikerlist = rytterService.readbikerList();
        return new ResponseEntity<List<rytterModel>>(bikerlistbyteam,HttpStatus.OK);
    }

    */

   /* @GetMapping("/{name}")
    public ResponseEntity<List<rytterModel>> readbikerlistTeam(@PathVariable String name) {
        List<rytterModel> bikerlist = rytterService.readbikerList();
        bikerlist.stream().filter(x -> bikerlist.contains(name));
        return new ResponseEntity<>(bikerlist, HttpStatus.OK);

    }

    */


        @GetMapping("/{id}")
        public CarModelModel readcarModel(@PathVariable Long id) {
            Optional<CarModelModel> readcarModel = carModelService.readone(id);
            return readcarModel.orElse(null);
        }


        @PostMapping
        public ResponseEntity<CarModelController> addcarModel(@RequestBody CarModelModel model){
            carModelService.create(model);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CarModelModel> updatecarModel(@PathVariable Long id, @RequestBody CarModelModel model){
            model.setId(id);
            return new ResponseEntity<>(carModelService.update(model),HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<CarModelModel> deletecarModel(@PathVariable Long id){
            carModelService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

