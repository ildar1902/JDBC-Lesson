import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "1902";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(
                     "select name, surname, gender, age, city_name " +
                             "from employee inner join city " +
                             "on city.city_id=employee.city_id " +
                             "where employee.id = (?)")) {
            statement.setInt(1, 14);
            final ResultSet resultSet = statement.executeQuery();
            System.out.println("---------------------");
            while (resultSet.next()) {
                String name = "Имя: " + resultSet.getString("name");
                String surname = "Фамилия: " + resultSet.getString("surname");
                String cityName = "Город проживания: " + resultSet.getString("city_name");
                String gender = "Пол: " + resultSet.getString("gender");
                int age = resultSet.getInt("age");

                System.out.println(name );
                System.out.println(surname );
                System.out.println(cityName );
                System.out.println(gender );
                System.out.println("Возраст: " + age );
                System.out.println("---------------------");
            }
        }
        try (Connection connection = getConnection(url, user, password);) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            City city1 = new City(7, "Самара");
            Employee employee1 = new Employee("Сергей", "Есенин", "муж", 25, city1);
/*            employeeDAO.create(employee1);
            employeeDAO.deleteById(15);
            employeeDAO.updateAgeById(14, 18);*/
            System.out.println(employeeDAO.readById(14));
            System.out.println("---------------------");
            System.out.println(employeeDAO.readById(16));
        }
    }
}
