package org.example.employeeresthandson.dao;

import java.util.ArrayList;
import java.util.List;

import org.example.employeeresthandson.exception.EmployeeNotFoundException;
import org.example.employeeresthandson.model.Department;
import org.example.employeeresthandson.model.Employee;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDao {

    public Employee getEmployee() {

        Department department = new Department(1, "IT");

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Prakhar");
        employee.setSalary(50000);
        employee.setPermanent(true);
        employee.setDepartment(department);

        return employee;
    }
    public List<Employee> getEmployees() {

        List<Employee> employees = new ArrayList<>();

        Department it = new Department(1, "IT");
        Department hr = new Department(2, "HR");

        employees.add(new Employee(1, "Prakhar", 50000, true, it));
        employees.add(new Employee(2, "Aman", 45000, false, hr));
        employees.add(new Employee(3, "Kush", 60000, true, it));

        return employees;
    }
    public Employee getEmployee(int id) {

        for (Employee employee : getEmployees()) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
}