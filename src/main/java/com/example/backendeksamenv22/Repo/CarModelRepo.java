package com.example.backendeksamenv22.Repo;

import com.example.backendeksamenv22.Domain.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarModelRepo extends JpaRepository<Car,Long> {
    List<Car> findAllByOrderByEffectseeAsc();

    List<Car> getCarsByBrandId(Long id);
}

