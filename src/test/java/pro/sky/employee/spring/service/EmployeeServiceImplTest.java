package pro.sky.employee.spring.service;

import org.junit.jupiter.api.Test;
import pro.sky.employee.spring.Employee;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.employee.spring.EmployeeConstantTest.*;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();


    @Test
    void findAllEmployee() {
        out.addEmployee(FIRST_NAME, DEPARTMENT_ID, SALARY);
        Map<Integer, List<Employee>> existed = new HashMap<>();
        List<Employee> tempList = new ArrayList<>();
        tempList.add(new Employee(FIRST_NAME, DEPARTMENT_ID, SALARY));
        existed.put(DEPARTMENT_ID, tempList);
        assertEquals(existed, out.findAllEmployeesByDepartments());
    }

    @Test
    void addEmployee() {
        Employee existed = new Employee(FIRST_NAME, DEPARTMENT_ID, SALARY);
        assertEquals(0, out.findAllEmployees().size());
        assertFalse(out.findAllEmployees().containsValue(existed));
        out.addEmployee(FIRST_NAME, DEPARTMENT_ID, SALARY);
        ;
        assertEquals(1, out.findAllEmployees().size());
        assertTrue(out.findAllEmployees().containsValue(existed));

    }


    @Test
    void findDo() {
        out.addEmployee(FIRST_NAME, DEPARTMENT_ID, SALARY);
        Map<String, Employee> existed = new HashMap<>();
        existed.put(FIRST_NAME, new Employee(FIRST_NAME, DEPARTMENT_ID, SALARY));
        assertEquals(existed, out.findAllEmployees());
    }

    @Test
    void shodNotAddEmployeeWithSame() {
        Employee existed = new Employee(FIRST_NAME, DEPARTMENT_ID, SALARY);
        assertEquals(0, out.findAllEmployees().size());
        assertFalse(out.findAllEmployees().containsValue(existed));
        out.addEmployee(FIRST_NAME, DEPARTMENT_ID, SALARY);
        assertNull(out.addEmployee(FIRST_NAME, DEPARTMENT_ID, SALARY));
    }

    @Test
    void findAllEmployeesToCollection() {
        out.addEmployee(FIRST_NAME, DEPARTMENT_ID, SALARY);
        Set<Employee> existed = new HashSet<>();
        existed.add(new Employee(FIRST_NAME, DEPARTMENT_ID, SALARY));
        assertEquals(existed, out.findAllEmployeesToCollection());
    }

    @Test
    void shodRemoveEmployeeByKey() {
        out.addEmployee(FIRST_NAME, DEPARTMENT_ID, SALARY);
        out.removeEmployeeByKey(FIRST_NAME);
        assertEquals(0,out.findAllEmployees().size());
    }
@Test
    void shodTrowRemoveEmployeeByKey() {
        assertThrows(RuntimeException.class,()->out.removeEmployeeByKey(FIRST_NAME));

    }

}