import Dao.CityDao;
import Dao.CityDaoImpl;
import Dao.EmployeeDao;
import Impl.EmployeeDAOImpl;
import model.City;
import model.Employee;


import java.sql.SQLException;
import java.util.List;


public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDao employeeDAO = new EmployeeDAOImpl();
        CityDao cityDao = new CityDaoImpl();
//        employeeDAO.deleteEmployeeById(14);
        Employee employee11 = new Employee(16, "Сергей", "Безруков", "муж", 27, new City(2, "Тюмень"));
        employeeDAO.updateEmployee(employee11);
        List<Employee> employees = employeeDAO.readAll();
        employees.forEach(System.out::println);

    }
}

// 16 | Сергей | Есенин      | муж    |  25 |       7 |       7 | Самара