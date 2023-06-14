package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

    private Connection conn;

    //Forcing dependency
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deletById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletById'");
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                "SELECT seller.*,department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = department.Id "
                + "WHERE seller.Id = ?");

            st.setInt(1, id); //receives the parameter
            rs = st.executeQuery();
            if (rs.next()) { //checks whether the query contains any records
                Department dep = instantiateDepartment(rs); //calls the function to intent the department

                Seller obj = instantiateSeller(rs, dep); //calls the function to intent the seller
                return obj;
            }
            return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

        
    }


    //Helper Method
    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException{ //propagates the exception because it is already being handled
        Seller obj = new Seller(); //Creating the seller 
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setDepartment(dep); //Department will be the object created
        return obj;
    }

    //Helper Method
    private Department instantiateDepartment(ResultSet rs) throws SQLException { //propagates the exception because it is already being handled
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId")); //Picks up the Department Id 
        dep.setName(rs.getString("DepName")); //Picks up the Department Name 
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Seller> findByDepartment(Department department) { //Selects all salespeople in a given department
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                "SELECT seller.*,department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = department.Id "
                + "WHERE DepartmentId = ? "
                + "ORDER BY Name");

            st.setInt(1, department.getId()); //receives the parameter
            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();

            //Controlling the non-repetition of the department using MAP
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) { //checks whether the query contains any records
                
                Department dep = map.get(rs.getInt("DepartmentId")); 
                /*Using the created map, any instantiated department will be saved, 
                so it is tested if the department already exists before creating a new one */

                if (dep == null){ //If it does not exist it will be created
                    dep = instantiateDepartment(rs); //calls the function to intent the department
                    map.put(rs.getInt("DepartmentId"), dep); //save in Map
                }
                
                Seller obj = instantiateSeller(rs, dep); //calls the function to intent the seller
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    
}