package com.project.dao;

import com.project.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpDao extends JpaRepository<Emp, Integer> {
    public Optional<Emp> findByeName(String eName);
}
