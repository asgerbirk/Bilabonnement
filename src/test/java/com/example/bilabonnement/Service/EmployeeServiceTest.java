package com.example.bilabonnement.Service;

import com.example.bilabonnement.Enum.AccessLevel;
import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeService underTest;

    @BeforeEach
    void setUp(){
        underTest = new EmployeeService(employeeRepository);
    }


    @Test
    void loginValidator() {

        Employee employee = new Employee(1,"master","master", AccessLevel.MASTER);




        assertEquals(AccessLevel.MASTER,underTest.loginValidator(employee.getEmail(),employee.getPassword()));



    }
}