package com.hua.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: KeyHX
 * @Date: 2022/04/26/13:13
 * @Function:
 */
@Entity(name = "tbl_emp")
@Data
public class Employee {
    @Id //表示主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置自增
    private Integer emp_id;
    private String emp_name;
    private String gender;
    private String email;
    private Integer d_id;
}
