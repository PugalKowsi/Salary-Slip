package com.salarySlip.service;

import com.salarySlip.entity.SalarySlip;

import java.util.List;

public interface SalarySlipService {
    List<SalarySlip> getAllSalarySlips();
    SalarySlip saveSalarySlip(SalarySlip salarySlip);
    SalarySlip getSalarySlipById(Long id);
}
