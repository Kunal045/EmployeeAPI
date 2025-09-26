package com.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    @NotBlank(message = "Emp name is required")
    private String eName;

    @NotNull(message = "Salary is required")
    @DecimalMin(value = "10000.0", message = "Salary must be greater than or equal to 10000")
    private Double salary;
}
