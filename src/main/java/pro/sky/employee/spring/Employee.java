package pro.sky.employee.spring;

import java.util.Objects;
 public class Employee {
    private String name;
    private int department;
    private int salary;

    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

     public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getDepartment() == employee.getDepartment() && getSalary() == employee.getSalary() && Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDepartment(), getSalary());
    }
}
