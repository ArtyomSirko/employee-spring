package pro.sky.employee.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.spring.Employee;
import pro.sky.employee.spring.service.DepartmentService;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {

        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.findEmployeeMinSalary(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.findEmployeeMaxSalary(departmentId);
    }

    @GetMapping("/all_departent_employee")
    public Set<Employee> findAllEmployeeDepartment(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.findAllEmployeeDepartment(departmentId);
    }
}
