package net.javaguides.springbootbackend.services;
import net.javaguides.springbootbackend.models.Employee;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.List;
import java.util.Optional;
@Configurable
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long id);
    Employee updateEmployee(Employee updatedEmployee);
    void deleteEmployee(long id);
}