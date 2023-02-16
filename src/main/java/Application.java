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
        City c1 = new City(8,"Майами");
        Employee empl1 = new Employee("Иван", "Половинкик", "муж", 21, c1);
        EmployeeDao employeeDAO = new EmployeeDAOImpl();
        CityDao cityDao = new CityDaoImpl();
        cityDao.create(c1);
        employeeDAO.create(empl1);
        List<City> cities = cityDao.readAll();
        cities.forEach(System.out::println);
        List<Employee> employees = employeeDAO.readAll();
        employees.forEach(System.out::println);

    }
}