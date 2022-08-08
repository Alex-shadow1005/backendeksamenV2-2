package com.example.backendeksamenv22.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
@RequestMapping("/api/brand")
public class brandController {








        private final brandService brandService;

        @Autowired //dependency injektion
        public mærkeController(brandService brandService) {
            this.brandService = brandService;
        }

        @GetMapping
        public ResponseEntity<List<brandModel>> readbrandList() {
            List<brandModel> brandlist = brandService.readbrandList();
            return new ResponseEntity<>(brandlist, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public brandModel readbrand(@PathVariable Long id) {
            Optional<brandModel> readbrand = brandService.readbrand(id);
            return readbrand.orElse(null);
        }


        @PostMapping
        public ResponseEntity<mærkeController> createBrand(@RequestBody brandModel model){
            førsteService.create(model);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<brandModel> updateBrand(@PathVariable Long id, @RequestBody brandModel model){
            model.setId(id);
            return new ResponseEntity<>(brandService.update(model),HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<brandModel> deleteBrand(@PathVariable Long id){
            brandService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

