package org.analysistool;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Employees list
        Employee employee1 = new Employee("Abdul Samad", 27, 75000);
        Employee employee2 = new Employee("Mike Hunt", 33, 155000);
        Employee employee3 = new Employee("Frank Levine", 40, 250000);
        Employee employee4 = new Employee("Bella Simpson", 27, 75000);
        Employee employee5 = new Employee("James Taylor", 28, 100000);
        Employee employee6 = new Employee("Mary Tucker", 32, 150000);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);

        //1. Employees with salary more than $100,000
        System.out.println("Employees with salary > $100,000: ");
        employeeList.stream().filter(e -> e.getSalary() > 100000).forEach(System.out::println);

        //2.Average salary of employees over 30
        System.out.println("\nAverage salary of employees over 30years old.");
        double average = employeeList.stream().filter(e -> e.getAge() > 30).collect(Collectors.averagingDouble(Employee::getSalary)).doubleValue();
        System.out.println(average);

        //3. Salary increase by 10%
        System.out.println("\nSalaries of employees increased by 10%");
        List<Object> updatedList = employeeList.stream().peek(e -> {
            double increase = e.getSalary() * 0.10, previousSalary = e.getSalary();
            e.setSalary(previousSalary + increase);
        }).collect(Collectors.toList());

        updatedList.forEach(System.out::println);

        //shorter version
//        employeeList.forEach(e -> e.setSalary(e.getSalary() + (e.getSalary() * 0.10)));
//        employeeList.forEach(System.out::println);
    }
}