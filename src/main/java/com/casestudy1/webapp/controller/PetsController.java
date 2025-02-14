package com.casestudy1.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import javax.servlet.http.HttpSession;
import com.casestudy1.webapp.database.entity.Appointments;
import com.casestudy1.webapp.database.entity.Services;
import com.casestudy1.webapp.database.entity.Users;
import com.casestudy1.webapp.database.entity.Appointments;
import com.casestudy1.webapp.database.entity.Pets;
import com.casestudy1.webapp.database.entity.Services;
import com.casestudy1.webapp.database.entity.Users;
import com.casestudy1.webapp.form.AppointmentDTO;
import com.casestudy1.webapp.services.AppointmentService;
import com.casestudy1.webapp.services.PetsService;
import com.casestudy1.webapp.services.ServicesService;
import com.casestudy1.webapp.services.UsersService;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//import com.casestudy1.webapp.form.AppointmentDTO;
//import com.casestudy1.webapp.database..Appointments;
//import com.pet.model.Pets;
//import com.pet.model.Services;
//import com.pet.model.Users;
//import com.pet.service.AppointmentService;
//import com.pet.service.PetsService;
//import com.pet.service.ServicesService;
//import com.pet.service.UsersService;

//import javax.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class PetsController {

    private static final Logger LOG = LoggerFactory.getLogger(PetsController.class);

    @Autowired
    PetsService petsService;

    @Autowired
    UsersService usersService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    ServicesService servicesService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage(ModelMap model) {
        ModelAndView response = new ModelAndView();
        response.setViewName( "login");
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelMap model, HttpSession session) {
        session.invalidate();
        ModelAndView response = new ModelAndView();
        response.setViewName( "home");
        return response;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView contact(ModelMap model) {
        ModelAndView response = new ModelAndView();
        LOG.info("Method: contact");
        response.setViewName( "contact");
        return response;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(@RequestParam String name , @RequestParam String password,Model model,HttpSession session) {
        Users users = usersService.geUsersByEmail(name);
        LOG.info("Method: dashboard");
        ModelAndView response = new ModelAndView();
        if (null!=users && users.getEmail().equals(name) && users.getPassword().equals(password)) {
            model.addAttribute("name", users.getName());
            session.setAttribute("users", users);
            model.addAttribute("name", users.getName());
            model.addAttribute("userType", users.getUserRoleid());
            if(0==users.getUserRoleid()) {

                List<Appointments> appointmentsList = appointmentService.getAllAppointmentByUserid(users.getUserid());
                List<AppointmentDTO> appointmentList = new ArrayList<>();
                AppointmentDTO appointmentDTO = null;
                for(Appointments appointments : appointmentsList) {
                    appointmentDTO = new AppointmentDTO();
                    appointmentDTO.setAppointmentId(appointments.getAppointmentid());
                    appointmentDTO.setPetName(petsService.getByPetId(appointments.getPetid()).get().getName());
                    appointmentDTO.setServiceName(servicesService.getService(appointments.getServiceid()).get().getName());
                    appointmentDTO.setStatus(appointments.getStatus());
                    appointmentDTO.setDateTime(appointments.getDate());
                    appointmentList.add(appointmentDTO);
                }
                model.addAttribute("appointmentList", appointmentList);
            }else {
                List<Services> servicesList = servicesService.getAllService();
                model.addAttribute("servicesList", servicesList);
            }
            response.setViewName("dashboard");

            return response;
        } else {
            model.addAttribute("error", "Invalid credentials");
            response.setViewName("login");
            return response;
        }
    }

    @GetMapping("/dashboardback")
    public ModelAndView dashboardback(Model model,HttpSession session) {
        ModelAndView response = new ModelAndView();
        Users users = (Users)session.getAttribute("users");
        model.addAttribute("name", users.getName());
        model.addAttribute("userType", users.getUserRoleid());
        List<Appointments> appointmentsList= null;
        if(0==users.getUserRoleid()) {

            appointmentsList = appointmentService.getAllAppointmentByUserid(users.getUserid());
            List<AppointmentDTO> appointmentList = new ArrayList<>();
            AppointmentDTO appointmentDTO = null;
            for(Appointments appointments : appointmentsList) {
                appointmentDTO = new AppointmentDTO();
                appointmentDTO.setAppointmentId(appointments.getAppointmentid());
                appointmentDTO.setPetName(petsService.getByPetId(appointments.getPetid()).get().getName());
                appointmentDTO.setServiceName(servicesService.getService(appointments.getServiceid()).get().getName());
                appointmentDTO.setStatus(appointments.getStatus());
                appointmentDTO.setDateTime(appointments.getDate());
                appointmentList.add(appointmentDTO);

            }

            model.addAttribute("appointmentList", appointmentList);
        }else {
            List<Services> servicesList = servicesService.getAllService();
            model.addAttribute("servicesList", servicesList);
        }
        response.setViewName("dashboard");
        return response;

    }
    @GetMapping("/petregistration")
    public ModelAndView petRegistration() {
        ModelAndView response = new ModelAndView();
        response.setViewName("petregistration");
        return response;
    }

    @GetMapping(value = "/registration")
    public ModelAndView showsPage(ModelMap model) {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration");
        return response;
    }

    @GetMapping(value = "/aboutme")
    public ModelAndView aboutme(ModelMap model) {
        ModelAndView response = new ModelAndView();
        response.setViewName("aboutme");
        return response;

    }

    @GetMapping(value = "/logout")
    public ModelAndView logout(ModelMap model,HttpSession session) {
        session.invalidate();
        ModelAndView response = new ModelAndView();
        response.setViewName("login");
        return response;
    }
    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public ModelAndView showappointmentPage(HttpSession session,Model model) {
        ModelAndView response = new ModelAndView();
        try {
            Users users = (Users)session.getAttribute("users");
            List<Pets> petList = petsService.getPetByUserId(users.getUserid());
            List<Services> serviceList = servicesService.getAllService();
            model.addAttribute("petList", petList);
            model.addAttribute("serviceList", serviceList);

        }catch(Exception e) {
            response.setViewName("505");
            return response;
        }

        response.setViewName("appointment");
        return response;
    }

    @RequestMapping(value = "/editappointments/{id}", method = RequestMethod.GET)
    public ModelAndView updateAppointmentPage(@PathVariable int id ,HttpSession session,Model model) {
        ModelAndView response = new ModelAndView();
        System.out.println("ID>>>>>>>>>>>"+id);
        Users users = (Users)session.getAttribute("users");
        Optional<Appointments> appointment = appointmentService.getAppointmentById(id);
        List<Pets> petList = petsService.getPetByUserId(users.getUserid());
        model.addAttribute("petList", petList);
        List<Services> serviceList = servicesService.getAllService();
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("appointment", appointment.get());
        response.setViewName("appointment");
        return response;

    }



    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("users") Users users) {
        ModelAndView response = new ModelAndView();
        users.setUserRoleid(0);
        System.out.println(users.getEmail());
        usersService.addUser(users);
        response.setViewName("login");
        return response;
    }

    @RequestMapping(value = "/addpet", method = RequestMethod.POST)
    public ModelAndView addpet(@ModelAttribute("pet") Pets pets,HttpSession session,Model model) {
        ModelAndView response = new ModelAndView();
        Users users = (Users)session.getAttribute("users");
        pets.setUserid(users.getUserid());
        pets.setPetid(pets.getPetid());
        model.addAttribute("userType", users.getUserRoleid());
        petsService.addPet(pets);

        List<Appointments> appointmentsList = appointmentService.getAllAppointmentByUserid(users.getUserid());
//        List<AppointmentDTO> appointmentList = new ArrayList<>();
//        AppointmentDTO appointmentDTO = null;
////        for(Appointments appointments : appointmentsList) {
////            appointmentDTO = new AppointmentDTO();
////            appointmentDTO.setAppointmentId(appointments.getAppointmentid());
////            appointmentDTO.setPetName(petsService.getByPetId(appointments.getPetid()).get().getName());
////            appointmentDTO.setServiceName(servicesService.getService(appointments.getServiceid()).get().getName());
////            appointmentDTO.setStatus(appointments.getStatus());
////            appointmentDTO.setDateTime(appointments.getDate());
////            appointmentList.add(appointmentDTO);
//
//        }
        List<AppointmentDTO> appointmentList = appointmentsList.stream()
                .map(appointments -> {
                    AppointmentDTO appointmentDTO = new AppointmentDTO();
                    appointmentDTO.setAppointmentId(appointments.getAppointmentid());
                    appointmentDTO.setPetName(petsService.getByPetId(appointments.getPetid())
                            .map(pet -> pet.getName())
                            .orElse("Unknown Pet"));
                    appointmentDTO.setServiceName(servicesService.getService(appointments.getServiceid())
                            .map(service -> service.getName())
                            .orElse("Unknown Service"));
                    appointmentDTO.setStatus(appointments.getStatus());
                    appointmentDTO.setDateTime(appointments.getDate());
                    return appointmentDTO;
                })
                .collect(Collectors.toList());


        model.addAttribute("appointmentList", appointmentList);
        response.setViewName("dashboard");

        return response;

    }


    @RequestMapping(value = "/addappointment", method = RequestMethod.POST)
    public ModelAndView addappointment(@ModelAttribute("appointments") Appointments appointments,HttpSession session,Model model) {
        ModelAndView response = new ModelAndView();
        Users users = (Users)session.getAttribute("users");
        appointments.setUserid(users.getUserid());
        appointments.setStatus("Confirmed");
        appointmentService.addAppointment(appointments);
        model.addAttribute("userType", users.getUserRoleid());
        List<Appointments> appointmentsList = appointmentService.getAllAppointmentByUserid(users.getUserid());
        List<AppointmentDTO> appointmentList = new ArrayList<>();
        AppointmentDTO appointmentDTO = null;
        for(Appointments appointments1 : appointmentsList) {
            appointmentDTO = new AppointmentDTO();
            appointmentDTO.setAppointmentId(appointments1.getAppointmentid());
            appointmentDTO.setPetName(petsService.getByPetId(appointments1.getPetid()).get().getName());
            appointmentDTO.setServiceName(servicesService.getService(appointments1.getServiceid()).get().getName());
            appointmentDTO.setStatus(appointments1.getStatus());
            appointmentDTO.setDateTime(appointments1.getDate());
            appointmentList.add(appointmentDTO);

        }

        model.addAttribute("appointmentList", appointmentList);
        response.setViewName("dashboard");
        return response;

    }
}
