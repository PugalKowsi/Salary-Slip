package com.salarySlip.controller;
import com.salarySlip.entity.SalarySlip;
import com.salarySlip.service.SalarySlipService;
import com.salarySlip.utile.PdfGenerator;
import com.salarySlip.utile.PdfGenerator01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/salary-slips")
public class SalarySlipController {
    @Autowired
    private SalarySlipService salarySlipService;
    private InputStream byteArrayInputStream;

    @GetMapping
    public List<SalarySlip> getAllSalarySlips() {
        return salarySlipService.getAllSalarySlips();
    }

    @PostMapping
    public SalarySlip createSalarySlip(@RequestBody SalarySlip salarySlip) {
        return salarySlipService.saveSalarySlip(salarySlip);
    }

    @GetMapping("/pdf/{id}")
    public ResponseEntity<InputStreamResource> getSalarySlipPdf(@PathVariable Long id) {
        SalarySlip salarySlip = salarySlipService.getSalarySlipById(id);

        if (salarySlip == null) {
            return ResponseEntity.notFound().build();
        }

        ByteArrayInputStream bis = PdfGenerator01.generateSalarySlipPdf(salarySlip);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=salary_slip_" + id + ".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
