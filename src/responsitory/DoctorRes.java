/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import DAO.DoctorDAO;
import java.util.HashMap;
import model.Doctor;

/**
 *
 * @author Nguyen Quang Hau
 */
public class DoctorRes implements IDoctorRes{
    HashMap<String, Doctor> list = new HashMap<>();
    

    @Override
    public void put() {
         if(DoctorDAO.getInstance().add(list)){
             System.out.println("Added\n");
         }else{
             System.out.println("Adding Failure\n");
         }
    }

    @Override
    public void update() { 
        if(DoctorDAO.getInstance().update(list)){
             System.out.println("Updated\n");
         }else{
             System.out.println("Not updating becauase the code does not exist\n");
         }
    }

    @Override
    public void delete() {
        if(DoctorDAO.getInstance().delete(list)){
             System.out.println("Deleted\n");
         }else{
             System.out.println("Not deleting becauase the code does not exist\n");
         }
    }

    @Override
    public void search() {
        System.out.println("Searched List: ");
        DoctorDAO.getInstance().searchByName(list);
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-15s%-19s%-15s\n","CODE","NAME","SPECIALIZATION","AVAILABILITY");
        for (String key : list.keySet()) {
            Doctor d = list.get(key);
            System.out.printf("%-10s%-15s%-24s%-15s\n",d.getCode(),d.getName(),d.getSpecialization(),d.getAvailability());
        }
        System.out.println("-------------------------------------------------");
    }
}
