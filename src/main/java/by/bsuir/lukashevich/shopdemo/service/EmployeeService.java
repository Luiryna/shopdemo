package by.bsuir.lukashevich.shopdemo.service;

import by.bsuir.lukashevich.shopdemo.model.Employee;
import by.bsuir.lukashevich.shopdemo.repositary.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepositary employeeRepositary;

    @Autowired
    public EmployeeService(EmployeeRepositary employeeRepositary){
        this.employeeRepositary = employeeRepositary;
    }

    public Employee findById(Long id) {
        return employeeRepositary.getOne(id);
    }

    public List<Employee> findAll() {
        return employeeRepositary.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepositary.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepositary.deleteById(id);
    }
}
