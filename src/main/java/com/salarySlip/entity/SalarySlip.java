package com.salarySlip.entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class SalarySlip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employee employee;
    private String  date;
    private double grossSalary;
    private double deductions;
    private double netSalary;
}
