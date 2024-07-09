package com.lecture21.lecture21.repositories;

import com.lecture21.lecture21.entities.EmployeEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<EmployeEntities,Integer> {
}
