package model.dao;

import model.dao.impl.SellerDaoJDBC;

//Static Operations for Instantiating DAO

public class DaoFactory {
    
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
