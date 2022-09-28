package net.javaguides.springbootbackend.controllerss;

import net.javaguides.springbootbackend.exceptions.ResourceNotFoundException;
import net.javaguides.springbootbackend.models.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
        Employee employee = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with this id doenot exist: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

       repo.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id doesnot exist: " + id));

        repo.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
