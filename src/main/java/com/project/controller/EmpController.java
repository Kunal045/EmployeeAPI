package com.project.controller;

import com.project.entity.Emp;
import com.project.services.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/emp")
public class EmpController {
private EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }


    @PostMapping("/add")
   public String addEmp(@Valid  @RequestBody Emp emp) {
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


   @DeleteMapping("/delete/{empId}")
   public String deleteEmp(@PathVariable("empId") int id) {
       return empService.deleteEmp(id);
   }
}
