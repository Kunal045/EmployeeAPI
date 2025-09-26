package com.project.dao;

import com.project.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpDao extends JpaRepository<Emp, Integer> {
    @Query("select e from Emp e where e.eName = :name")
    Optional<Emp> findByEName(@Param("name") String eName);
}
