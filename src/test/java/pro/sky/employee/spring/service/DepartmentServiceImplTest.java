package pro.sky.employee.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employee.spring.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.employee.spring.EmployeeConstantTest.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldFindEmployeeMinSalaryDepartment() {
        when(employeeService.findAllEmployeesToCollection()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.findEmployeeMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldFindEmployeeMaxSalaryDepartment() {
        when(employeeService.findAllEmployeesToCollection()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, out.findEmployeeMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldFindAllEmployeeDepartmentDepartment() {
        when(employeeService.findAllEmployeesToCollection()).thenReturn(EMPLOYEES);
        assertEquals(Set.of(MIN_SALARY_EMPLOYEE, MAX_SALARY_EMPLOYEE), out.findAllEmployeeDepartment(DEPARTMENT_ID));
    }

    @Test
    public void shouldTrowShouldFindEmployeeMinSalaryDepartmentWhenEmptySet() {
        when(employeeService.findAllEmployeesToCollection()).thenReturn(emptySet());
        assertThrows(IllegalArgumentException.class, () -> out.findEmployeeMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldTrowShouldFindEmployeeMinSalaryDepartmentWhenBadDepartment() {
        when(employeeService.findAllEmployeesToCollection()).thenReturn(EMPLOYEES);
        assertThrows(IllegalArgumentException.class, () -> out.findEmployeeMinSalary(BAD_DEPARTMENT_ID));
    }

}
