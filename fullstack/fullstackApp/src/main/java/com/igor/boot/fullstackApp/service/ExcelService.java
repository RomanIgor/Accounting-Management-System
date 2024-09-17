package com.igor.boot.fullstackApp.service;

import com.igor.boot.fullstackApp.entity.Invoices;
import com.igor.boot.fullstackApp.repository.InvoicesRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private InvoicesRepository invoicesRepository;

    public void importExcel(MultipartFile file) throws IOException, ParseException {
        List<Invoices> invoicesList = new ArrayList<>();

        try (InputStream is = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (Row row : sheet) {
                if (row.getRowNum() == 0 || isRowEmpty(row)) {
                    continue; // skip header row and empty rows
                }

                Invoices invoice = new Invoices();
                invoice.setId((int) getCellNumericValue(row.getCell(0)));
                invoice.setFirma(getCellStringValue(row.getCell(1)));
                invoice.setRechnungsNummer(getCellStringValue(row.getCell(2)));
                invoice.setRechnungsDatum(getCellDateValue(row.getCell(3), dateFormat));
                invoice.setFrist(getCellStringValue(row.getCell(4)));
                invoice.setBestellDatum(getCellDateValue(row.getCell(5), dateFormat));
                invoice.setGesamtPreisLautBestellung(BigDecimal.valueOf(getCellNumericValue(row.getCell(6))));
                invoice.setRechnungsart(getCellStringValue(row.getCell(7)));
                invoice.setAlphaNr(getCellStringValue(row.getCell(8)));
                invoice.setKonto(getCellStringValue(row.getCell(9)));
                invoice.setRechnungBetrag(BigDecimal.valueOf(getCellNumericValue(row.getCell(10))));
                invoice.setBezahlt(BigDecimal.valueOf(getCellNumericValue(row.getCell(11))));
                invoice.setKommentare(getCellStringValue(row.getCell(12)));

                invoicesList.add(invoice);
            }
        }

        invoicesRepository.saveAll(invoicesList);
    }

    private boolean isRowEmpty(Row row) {
        for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    private String getCellStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    return dateFormat.format(cell.getDateCellValue());
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }

    private double getCellNumericValue(Cell cell) {
        if (cell == null) {
            return 0;
        }
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                try {
                    return Double.parseDouble(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return 0;
                }
            case BOOLEAN:
                return cell.getBooleanCellValue() ? 1 : 0;
            case FORMULA:
                return cell.getNumericCellValue();
            case BLANK:
                return 0;
            default:
                return 0;
        }
    }

    private Date getCellDateValue(Cell cell, SimpleDateFormat dateFormat) throws ParseException {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                String dateStr = cell.getStringCellValue();
                if (dateStr.isEmpty()) {
                    return null;
                }
                return dateFormat.parse(dateStr);
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                }
            default:
                return null;
        }
    }
}
