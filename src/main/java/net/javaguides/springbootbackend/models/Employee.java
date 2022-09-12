package net.javaguides.springbootbackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private  String lastName;
    @Column(name = "email_id", unique = true)
    private String emailId;
}
