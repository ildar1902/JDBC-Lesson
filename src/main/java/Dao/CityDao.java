package Dao;

import model.City;
import model.Employee;

import java.util.List;

public interface CityDao {
    void create(City city);

    List<City> readAll();

    void update(City city);

    void delete(City city);
}
