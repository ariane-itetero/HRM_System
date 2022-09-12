package net.javaguides.springbootbackend;

import net.javaguides.springbootbackend.models.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
     @Autowired
	 public EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
		Employee emp=new Employee();
		emp.setEmailId("arianeitetero@gmail.com");
		emp.setFirstName("Ariane");
		emp.setLastName("Itetero");
		repo.save(emp);

		Employee emp1=new Employee();
		emp1.setEmailId("brysonizere@gmail.com");
		emp1.setFirstName("Bryson");
		emp1.setLastName("Izere");
		repo.save(emp1);
	}
}
