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
import javax.swing.JOptionPane;

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
    
    public boolean createStudent(String lastName, String Name, String enrolDate){
        //
        boolean flag = false;
        if(lastName.trim().equals("")){
            JOptionPane.showMessageDialog(null, "last name is empty!", "WARNING", JOptionPane.ERROR_MESSAGE);
            
        }
        if(Name.trim().equals("")){
            JOptionPane.showMessageDialog(null, "First name is empty!", "WARNING", JOptionPane.ERROR_MESSAGE);
            
        }
        if(enrolDate.trim().equals("") ){
            JOptionPane.showMessageDialog(null, "Enrollment date is empty!", "WARNING", JOptionPane.ERROR_MESSAGE);
            
        }
        if(!lastName.trim().equals("") && !Name.trim().equals("") && !enrolDate.trim().equals("") ){
            
            
            PersonDTO hv = new PersonDTO();
            hv.setLastName(lastName);
            hv.setStName(Name);
            hv.setEnrolDate(enrolDate);

            flag = stuDAO.addStu(hv);
            if(flag != true)
            {
                JOptionPane.showMessageDialog(null, "Fail!", "WARNING", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Success!", "NOTICE", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        
        return flag;
        
    }
}
