package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @ManyToOne(cascade = CascadeType.ALL) //кажется, так правильнее
    @JoinColumn(name = "city_id")
    private City city;

    public Employee() {
    }
    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name, String surname, String gender, int age, City city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee(String name, String surname, String gender, int age, City city) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }
    public Employee(String name, String surname, String gender, int age) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(gender, employee.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender, age);
    }

    @Override
    public String toString() {
        return name +" " + surname + ", пол: " + gender + ", возраст: " + age + ", " + city;
    }
}
