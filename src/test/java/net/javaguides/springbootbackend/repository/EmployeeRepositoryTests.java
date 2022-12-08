package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.models.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    // JUnit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = true)
    public void saveEmployeeTest(){

        Employee employee = Employee.builder()
                .firstName("Ariane")
                .lastName("Itetero")
                .email("arianeitetero@gmail.com")
                .build();

        employeeRepository.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)

    public void getEmployeeTest ()  {

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
   // @Rollback(value = false)
    public void updateEmployeeTest(){

        Employee employee = employeeRepository.findById(1L).get();

        employee.setEmail("arianeitetero@gmail.com");

        Employee employeeUpdated =  employeeRepository.save(employee);

        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("arianeitetero@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = true)
    public void deleteEmployeeTest(){

        Employee employee = employeeRepository.findById(1L).get();

        employeeRepository.delete(employee);

        //employeeRepository.deleteById(1L);

        Employee employee1 = null;

        Optional<Employee> optionalEmployee = employeeRepository.findByEmail("arianeitetero@gmail.com");

        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }

        Assertions.assertThat(employee1).isNull();
    }

}