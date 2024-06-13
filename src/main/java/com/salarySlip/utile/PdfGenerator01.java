package com.salarySlip.utile;
// PdfGenerator.java

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Paragraph;
import com.salarySlip.entity.SalarySlip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class PdfGenerator01 {

    public static ByteArrayInputStream generateSalarySlipPdf(SalarySlip salarySlip) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (PdfWriter writer = new PdfWriter(out);
             PdfDocument pdfDoc = new PdfDocument(writer);
             Document document = new Document(pdfDoc)) {

            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            Paragraph title = new Paragraph("Salary Slip")
                    .setFont(font)
                    .setFontSize(20)
                    .setMarginBottom(20);
            document.add(title);

            document.add(new Paragraph("Amps Facilities Management Services Pvt. Ltd."));
            document.add(new Paragraph("Payslip for April, 2024"));

            float[] columnWidths = {1, 3};
            Table table = new Table(columnWidths);

            table.addCell(new Cell().add(new Paragraph("Employee:")));
            table.addCell(new Cell().add(new Paragraph(salarySlip.getEmployee().getName())));

            table.addCell(new Cell().add(new Paragraph("Designation:")));
            table.addCell(new Cell().add(new Paragraph(salarySlip.getEmployee().getDesignation())));

            table.addCell(new Cell().add(new Paragraph("Date:")));
            table.addCell(new Cell().add(new Paragraph(salarySlip.getDate().toString())));

            table.addCell(new Cell().add(new Paragraph("Gross Salary:")));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(salarySlip.getGrossSalary()))));

            table.addCell(new Cell().add(new Paragraph("Deductions:")));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(salarySlip.getDeductions()))));

            table.addCell(new Cell().add(new Paragraph("Net Salary:")));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(salarySlip.getNetSalary()))));

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
