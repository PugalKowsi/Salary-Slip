package com.salarySlip.service.impl;

import com.salarySlip.entity.SalarySlip;
import com.salarySlip.repository.SalarySlipRepository;
import com.salarySlip.service.SalarySlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalarySlipServiceimpl implements SalarySlipService {
    @Autowired
    private SalarySlipRepository salarySlipRepository;
    @Override
    public List<SalarySlip> getAllSalarySlips() {
        return salarySlipRepository.findAll();
    }

    @Override
    public SalarySlip saveSalarySlip(SalarySlip salarySlip) {
        return salarySlipRepository.save(salarySlip);
    }

    @Override
    public SalarySlip getSalarySlipById(Long id) {
        return salarySlipRepository.findById(id).orElse(null);
    }
}
