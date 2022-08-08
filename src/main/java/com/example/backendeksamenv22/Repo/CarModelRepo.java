package com.example.backendeksamenv22.Repo;

import com.example.backendeksamenv22.Domain.Model.CarModelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepo extends JpaRepository<CarModelModel,Long> {
}
