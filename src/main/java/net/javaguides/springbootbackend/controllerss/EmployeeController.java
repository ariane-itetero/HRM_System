package net.javaguides.springbootbackend.controllerss;

import net.javaguides.springbootbackend.models.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    public EmployeeRepository repo;
    @GetMapping
    public List<Employee> getAllStudents(){
        return repo.findAll();
    }
//build create employee rest api
@PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return repo.save(employee);
    }
}
