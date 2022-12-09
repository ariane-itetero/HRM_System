package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.Optional;
@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    Employee findEmployeeById(Long id);
    Employee existsByEmail(String email);

}
