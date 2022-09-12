package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
