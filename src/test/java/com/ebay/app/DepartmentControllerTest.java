package com.ebay.app;

import com.ebay.app.Controller.DepartmentController;
import com.ebay.app.Entity.Department;
import com.ebay.app.Service.DepartmentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class DepartmentControllerTest {

    @Mock
    DepartmentService service;

    @InjectMocks
    DepartmentController controller;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void updateDepartmentNameSuccessTest(){
        Department mockedData = new Department();
        mockedData.setName("Ankita");
        Optional<Department> mockedOutput = Optional.of(mockedData);
        when(service.findById(eq(1))).thenReturn(mockedOutput);

        int id = 1;
        Optional<Department> actualOutput = service.findById(id);
        Assert.assertEquals("Ankita",actualOutput.get().getName());

    }

}
