package com.hua.repository;

import com.hua.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: KeyHX
 * @Date: 2022/04/26/13:37
 * @Function:
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
