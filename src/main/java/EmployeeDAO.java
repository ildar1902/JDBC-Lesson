import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);
    Employee readById(int id);
    List<Employee> readAll();
    void updateAgeById(int id, int age);
    void deleteById(int id);
}
