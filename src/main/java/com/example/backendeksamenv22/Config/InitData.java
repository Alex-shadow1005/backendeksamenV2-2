package com.example.backendeksamenv22.Config;

import com.example.backendeksamenv22.Domain.Model.Brand;
import com.example.backendeksamenv22.Domain.Model.Car;
import com.example.backendeksamenv22.Domain.Service.BrandService;
import com.example.backendeksamenv22.Domain.Service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class  InitData implements CommandLineRunner {
    private BrandService brandService;
@Autowired
    public InitData(BrandService brandService, CarModelService carModelService) {
        this.brandService = brandService;
        this.carModelService = carModelService;
    }

    private CarModelService carModelService;

    @Override
    public void run(String... args) throws Exception {
        Brand brand1 = new Brand();
        brand1.setBrandname("Ford");
        brand1.setNationality("Germany");
        brandService.create(brand1);

        Brand brand2 = new Brand();
        brand2.setBrandname("Toyota");
        brand2.setNationality("Japan");
        brandService.create(brand2);

        Car car1 = new Car();
        car1.setAcceleration("10");
        car1.setBrand(brand1);
        car1.setEffectsee("250");
        car1.setMilesPrLiter(20);
        car1.setModelname("Mondeo");
        car1.setTopspeed(250);
        carModelService.create(car1);

        Car car2 = new Car();
        car2.setAcceleration("100");
        car2.setBrand(brand2);
        car2.setEffectsee("500");
        car2.setMilesPrLiter(15);
        car2.setModelname("Aigo");
        car2.setTopspeed(180);
        carModelService.create(car2);


        Car car3 = new Car();
        car3.setAcceleration("100");
        car3.setBrand(brand1);
        car3.setEffectsee("175");
        car3.setMilesPrLiter(15);
        car3.setModelname("Fiesta");
        car3.setTopspeed(180);
        carModelService.create(car3);

    }
}
