package com.wmt.jdk8.OptionalDemo;

import com.wmt.jdk8.model.Company;
import com.wmt.jdk8.model.Employee;

import java.util.*;

public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee=new Employee();
        employee.setName("zhangsan");
        Employee employee2=new Employee();
        employee2.setName("lisi");
        Company company=new Company();
        company.setName("compay1");
        List<Employee> employees= Arrays.asList(employee,employee2);
        company.setEmployees(employees);
        List<Employee> list=company.getEmployees();
        Optional<Company> optional=Optional.ofNullable(company);
        System.out.println(optional.map(theCompany->theCompany.getEmployees())
                .orElse(Collections.emptyList()));
    }
}
