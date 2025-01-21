package com.casestudy1.webapp.controller;

import com.casestudy1.webapp.database.entity.Services;
import com.casestudy1.webapp.services.ServicesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class 	PetServicesController {


    @Autowired
    ServicesService servicesService;

    @RequestMapping(value = "/addservice", method = RequestMethod.POST)
    public String addpet(@ModelAttribute("services") Services services, HttpSession session, Model model) {
        servicesService.addServices(services);
        return "redirect:/dashboardback";
    }

    @RequestMapping(value = "/petservicepage", method = RequestMethod.GET)
    public String petservicepage() {
        return "petservice";
    }

    @RequestMapping(value = "/editservices/{id}", method = RequestMethod.GET)
    public String updateAppointmentPage(@PathVariable int id , HttpSession session, Model model) {
        System.out.println("ID>>>>>>>>>>>"+id);
        Optional<Services> services = servicesService.getService(id);
        model.addAttribute("service", services.get());
        return "petservice";
    }

    @RequestMapping(value = "/allpetservices", method = RequestMethod.GET)
    public String showAllService(HttpSession session,Model model) {
        List<Services> services = servicesService.getAllService();
        model.addAttribute("servicesList", services);
        return "showpetservices";
    }
}
