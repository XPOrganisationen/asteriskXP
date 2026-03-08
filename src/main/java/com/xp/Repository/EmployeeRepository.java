package com.xp.Repository;

import com.xp.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    Employee findEmployeeByUsername(String username);

}
