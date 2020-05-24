package by.bsuir.lukashevich.shopdemo.controller;

import by.bsuir.lukashevich.shopdemo.model.Employee;
import by.bsuir.lukashevich.shopdemo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String findAll(Model model){
        List<Employee>  employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/employee-create")
    public String createEmployeeForm(Employee employee){
        return "employee-create";
    }

    @PostMapping("/employee-create")
    public String createEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        logger.info("Employee has been created: " + employee.toString());
        return "redirect:/employees";
    }

    @GetMapping("/employee-delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        logger.info("Employee has been deleted. Id: " + id);
        return "redirect:/employees";
    }

    @GetMapping("/employee-update/{id}")
    public String updateEmployeeForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "employee-update";
    }

    @PostMapping("/employee-update")
    public String updateEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        logger.info("Employee has been updated: " + employee.toString());
        return "redirect:/employees";
    }

}
