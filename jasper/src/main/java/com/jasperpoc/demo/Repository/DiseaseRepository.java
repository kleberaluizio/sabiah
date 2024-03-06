package com.jasperpoc.demo.Repository;

import com.jasperpoc.demo.entities.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long>
{

}
