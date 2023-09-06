package com.igor.boot.fullstackApp.controller;

import com.igor.boot.fullstackApp.entity.Debitoren;
import com.igor.boot.fullstackApp.service.DebitorenService;
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
public class DebitorenController {
    @Autowired
    DebitorenService debitorenService;


    @RequestMapping("/debitoren")
    public String showAllDebitoren(Model model) {

        List<Debitoren> allDebitoren = debitorenService.getAllDebitoren();
        model.addAttribute("allDebt", allDebitoren);

        return "/debitoren/all-debitoren";
    }

    @RequestMapping("/addNewDebitor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addNewDebitor(Model model) {

        Debitoren debitor = new Debitoren();
        model.addAttribute("debitor", debitor);

        return "/debitoren/create-debitor";
    }

    @RequestMapping("/saveDebitor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveDebitor(@ModelAttribute("debitor") Debitoren debitor) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            throw new AccessDeniedException("Access denied: Only administrators can save invoices.");
        }

        debitorenService.saveDebitor(debitor);
        return "redirect:/debitoren";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleAccessDeniedException(AccessDeniedException ex) {
        ModelAndView modelAndView = new ModelAndView("access-denied"); // Create an appropriate view
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }

    @RequestMapping("/updateDebitor")
    public String updateDebitor(@RequestParam("debtId") int id, Model model) {
        Debitoren debitoren = debitorenService.getDebitor(id);
        model.addAttribute("debitor", debitoren);

        return "/debitoren/edit-debitor";


    }

    @PostMapping("/debitor/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateDebitor(@PathVariable int id,
                                @ModelAttribute("debitor") Debitoren debitoren,
                                Model model) {

        Debitoren existingDebitor = debitorenService.getDebitor(id);
        existingDebitor.setFirma(debitoren.getFirma());
        existingDebitor.setRechnungNummer(debitoren.getRechnungNummer());
        existingDebitor.setRechnungDatum(debitoren.getRechnungDatum());
        existingDebitor.setFrist(debitoren.getFrist());
        existingDebitor.setArtRechnung(debitoren.getArtRechnung());
        existingDebitor.setBetrag(debitoren.getBetrag());
        existingDebitor.setNaechsteErrinerung(debitoren.getNaechsteErrinerung());
        existingDebitor.setKommentare(debitoren.getKommentare());
        debitorenService.updateDebitor(existingDebitor);

        return "redirect:/debitoren";
    }


    @GetMapping("/debitor/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteDebitor(@PathVariable int id) {
        debitorenService.deleteDebitor(id);
        return "redirect:/debitoren";
    }

}
