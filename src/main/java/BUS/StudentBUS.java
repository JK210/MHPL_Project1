/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.StudentDAO;
import DTO.PersonDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StudentBUS {
    private StudentDAO stuDAO = new StudentDAO();
    private ArrayList<PersonDTO> stuList = null;
   

    public StudentBUS() {
    }
    
    public ArrayList<PersonDTO> getStuList() {
        try {
            
            if(stuList == null){
                this.stuList = stuDAO.StuList();
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.stuList;
        
    }
}
