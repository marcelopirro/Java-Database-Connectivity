package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
    
    void insert(Seller obj);
    void update(Seller obj);
    void deletById(Integer id);
    Seller findById(Integer id); //Query the database for the object with a parameter ID, if it exists, returns
    List<Seller> findAll(); //Returns all sellers
}
