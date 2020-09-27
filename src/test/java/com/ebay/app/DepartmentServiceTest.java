package com.ebay.app;

import com.ebay.app.Entity.Department;
import com.ebay.app.Repository.DepartmentRepository;
import com.ebay.app.Service.DepartmentService;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

public class DepartmentServiceTest {

    @Mock
    DepartmentRepository repository;

    @InjectMocks
    DepartmentService service;

    @Before
    public void setup(){
        // IMP line
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdTest(){
        Department mockedDept = new Department();
        mockedDept.setName("Kokus");
        Optional<Department> mockedOutput = Optional.of(mockedDept);
        when(repository.findById(eq(1))).thenReturn(mockedOutput);

        int id = 1;
        Optional<Department> actualOutput = service.findById(id);
        Assert.assertTrue(actualOutput.isPresent());
        Assert.assertEquals("Kokus",actualOutput.get().getName());
    }

}
