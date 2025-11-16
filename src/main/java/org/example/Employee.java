package org.example;

import java.util.ArrayList;

/* Задание 3. Вариант 5 Определить, есть ли хотя бы один сотрудник с зарплатой более
100000.00.*/

public class Employee {
    private String fullName;
    private Integer age;
    private String department;
    private Double salary;

    public Employee(String fullName, Integer age, String department, Double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // Предзаполненные данные
        employees.add(new Employee("Иванов Иван Иванович", 30, "Отдел продаж", 90000.0));
        employees.add(new Employee("Петров Петр Петрович", 45, "Отдел маркетинга", 120000.0));
        employees.add(new Employee("Сидоров Сидор Сидорович", 28, "Отдел разработки", 95000.0));
        employees.add(new Employee("Кузнецова Анна Сергеевна", 35, "Отдел HR", 105000.0));
        employees.add(new Employee("Морозов Алексей Викторович", 40, "Отдел IT", 98000.0));

        boolean hasHighSalary = false;
        for (Employee emp : employees) {
            if (emp.getSalary() > 100000.0) {
                hasHighSalary = true;
            }
        }
    }
}