package pro.sky.employee.spring.service;

import pro.sky.employee.spring.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {


    Map<Integer, List<Employee>> findAllEmployeesByDepartments();


    Employee addEmployee(String name, Integer departmentId, Integer salary);


    Employee removeEmployeeByKey(String key);

    Map<String, Employee> findAllEmployees();

    Collection<Employee> findAllEmployeesToCollection();
}
