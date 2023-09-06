package com.igor.boot.fullstackApp.controller;

import com.igor.boot.fullstackApp.entity.Invoices;
import com.igor.boot.fullstackApp.service.AdminService;
import com.igor.boot.fullstackApp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public String showAllInvoices(Model model) {

        List<Invoices> allInvoices = invoiceService.getAllInvoices();
        model.addAttribute("allInv", allInvoices);

        return "/rechnungen/all-invoices";
    }

    @RequestMapping("/addNewInvoice")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addNewInvoice(Model model) {

        Invoices invoices = new Invoices();
        model.addAttribute("invoice", invoices);

        return "/rechnungen/create-invoice";
    }

    @RequestMapping("/saveInvoice")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveInvoice(@ModelAttribute("invoice") Invoices invoices) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            throw new AccessDeniedException("Access denied: Only administrators can save invoices.");
        }

        invoiceService.saveInvoice(invoices);
        return "redirect:/";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleAccessDeniedException(AccessDeniedException ex) {
        ModelAndView modelAndView = new ModelAndView("access-denied"); // Create an appropriate view
        modelAndView.addObject("message", ex.getMessage());

        return modelAndView;
    }

    @RequestMapping("/updateInfo")

    public String updateInvoice(@RequestParam("empId") int id, Model model) {
        Invoices invoices = invoiceService.getInvoice(id);
        model.addAttribute("invoice", invoices);

        return "/rechnungen/edit-invoice";

    }

    @PostMapping("/invoice/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateInvoice(@PathVariable int id,
                                @ModelAttribute("invoice") Invoices invoices,
                                Model model) {

        Invoices existingInvoice = invoiceService.getInvoice(id);
        existingInvoice.setFirma(invoices.getFirma());
        existingInvoice.setRechnungsNummer(invoices.getRechnungsNummer());
        existingInvoice.setRechnungsDatum(invoices.getRechnungsDatum());
        existingInvoice.setFrist(invoices.getFrist());
        existingInvoice.setBestellDatum(invoices.getBestellDatum());
        existingInvoice.setGesamtPreisLautBestellung(invoices.getGesamtPreisLautBestellung());
        existingInvoice.setRechnungsart(invoices.getRechnungsart());
        existingInvoice.setAlphaNr(invoices.getAlphaNr());
        existingInvoice.setKonto(invoices.getKonto());
        existingInvoice.setRechnungBetrag(invoices.getRechnungBetrag());
        existingInvoice.setBezahlt(invoices.getBezahlt());
        existingInvoice.setKommentare(invoices.getKommentare());

        invoiceService.updateInvoice(existingInvoice);
        return "redirect:/";
    }

    @GetMapping("/invoice/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteInvoice(@PathVariable int id) {
        invoiceService.deleteInvoice(id);

        return "redirect:/";
    }

    @GetMapping("/index")
    public String getNew() {

        return "index";
    }
}
