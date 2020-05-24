package by.bsuir.lukashevich.shopdemo.repositary;

import by.bsuir.lukashevich.shopdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositary extends JpaRepository<Employee, Long> {
}
