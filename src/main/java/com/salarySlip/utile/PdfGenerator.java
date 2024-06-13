package com.salarySlip.utile;
// PdfGenerator.java

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Paragraph;
import com.salarySlip.entity.SalarySlip;

import java.io.ByteArrayOutputStream;

public class PdfGenerator {

    public static byte[] ByteArrayInputStream;

    public static byte[] generateSalarySlipPdf(SalarySlip salarySlip) {

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Adding title
            document.add(new Paragraph("Amps Facilities Management Services Pvt. Ltd."));
            document.add(new Paragraph("Payslip for April, 2024"));

            // Adding Employee details table
            Table table = new Table(2);
            table.addCell("Employee Code & Name");
          //  table.addCell(employee.getCode() + " - " + employee.getName());
            table.addCell("Designation");
           // table.addCell(employee.getDesignation());
            table.addCell("Site Name");
           // table.addCell(employee.getSiteName());
            table.addCell("No. of days worked");
           // table.addCell(String.valueOf(employee.getDaysWorked()));
            table.addCell("Basic Pay");
           // table.addCell(String.valueOf(employee.getBasicPay()));
            table.addCell("DA");
           // table.addCell(String.valueOf(employee.getDa()));
            table.addCell("LWW");
           // table.addCell(String.valueOf(employee.getLww()));
            table.addCell("Bonus");
          //  table.addCell(String.valueOf(employee.getBonus()));
            table.addCell("Others");
           // table.addCell(String.valueOf(employee.getOthers()));
            table.addCell("PF");
           // table.addCell(String.valueOf(employee.getPf()));
            table.addCell("PT");
           // table.addCell(String.valueOf(employee.getPt()));
            table.addCell("LOP");
           // table.addCell(String.valueOf(employee.getLop()));
            table.addCell("Fixed Salary");
           table.addCell(String.valueOf(salarySlip.getGrossSalary()));

            document.add(table);
            document.close();

            return byteArrayOutputStream.toByteArray();

            //return new ByteArrayInputStream(out.toString().getBytes());
    }
}
