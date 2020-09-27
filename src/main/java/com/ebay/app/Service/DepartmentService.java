package com.ebay.app.Service;

import com.ebay.app.Entity.Department;
import com.ebay.app.Repository.DepartmentRepository;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class DepartmentService {

    @Autowired
    DepartmentRepository repository;


    public DepartmentRepository getRepository() {
        return repository;
    }

    public void setRepository(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Optional<Department> findById(int id) {
        return repository.findById(id);
    }

    public List<Department> findAll() {
        return repository.findAll();
    }

    public Department save(Department department) {
        return repository.save(department);
    }

    @Transactional
    public Optional<Department> updateDepartmentName(int id, String name) {
        repository.updateDepartmentName(id,name);
        return findById(id);
    }

    @Transactional
    public boolean deleteById(int id) {
        if(findById(id)!=null){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
