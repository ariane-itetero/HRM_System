package net.javaguides.springbootbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateEmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
