package com.example.backendeksamenv22.Controller;

import com.example.backendeksamenv22.Domain.Model.Brand;
import com.example.backendeksamenv22.Domain.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
@RequestMapping("/api/brand")
public class BrandController {

        private final BrandService brandService;

        @Autowired //dependency injektion
        public BrandController(BrandService brandService) {
            this.brandService = brandService;
        }

        @GetMapping
        public ResponseEntity<List<Brand>> readbrandList() {
            List<Brand> brandlist = brandService.readList();
            return new ResponseEntity<>(brandlist, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public Brand readbrand(@PathVariable Long id) {
            Optional<Brand> readbrand = brandService.readone(id);
            return readbrand.orElse(null);
        }


        @PostMapping
        public ResponseEntity<BrandController> createbrand(@RequestBody Brand model){
            brandService.create(model);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Brand> updatebrand(@PathVariable Long id, @RequestBody Brand model){
            model.setId(id);
            return new ResponseEntity<>(brandService.update(model),HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Brand> deletebrand(@PathVariable Long id){
            brandService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

