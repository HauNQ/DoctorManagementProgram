/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import responsitory.DoctorRes;
import view.Menu;

/**
 *
 * @author Nguyen Quang Hau
 */
public class DoctorSystemProgramming extends Menu<String> {

    private DoctorRes ds = new DoctorRes();

    public DoctorSystemProgramming() {
        super("=====Doctor Management Program=====", new String[]{"Add.", "Update.", "Delete.", "Search", "Display", "Exit."});
    }

    @Override
    public void excute(int n) {
        switch (n) {
            case 1:
                ds.put();
                break;
            case 2:
                ds.update();
                break;
            case 3:
                ds.delete();
                break;
            case 4:
                ds.search();
                break;
            case 5:
                ds.display();
                break;
        }
    }

}
