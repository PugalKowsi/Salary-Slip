package com.salarySlip.repository;

import com.salarySlip.entity.SalarySlip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarySlipRepository extends JpaRepository<SalarySlip,Long> {
}
