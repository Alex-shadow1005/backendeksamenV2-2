package com.example.backendeksamenv22.Repo;

import com.example.backendeksamenv22.Domain.Model.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepo extends JpaRepository<BrandModel,Long> {

}
