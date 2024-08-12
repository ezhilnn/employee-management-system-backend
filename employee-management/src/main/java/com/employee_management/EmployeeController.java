package com.employee_management;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);

    }
    @PostMapping()
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        boolean updated=employeeService.updateEmployee(id,employee);
        if(updated) {
            return new ResponseEntity<>("Employee Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee Not Updated",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean deleted=employeeService.deleteEmployee(id);
        if(deleted) {
            return new ResponseEntity<>("Employee Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee Not Deleted",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<String> addListEmployee(@RequestBody List<Employee> employees) {
        boolean added=employeeService.addListEmployee(employees);
        if(added) {
            return new ResponseEntity<>("Employees Added Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Employees Not Added",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Employee>> searchEmployees(@PathVariable String keyword) {
        List<Employee> employees = employeeService.searchEmployees(keyword);
        if (!employees.isEmpty()) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
