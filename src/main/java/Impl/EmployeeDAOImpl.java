package Impl;

import Dao.EmployeeDao;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.sql.Connection;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDao {
    private Connection connection;

    public EmployeeDAOImpl() {
    }

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);

    }

    @Override
    public List<Employee> readAll() {

        List<Employee> employees =
                (List<Employee>) HibernateSessionFactoryUtil
                        .getSessionFactory()
                        .openSession()
                        .createQuery("from Employee ").list();
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        Employee employee = new Employee(id);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
