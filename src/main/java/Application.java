import model.Employee;


import java.sql.SQLException;


public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee(21,"Стив", "Роджерс", "муж", 30, 1);
//        employeeDAO.create(employee1);
//        employeeDAO.deleteEmployee(employee1);
        System.out.println(employeeDAO.readById(22));
/*        List<Employee> listEmployee = employeeDAO.readAll();
        listEmployee.forEach(System.out::println);*/
    }
}
