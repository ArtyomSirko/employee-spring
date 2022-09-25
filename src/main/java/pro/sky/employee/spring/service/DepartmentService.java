package pro.sky.employee.spring.service;

import pro.sky.employee.spring.Employee;

import java.util.List;
import java.util.Set;

public interface DepartmentService {

    Employee findEmployeeMaxSalary(Integer departmentId);

    Employee findEmployeeMinSalary(Integer departmentId);

    Set<Employee> findAllEmployeeDepartment(Integer departmentId);
}
