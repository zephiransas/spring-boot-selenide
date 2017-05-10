package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/")
    public String hello(Model model) throws Exception {
        model.addAttribute("employees", employeeRepository.findAll());
        return "hello";
    }

}
