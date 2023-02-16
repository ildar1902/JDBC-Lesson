import model.Employee;


import java.sql.SQLException;
import java.util.List;


public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee("Стив", "Роджерс", "муж", 30, 1);
        employee1.setName("Алёша");
//        employeeDAO.create(employee1);
        employeeDAO.deleteEmployee(employee1);
        System.out.println(employeeDAO.readById(22));

        List<Employee> listEmployee = employeeDAO.readAll();
        listEmployee.forEach(System.out::println);
    }
}
