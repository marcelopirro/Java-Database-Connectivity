package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

//Static Operations for Instantiating DAO

public class DaoFactory {
    
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}
