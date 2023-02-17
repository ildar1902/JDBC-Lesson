package Dao;

import model.Employee;

import java.util.List;

public interface EmployeeDao {
    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
