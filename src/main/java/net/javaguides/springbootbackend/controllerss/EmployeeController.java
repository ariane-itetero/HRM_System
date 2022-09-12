package net.javaguides.springbootbackend.controllerss;

import net.javaguides.springbootbackend.models.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/getEmployees")
public class EmployeeController {
    @Autowired
    public EmployeeRepository repo;
    @GetMapping
    public List<Employee> getAllStudents(){
        return repo.findAll();
    }
}
