package com.xp.Service;

import com.xp.Exceptions.EntityDoesNotExistException;
import com.xp.Model.Employee;
import com.xp.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long adminId) {
        var employee =  employeeRepository.findById(adminId);
        return employeeRepository.findById(adminId)
                .orElseThrow(() -> new EntityDoesNotExistException("No Employee found with ID " + adminId));
    }

    @Override
    public Employee findEmployeeByUsername(String username) {
        return employeeRepository.findEmployeeByUsername(username);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (!employeeRepository.existsById(employee.getEmployeeId())) {
            throw new EntityDoesNotExistException("No Employee found with ID " + employee.getEmployeeId());
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long adminId) {
        if (!employeeRepository.existsById(adminId)) {
            throw new EntityDoesNotExistException("No Employee found with ID " + adminId);
        }

        employeeRepository.deleteById(adminId);
    }

    public boolean login(String username, String password) {
        Employee employee = employeeRepository.findEmployeeByUsername(username);
        return employee.getEmployeePassword().equals(password);
    }

}

