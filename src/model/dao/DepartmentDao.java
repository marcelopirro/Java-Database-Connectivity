package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
    
    void insert(Department obj);
    void update(Department obj);
    void deletById(Integer id);
    Department findById(Integer id); //Query the database for the object with a parameter ID, if it exists, returns
    List<Department> findAll(); //Returns all department
}
