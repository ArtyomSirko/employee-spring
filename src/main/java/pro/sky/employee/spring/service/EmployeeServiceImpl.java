package pro.sky.employee.spring.service;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;
import pro.sky.employee.spring.Employee;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();


    public EmployeeServiceImpl() {
        /*employees.put("Прокопенко Роман Сергеевич", new Employee("Прокопенко Роман Сергеевич", 2, 65000));
        employees.put("Иванов Андрей Викторович", new Employee("Иванов Андрей Викторович", 3, 55000));
        employees.put("Изотов роман Сергеевич", new Employee("Изотов роман Сергеевич", 5, 89000));
        employees.put("Коротких Семен Андреич ", new Employee("Коротких Семен Андреич ", 1, 93000));
        employees.put("Смирнов Артур Михайлович", new Employee("Смирнов Артур Михайлович", 5, 86000));
        employees.put("Новиков Константин Иванович", new Employee("Новиков Константин Иванович", 4, 73000));
        employees.put("Кроткин Александр Эдуардович", new Employee("Кроткин Александр Эдуардович", 2, 65000));
        employees.put("Шкрильняк Андрей Петрович", new Employee("Шкрильняк Андрей Петрович", 3, 68000));
        employees.put("Сибогатов Игорь Романович", new Employee("Сибогатов Игорь Романович", 4, 49000));
        employees.put("Капроизов Артём Александрович", new Employee("Капроизов Артём Александрович", 5, 67000));*/
    }


    public Map<Integer, List<Employee>> findAllEmployeesByDepartments() {
        return employees.values().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }


    @Override
    public Employee addEmployee(String name, Integer departmentId, Integer salary) {
        Employee newEmployee = new Employee(name, departmentId, salary);
        name = StringUtils.capitalize(name);
        if (!employees.containsKey(name)) {
            employees.put(name, new Employee(name, departmentId, salary));
            return newEmployee;
        } else {
            System.out.println("this BADDD");
            return null;
        }
    }

    @Override
    public Employee removeEmployeeByKey(String key) {
        if (!employees.containsKey(key))
            throw new RuntimeException("Данного сотрудника не существует!");
        return employees.remove(key);
    }

    @Override
    public Map<String, Employee> findAllEmployees() {
        return employees;
    }

    @Override
    public Set<Employee> findAllEmployeesToCollection() {
        return employees.values().stream().collect(Collectors.toSet());
    }
}