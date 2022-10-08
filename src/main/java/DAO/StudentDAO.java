/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.SQLConnection;
import static Config.SQLConnection.conn;
import static Config.SQLConnection.rs;
import static Config.SQLConnection.st;
import DTO.PersonDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StudentDAO {
    
    SQLConnection x ;

    public ArrayList<PersonDTO> StuList() throws ClassNotFoundException, SQLException {
        ArrayList<PersonDTO> dshv = new ArrayList<>();
        x = new SQLConnection();
        try{
            String sql = "SELECT * FROM person";
            x.sqlExcute(sql);
            
            while(rs.next()){
                PersonDTO hv = new PersonDTO();
                hv.setPersonID(rs.getString(1));
                hv.setLastName(rs.getString(2));
                hv.setStName(rs.getString(3));
                hv.setHireDate(rs.getString(4)); 
                hv.setEnrolDate(rs.getString(5));
                dshv.add(hv);
            }
            return dshv;
            
        }catch(SQLException e){
                return null;
            }
        
    }
    
    public boolean addStu(PersonDTO stu){
        boolean result = false;
        try{
            String sql = "INSERT INTO person(Lastname,Firstname,Enrollmentdate) VALUES(?,?,?)";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, stu.getLastName());
            prep.setString(2, stu.getStName());
            prep.setString(3, stu.getEnrolDate());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return result;
    }
    
    public boolean updateStu(PersonDTO stu){
        boolean result = false;
        try {
            String sql = "UPDATE person SET Lastname=?, Firstname=?, Enrollmentdate=? WHERE PersonID=?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, stu.getLastName());
            prep.setString(2, stu.getStName());
            prep.setString(3, stu.getEnrolDate());
            prep.setString(4, stu.getPersonID());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean deleteStu(String stuID){
        boolean result = false;
        try{
            String sql = "DELETE FROM person where PersonID=?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, stuID);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
//    public String lastIdOrder() throws SQLException {
//        String sql = "SELECT * FROM student ORDER BY StudentID DESC LIMIT 1";
//        rs = null;
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery(sql);
//            //SQLConnection.rs = SQLConnection.conn.sqlExcute(sql);
//
//            while (rs.next()) {
//                String data = rs.getString(1);
//                return data;
//            }
//        } catch (SQLException ex) {
//            return null;
//        }
//        return null;
//    }
}
