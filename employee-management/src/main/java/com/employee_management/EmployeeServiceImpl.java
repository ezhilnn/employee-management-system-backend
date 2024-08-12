package com.employee_management;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee added successfully";
    }

    @Override
    public boolean updateEmployee(Long employeeId,Employee updatedEmployee) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()) {
            Employee employee1 = employee.get();
            employee1.setFirst_name(updatedEmployee.getFirst_name());
            employee1.setLast_name(updatedEmployee.getLast_name());
            employee1.setGender(updatedEmployee.getGender());
            employee1.setPhone(updatedEmployee.getPhone());
            employee1.setSalary(updatedEmployee.getSalary());
            employee1.setEmail(updatedEmployee.getEmail());
            employee1.setAddress(updatedEmployee.getAddress());
            employee1.setPosition(updatedEmployee.getPosition());
            employeeRepository.save(employee1);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteEmployee(Long employee) {
        Optional<Employee> employee1 = employeeRepository.findById(employee);
        if(employee1.isPresent()) {
            employeeRepository.deleteById(employee);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employeeRepository.getById(id);
        }
        return null;
    }

    @Override
    public boolean addListEmployee(List<Employee> employees) {
        if(employees.size() > 0) {
            employeeRepository.saveAll(employees);
            return true;
        }

        return false;
    }
    @Override
    public List<Employee> searchEmployees(String keyword) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .filter(employee ->
                        employee.getFirst_name().contains(keyword) ||
                                employee.getLast_name().contains(keyword) ||
                                String.valueOf(employee.getAge()).contains(keyword) ||
                                employee.getGender().contains(keyword) ||
                                employee.getAddress().contains(keyword) ||
                                employee.getPhone().contains(keyword) ||
                                employee.getEmail().contains(keyword) ||
                                String.valueOf(employee.getSalary()).contains(keyword) ||
                                employee.getPosition().contains(keyword)
                )
                .collect(Collectors.toList());
    }

}
