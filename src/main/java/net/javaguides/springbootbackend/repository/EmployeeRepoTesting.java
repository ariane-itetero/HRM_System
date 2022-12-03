package net.javaguides.springbootbackend.repository;

import lombok.Builder;
import org.assertj.core.api.Assertions;
import net.javaguides.springbootbackend.models.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepoTesting {

    @Autowired
    private EmployeeRepository employeeRepository;

    // JUnit test for saveEmployee

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){

        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .emailId("ramesh@gmail.com")
                .build();

        employeeRepository.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getEmployeeTest(){

        Employee employee = employeeRepository.findById(1L).get();

        Assertions.assertThat(employee.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfEmployeesTest(){

        List<Employee> employees = employeeRepository.findAll();

        Assertions.assertThat(employees.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest(){

        Employee employee = employeeRepository.findById(2L).get();

        employee.setEmailId("ram@gmail.com");

        Employee employeeUpdated =  employeeRepository.save(employee);

        Assertions.assertThat(employeeUpdated.getEmailId()).isEqualTo("ram@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Employee employee = employeeRepository.findById(1L).get();

        employeeRepository.delete(employee);

        //employeeRepository.deleteById(1L);

        Employee employeee = null;

        Optional<Employee> optionalEmployee = employeeRepository.findByEmailId("ram@gmail.com");

        if(optionalEmployee.isPresent()){
            employeee = optionalEmployee.get();
        }

        Assertions.assertThat(employeee).isNull();
    }

}