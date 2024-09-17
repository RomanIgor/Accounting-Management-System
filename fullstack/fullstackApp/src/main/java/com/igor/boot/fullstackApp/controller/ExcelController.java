package com.igor.boot.fullstackApp.controller;

import com.igor.boot.fullstackApp.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/api/excel")
public class ExcelController {

    private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);

    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload")
    public String uploadExcelFile(@RequestParam("file") MultipartFile file, Model model) {
        try {
            logger.info("Received file: {}", file.getOriginalFilename());
            excelService.importExcel(file);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (Exception e) {
            logger.error("Failed to upload file", e);
            model.addAttribute("message", "Failed to upload file: " + e.getMessage());
        }
        return "redirect:/";
    }
}
