package com.hua.controller;

import com.hua.entity.Employee;
import com.hua.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: KeyHX
 * @Date: 2022/04/26/13:54
 * @Function:
 */
@RestController//Controller + Response
@RequestMapping("/employee")
public class EmployeeHandler {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 按页数查询数据
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findAll/{page}/{size}")
    public Page<Employee> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page - 1,size);//页码从0开始
        return employeeRepository.findAll(pageable);
    }

    /**
     * 保存数据
     * @param employee
     * @return
     */
    @PostMapping("/save")
    public String save(@RequestBody Employee employee){
        Employee result = employeeRepository.save(employee);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * 根据id查找数据，用在点击修改时
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public Employee findById(@PathVariable("id") Integer id){
        return employeeRepository.findById(id).get();
    }

    /**
     * 点击修改后保存数据
     * @param employee
     * @return
     */
    @PutMapping("/update")
    public String update(@RequestBody Employee employee){
        Employee result = employeeRepository.save(employee);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        employeeRepository.deleteById(id);
    }
}
