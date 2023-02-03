package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MajorRequirementRepository extends CrudRepository<MajorRequirements, Integer>{
  
}
