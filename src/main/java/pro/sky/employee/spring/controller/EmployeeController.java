package pro.sky.employee.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.spring.Employee;
import pro.sky.employee.spring.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }






    @GetMapping("/all")
    public Map<Integer, List<Employee>> allEmployee() {
        return employeeService.findAllEmployeesByDepartments();
    }

//    @GetMapping("/allDepartment")
//    public List<Employee> allEmployeeDepartment(@RequestParam("departmentId") Integer departmentId) {
//        return employeeService.findAllEmployeeDepartment(departmentId);
//    }

    @GetMapping("/add")
    public Employee addEmployer(@RequestParam("name") String name,
                                @RequestParam("departmentId") Integer departmentId,
                                @RequestParam("salary") Integer salary) {
        return employeeService.addEmployee(name, departmentId, salary);
    }
}

