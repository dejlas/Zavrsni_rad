package com.ds.doniraj.controller;

import com.ds.doniraj.entity.*;
import com.ds.doniraj.repository.DonatingDateRepository;
import com.ds.doniraj.repository.UserRepository;
import com.ds.doniraj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
    @Autowired
    private DonatingDateRepository donatingDateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TownService townService;

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private BloodTypeService bloodTypeService;

    @Autowired
    private DonatingDateService donatingDateService;

    @GetMapping("/admin")
    public String viewUsers(Model model) {
        List<User> userList = userService.findUsers();
        User user = new User();
        DonatingDate donatingDate = new DonatingDate();
        model.addAttribute("userList", userList);
        model.addAttribute("donatingDate", donatingDate);
        model.addAttribute("user", user);
        return "admin";
    }


    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(Model model) {
        User user = new User();
        model.addAttribute("user", model);
        return "index";
    }

    @GetMapping("/donor")
    public String viewDates(Model model) {
        List<DonatingDate> dateList = donatingDateRepository.findAll();
        model.addAttribute("dateList", dateList);
        return "donor";
    }

    @PostMapping("/donor")
    public String donor(Model model, @RequestParam("username") String username) {
        User userFromDb = userService.findByUsername(username);
        if (userFromDb.getPrivilege().getRole().equalsIgnoreCase("donor")) {
            List<DonatingDate> dateList = donatingDateRepository.findByUser(userFromDb);
            model.addAttribute("dateList", dateList);
            model.addAttribute("user", userFromDb);
            return "donor";
        }
        return "redirect:/admin";
    }

    @GetMapping("/register")
    public String showNewUserForm(Model model) {
        User user = new User();
        Town town = new Town();
        Privilege privilege = new Privilege();
        BloodType bloodType = new BloodType();
        model.addAttribute("user", user);
        model.addAttribute("town", town);
        model.addAttribute("privilege", privilege);
        model.addAttribute("bloodType", bloodType);
        return "register";
    }

    @PostMapping("/donateDate")
    public String donateDate(@RequestParam("user.username") String username, @RequestParam("date") String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date formattedDate = formatter.parse(date);
        User user = userService.findByUsername(username);
        DonatingDate donateDate = new DonatingDate();
        donateDate.setUser(user);
        donateDate.setDate(formattedDate);
        donatingDateService.saveDonatingDate(donateDate);
        return "redirect:/admin";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, @RequestParam("townName") String townName, @RequestParam("role") String role, @RequestParam("bloodTypeSymbol") String bloodTypeSymbol) {
        Town town = townService.findByName(townName);
        if (town == null) {
            town = new Town();
            town.setName(townName);
            townService.saveTown(town);
            user.setTown(town);
        } else {
            user.setTown(town);
        }

        Privilege privilege = privilegeService.findByRole(role);
        if (privilege == null) {
            privilege = new Privilege();
            privilege.setRole(role);
            privilegeService.savePrivilege(privilege);
            user.setPrivilege(privilege);
        } else {
            user.setPrivilege(privilege);
        }

        BloodType bloodType = bloodTypeService.findBySymbol(bloodTypeSymbol);
        if (bloodType == null) {
            bloodType = new BloodType();
            bloodType.setSymbol(bloodTypeSymbol);
            bloodTypeService.saveBloodType(bloodType);
            user.setBloodType(bloodType);
        } else {
            user.setBloodType(bloodType);
        }
        String plainPassword = user.getPassword();
        String hashedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(hashedPassword);
        userService.saveUser(user);
        return "redirect:/admin";
    }

}
