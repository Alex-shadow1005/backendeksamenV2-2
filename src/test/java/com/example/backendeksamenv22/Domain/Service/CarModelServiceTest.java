package com.example.backendeksamenv22.Domain.Service;

import com.example.backendeksamenv22.Domain.Model.Brand;
import com.example.backendeksamenv22.Domain.Model.Car;
import com.example.backendeksamenv22.Repo.BrandRepo;
import com.example.backendeksamenv22.Repo.CarModelRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CarModelServiceTest {


    @Mock
    private CarModelRepo carModelRepo;
    @Mock
    private BrandRepo brandRepo;


    @Autowired
    CarModelService carModelService;
    @Autowired
    BrandService brandService;

    @BeforeEach
    void setup(){
        this.carModelService= new CarModelService(this.carModelRepo);
        this.brandService = new BrandService(this.brandRepo);
    }


    @Test
    void getAverageFuelUse() {


        //kunne være inplamenteret før iforhold til metoden uden at forenkey virkede.
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


        List<Car> carlist = new ArrayList<>();
        carlist.add(car1);
        carlist.add(car3);

        Mockito.when(carModelRepo.getCarsByBrandId(1L)).thenReturn(carlist);
        assertEquals(17.5,carModelService.getAverageFuelUse(1L));




    }
}