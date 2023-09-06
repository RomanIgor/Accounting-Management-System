package com.igor.boot.fullstackApp.controller;

import com.igor.boot.fullstackApp.entity.Orders;
import com.igor.boot.fullstackApp.service.AdminService;
import com.igor.boot.fullstackApp.service.OrderService;
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
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orders")
    public String showAllOrders(Model model) {

        List<Orders> allOrders = orderService.getAllOrders();
        model.addAttribute("allOrd", allOrders);

        return "/bestellungen/all-orders";
    }

    @RequestMapping("/addNewOrder")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addNewOrder(Model model) {

        Orders order = new Orders();
        model.addAttribute("order", order);

        return "/bestellungen/create-order";
    }

    @RequestMapping("/saveOrder")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveOrder(@ModelAttribute("order") Orders orders) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            throw new AccessDeniedException("Access denied: Only administrators can save invoices.");
        }

        orderService.saveOrder(orders);
        return "redirect:/orders";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleAccessDeniedException(AccessDeniedException ex) {
        ModelAndView modelAndView = new ModelAndView("access-denied");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }

    @RequestMapping("/updateOrder")

    public String updateOrder(@RequestParam("ordId") int id, Model model) {
        Orders orders = orderService.getOrder(id);
        model.addAttribute("order", orders);
        return "/bestellungen/edit-order";
    }

    @PostMapping("/order/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateOrder(@PathVariable int id,
                              @ModelAttribute("order") Orders orders,
                              Model model) {


        Orders existingOrder = orderService.getOrder(id);
        existingOrder.setProjektNummer(orders.getProjektNummer());
        existingOrder.setBestellDatum(orders.getBestellDatum());
        existingOrder.setFirma(orders.getFirma());
        existingOrder.setLand(orders.getLand());
        existingOrder.setBestellNummer(orders.getBestellNummer());
        existingOrder.setAngebotNummer(orders.getAngebotNummer());
        existingOrder.setLeistungsBeschreibung(orders.getLeistungsBeschreibung());
        existingOrder.setProjektManager(orders.getProjektManager());
        existingOrder.setPreisNetto(orders.getPreisNetto());
        existingOrder.setZahlungsBedinungen(orders.getZahlungsBedinungen());
        existingOrder.setErstellteBrutto(orders.getErstellteBrutto());
        existingOrder.setRechnungNummer(orders.getRechnungNummer());
        existingOrder.setRechnungDatum(orders.getRechnungDatum());
        existingOrder.setKommentare(orders.getKommentare());

        orderService.updateOrder(existingOrder);

        return "redirect:/orders";
    }

    @GetMapping("/order/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}
