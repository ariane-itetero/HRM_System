package net.javaguides.springbootbackend.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import net.javaguides.springbootbackend.dto.UpdateEmployeeDto;
import net.javaguides.springbootbackend.models.Employee;
import net.javaguides.springbootbackend.services.EmployeeService;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTests {


    public static final UpdateEmployeeDto DTO = new UpdateEmployeeDto(1L, "Ariane", "Itetero", "arianeitetero@gmail.com");
    @Mock
    private EmployeeRepository employeeRepositoryMock;

    @InjectMocks
    private EmployeeService employeeService=new EmployeeServiceImpl();
    @Test
    public void getAll_withSomeElements() {

        when(employeeRepositoryMock.findAll()).thenReturn(Arrays.asList(new Employee(1,"Ariane","Itetero","arianeitetero@gmail.com"),
                new Employee(2,"Colombe","Igihozo","colombe@gmail.com")));
        assertEquals(1,employeeService.getAllEmployees().get(0).getId());
        assertEquals(2, employeeService.getAllEmployees().size());
    }


    @Test
    public void update_Success() {
        UpdateEmployeeDto dto = new UpdateEmployeeDto();
        Employee employee = new Employee(1L, "Ariane", "Itetero", "arianeitetero@gmail.com");
        when(employeeRepositoryMock.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepositoryMock.existsByEmail(dto.getEmail())).thenReturn(employee);
        when(employeeRepositoryMock.save(employee)).thenReturn(employee);

//        ResponseEntity<?> updateEmployee = employeeService.updateEmployee(DTO);
//        assertTrue(updateEmployee.getStatusCode().is2xxSuccessful());

    }
//
//    @Test
//    public void update_404() {
//       UpdateEmployeeDto dto = new UpdateEmployeeDto(1L, "Ariane", "Itetero", "arianeitetero@gmail.com");
//        when(employeeRepositoryMock.findById(1l)).thenReturn(Optional.empty());
//
//        ResponseEntity<?> updateItem = employeeService.updateEmployee(1, dto);
//        assertTrue(updateItem.getStatusCodeValue()==404);
//
//    }


//
//    @Test
//    public void update_sauve() {
//        UpdateItemDto dto = new UpdateItemDto("Cars", 1000, 5);
//        Item item = new Item(1, "Shoes", 1000, 5);
//        when(employeeRepositoryMock.findById(1)).thenReturn(Optional.of(item));
//        when(employeeRepositoryMock.existsByName(dto.getName())).thenReturn(false);
//        item.setName(dto.getName());
//        item.setPrice(dto.getPrice());
//        item.setQuantity(dto.getQuantity());
//        when(employeeRepositoryMock.save(item)).thenReturn(item);
//
//        ResponseEntity<?> updateItem = employeeService.updateItem(1, dto);
//        assertTrue(updateItem.getStatusCodeValue()==201);
//    }


}
