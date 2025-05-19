package com.project.controller;

import com.project.entity.Emp;
import com.project.services.EmpService;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@AllArgsConstructor
@RestController
@RequestMapping("/api/emp")
public class EmpController {
private EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }
    @PostMapping("/add")
   public String addEmp(@RequestBody Emp emp) {
    return empService.addEmp(emp);
   }

   @GetMapping("/{empId}")
   public Emp getEmp(@PathVariable("empId") int id) {
        return empService.getEmp(id);
   }
   @PutMapping("/update/{empId}")
   public String updateEmp(@RequestBody Emp emp, @PathVariable("empId") int id) {
       return empService.updateEmp(emp, id);
   }
}
