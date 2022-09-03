package pro.sky.employee.spring.service;

import pro.sky.employee.spring.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee findEmployeeMaxSalary(Integer departmentId);

    Employee findEmployeeMinSalary(Integer departmentId);

    Map<Integer, List<Employee>> findAllEmployee();
}
