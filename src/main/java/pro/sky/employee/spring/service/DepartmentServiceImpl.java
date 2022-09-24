package pro.sky.employee.spring.service;

import org.springframework.stereotype.Service;
import pro.sky.employee.spring.Employee;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeMinSalary(Integer departmentId) {
        return employeeService.findAllEmployeesToCollection().stream().
                filter(e -> e.getDepartment() == departmentId).
                min(Comparator.comparingInt(Employee::getSalary)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Employee findEmployeeMaxSalary(Integer departmentId) {
        return employeeService.findAllEmployeesToCollection().stream().
                filter(e -> e.getDepartment() == departmentId).
                max(Comparator.comparingInt(Employee::getSalary)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Set<Employee> findAllEmployeeDepartment(Integer departmentId) {
        return employeeService.findAllEmployeesToCollection().stream().
                filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toSet());

    }
}

