package com.ferhat.EmployeeManager.service;

import com.ferhat.EmployeeManager.exception.UserNotFoundException;
import com.ferhat.EmployeeManager.model.Employee;
import com.ferhat.EmployeeManager.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repository.save(employee);
    }

    public Employee findById(Long id){
        return  repository.findEmployeeById(id).orElseThrow(
                ()-> new UserNotFoundException("User was not found")
        );
    }

    public List<Employee> findAllEmployees(){
        return repository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return repository.save(employee);
    }

    public void deleteEmployee(Long id){
        repository.deleteEmployeeById(id);
    }
}
