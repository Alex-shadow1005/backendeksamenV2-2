package com.example.backendeksamenv22.Repo;

import com.example.backendeksamenv22.Domain.Model.carModelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carModelRepo extends JpaRepository<carModelModel,Long> {
}
