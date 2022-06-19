package com.ferhat.EmployeeManager.controller;

import com.ferhat.EmployeeManager.model.Employee;
import com.ferhat.EmployeeManager.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/all")
    ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList = employeeService.findAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    ResponseEntity<Employee> getEmployee(@PathVariable ("id") Long id){
        Employee employee= employeeService.findById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee =employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
