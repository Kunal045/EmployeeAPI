package com.project.services;

import com.project.dao.EmpDao;
import com.project.entity.Emp;
import com.project.exception.EmpAlreadyExistException;
import com.project.exception.NoSuchEmpExistException;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    private  EmpDao empDao;
    public EmpService(EmpDao empDao) {
        this.empDao = empDao;
    }
     public String addEmp(Emp emp) {
       Emp e = empDao.findByEName(emp.getEName()).orElse(null);
       if (e != null) {
           throw new EmpAlreadyExistException("Emp with name " + emp.getEName() + " already exists");
       }
       empDao.save(emp);
       return "Emp added successfully";
     }

     public Emp getEmp(int id) {
        Emp e= empDao.findById(id).orElse(null);
        if (e == null) {
            throw new NoSuchEmpExistException("Emp with id " + id + " not found");
        }
        return e;
     }

     public String  updateEmp(Emp emp , int id) {
         Emp e= empDao.findById(id).orElse(null);
         if (e == null) {
            throw new NoSuchEmpExistException("Emp with id " + id + " not found");

         }
         e.setEName(emp.getEName());
         e.setSalary(emp.getSalary());
         empDao.save(e);
         return "Emp updated successfully";
     }

    public String deleteEmp(int id) {
        Emp e = empDao.findById(id).orElse(null);
        if (e == null) {
            throw new NoSuchEmpExistException("Emp with id " + id + " not found");
        }
        empDao.delete(e);
        return "Emp deleted successfully";
    }
}
