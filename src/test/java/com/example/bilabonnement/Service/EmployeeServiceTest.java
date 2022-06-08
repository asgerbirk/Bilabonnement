package com.example.bilabonnement.Service;

import com.example.bilabonnement.Enum.AccessLevel;
import com.example.bilabonnement.Enum.Pages;
import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Kodet af Asger og Simon

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private DamageReportRepository damageReportRepository;
    private CustomerRepository customerRepository;
    private CarRepository carRepository;
    private AgreementRepository agreementRepository;

    private EmployeeService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmployeeService(employeeRepository, damageReportRepository,customerRepository,carRepository,agreementRepository );
    }


    @Test
    void testAccessLevelMasterPage() {
        Employee employee = new Employee(1, "master", "master", AccessLevel.MASTER);
        assertEquals("masterPage", underTest.returnPageIfAuthorized(employee.getAccessLevel(), Pages.masterPage));
    }

    @Test
    void testAccessLevelAdminPage() {
        Employee employee = new Employee(2, "admin", "admin", AccessLevel.ADMIN);
        assertEquals("adminPage", underTest.returnPageIfAuthorized(employee.getAccessLevel(), Pages.adminPage));
    }

    @Test
    void testAccessLevelEmployee(){
        Employee employee = new Employee(3, "employee", "employee", AccessLevel.EMPLOYEE);
        assertEquals("employeePage", underTest.returnPageIfAuthorized(employee.getAccessLevel(), Pages.employeePage));
    }
    }
