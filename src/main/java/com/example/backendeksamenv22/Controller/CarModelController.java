package com.example.backendeksamenv22.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/model")
public class carModelController {


        private final carModelService carModelService;

        @Autowired //dependency injektion
        public carModelController(carModelService carModelService) {
            this.carModelService = carModelService;
        }

        @GetMapping()
        public ResponseEntity<List<carModelModel>> readcarModelList() {
            List<carModelModel> carModellist = carModelService.readcarModelList();
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
        public carModelModel readcarModel(@PathVariable Long id) {
            Optional<carModelModel> readcarModel = carModelService.readcarModel(id);
            return readcarModel.orElse(null);
        }


        @PostMapping
        public ResponseEntity<carModelController> addcarModel(@RequestBody carModelModel model){
            carModelService.create(model);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<carModelModel> updatecarModel(@PathVariable Long id, @RequestBody carModelModel model){
            model.setId(id);
            return new ResponseEntity<>(carModelService.update(model),HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<carModelModel> deletecarModel(@PathVariable Long id){
            carModelService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

