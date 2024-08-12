package com.employee_management;

import java.util.List;

public interface EmployeeService {
    String addEmployee(Employee employee);
    boolean updateEmployee(Long employeeId,Employee updatedEmployee);
    boolean deleteEmployee(Long employeeId);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    boolean addListEmployee(List<Employee> employees);
    List<Employee> searchEmployees(String keyword);

}
