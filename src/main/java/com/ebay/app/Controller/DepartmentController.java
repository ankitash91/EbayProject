package com.ebay.app.Controller;

import com.ebay.app.Repository.DepartmentRepository;
import com.ebay.app.Entity.Department;
import com.ebay.app.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("host")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @GetMapping("departments/{id}")
    private Optional<Department> getDepartmentById(@PathVariable int id){
        return service.findById(id);
    }

    @GetMapping("departments")
    private ResponseEntity<List<Department>> getAllDepartments(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @PostMapping("departments")
    private ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return new ResponseEntity<Department>(service.save(department),HttpStatus.OK);
    }

    @PutMapping("departments")
    private ResponseEntity<Optional<Department>> updateDepartmentName(@RequestBody Department department){
        Optional<Department> dept = service.updateDepartmentName(department.getId(),department.getName());
        if(dept==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Department>>(dept,HttpStatus.OK);
    }

    @DeleteMapping("departments/{id}")
    private ResponseEntity<Integer> deleteDepartmentById(@PathVariable int id){
        if(service.deleteById(id))
            return new ResponseEntity<>(id, HttpStatus.OK);
        else
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }

}
