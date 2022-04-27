package com.hua.repository;

import com.hua.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.EnumMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: KeyHX
 * @Date: 2022/04/26/13:39
 * @Function:
 */
@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;


    @Test
    void finadAll(){
        System.out.println(employeeRepository.findAll());
    }

    @Test
    void save(){
        Employee employee = new Employee();
        employee.setEmp_name("张月");
        employee.setGender("M");
        employee.setEmail("zhangyue@qq.com");
        employee.setD_id(1);
        Employee employee1 = employeeRepository.save(employee);
        System.out.println(employee1);
    }

    @Test
    void findById(){
        Employee employee = employeeRepository.findById(888).get();
        System.out.println(employee);
    }


    @Test
    void update(){
        Employee employee = new Employee();
        employee.setEmp_id(6);
        employee.setEmp_name("飞月");
        Employee save = employeeRepository.save(employee);
        System.out.println(save);
    }

    @Test
    void delete() {
        employeeRepository.deleteById(6);
    }

}