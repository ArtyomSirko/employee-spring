package pro.sky.employee.spring.service;

import org.springframework.stereotype.Service;
import pro.sky.employee.spring.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

   private Map<String, Employee> employeeBook = new HashMap<>();


    public EmployeeServiceImpl() {
        employeeBook.put("Прокопенко Роман Сергеевич", new Employee("Прокопенко Роман Сергеевич", 2, 65000));
        employeeBook.put("Иванов Андрей Викторович",new Employee("Иванов Андрей Викторович",3, 55000));
        employeeBook.put("Изотов роман Сергеевич", new Employee("Изотов роман Сергеевич", 5, 89000));
        employeeBook.put("Коротких Семен Андреич ", new Employee("Коротких Семен Андреич ", 1, 93000));
        employeeBook.put("Смирнов Артур Михайлович",  new Employee("Смирнов Артур Михайлович", 5, 86000));
        employeeBook.put("Новиков Константин Иванович", new Employee("Новиков Константин Иванович", 4, 73000));
        employeeBook.put("Кроткин Александр Эдуардович", new Employee("Кроткин Александр Эдуардович", 2, 65000));
        employeeBook.put("Шкрильняк Андрей Петрович", new Employee("Шкрильняк Андрей Петрович", 3, 68000));
        employeeBook.put( "Сибогатов Игорь Романович",new Employee("Сибогатов Игорь Романович", 4, 49000));
        employeeBook.put( "Капроизов Артём Александрович",new Employee("Капроизов Артём Александрович", 5, 67000));
    }

    @Override
  public Employee findEmployeeMaxSalary(Integer departmentId) {
        return employeeBook.values().stream().filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(e -> e.getSalary()))
        .orElseThrow();
    }

    @Override
  public Employee findEmployeeMinSalary(Integer departmentId) {
        return employeeBook.values().stream().filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingInt(e -> e.getSalary()))
        .orElseThrow();
    }
    @Override
  public Map<Integer, List<Employee>> findAllEmployee(){
        return employeeBook.values().stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
}

    @Override
    public List<Employee>  findAllEmployeeDepartment(Integer departmentId) {
        return employeeBook.values().stream().filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());

    }
}
