/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import common.Validation;
import java.util.Collection;
import java.util.HashMap;
import model.Doctor;

/**
 *
 * @author Nguyen Quang Hau
 */
public class DoctorDAO {
    private static DoctorDAO instance = null;
    private Validation val = new Validation();

    public static DoctorDAO getInstance() {
        if (instance == null) {
            synchronized (DoctorDAO.class) {
                if (instance == null) {
                    instance = new DoctorDAO();
                }
            }
        }
        return instance;
    }
    
    public boolean add(HashMap<String, Doctor> list){
        String code;
        while(true){
           code = val.getString("Enter code(Dxxxx): ", "D\\d{4}","Please following this format[Dxxxx].Try again.");
           if(!val.isIdExisted(list, code)) break;
           else System.out.println("Doctor code [Code] is duplicate. Try again.");
        }
        
        String name = val.getString("Enter name: ");
        String specialization = val.getString("Enter specialization: ");
        int availability = val.getIntData("Enter availability:" , 0);
        
        list.put(code, new Doctor(code, name, specialization, availability));
        
        return true;
    }
    
    public boolean update(HashMap<String, Doctor> list){
        String code = val.getString("Enter code(Dxxxx): ", "D\\d{4}","Please following this format[Dxxxx].Try again.");
        
        if( list.containsKey(code)){
            String newName = val.getStringDataCanBlank("Enter new name: ");
            String newSpecializaton = val.getStringDataCanBlank("Enter new Specialization: ");
            String availability = val.getStringDataCanBlank("Enter new availability: ", "^\\d+$");
            int intAvailability =0;
            
            if(newName.trim().length() == 0) newName = list.get(code).getName();
            if(newSpecializaton.trim().length() == 0) newSpecializaton = list.get(code).getSpecialization();
            if(availability.trim().length() != 0){
                 try {
                    intAvailability = Integer.parseInt(availability.trim());
                } catch (Exception e) {
                    return false;
                }
            }
            
            list.replace(code, new Doctor(code, newName, newSpecializaton, intAvailability));
            return true;
        }
        
        System.out.println("Doctor code does not exist");
        return false;
    }

    public boolean delete(HashMap<String, Doctor> list) {
        String code = val.getString("Enter code(Dxxxx): ", "D\\d{4}","Please following this format[Dxxxx].Try again.");
        
        return list.remove(code) != null;
    }

    public void searchByName(HashMap<String, Doctor> list) {
        String name = val.getString("Enter name: ");
        Collection<Doctor> doctors = list.values();
        
        doctors.forEach(doctor -> {
            if(doctor.getName().contains(name))
                System.out.println(doctor);
        });
        System.out.println("\n\n");
    }
}
