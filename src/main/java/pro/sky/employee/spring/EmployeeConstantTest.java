package pro.sky.employee.spring;

import pro.sky.employee.spring.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeConstantTest {
    public static final String FIRST_NAME = "Mary Petrovna";
    private static final String FIRST_NAME2 = "Sasha Ivanov";

    public static final int SALARY = 300;
    public static final int MIN_SALARY = 200;
    public static final int DEPARTMENT_ID = 1;
    public static final int BAD_DEPARTMENT_ID = 2;
    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME2, DEPARTMENT_ID, SALARY);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME, DEPARTMENT_ID, MIN_SALARY);
    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME, SALARY, DEPARTMENT_ID);
    public static final Set<Employee> EMPLOYEES = Set.of(MIN_SALARY_EMPLOYEE, MAX_SALARY_EMPLOYEE);
    public static final Set<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES = Set.of(MIN_SALARY_EMPLOYEE, DIFFERENT_DEPARTMENT_EMPLOYEE);
    public static final Map<Integer, List<Employee>> DEPARTMENT_MAP = DIFFERENT_DEPARTMENT_EMPLOYEES.stream().collect(groupingBy(Employee::getDepartment));


}
