package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.AplikasiConsole;
import model.Ruangan;
import view.InputRuangan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus A450CA
 */
public class ControllerInputRuangan implements ActionListener{
    private InputRuangan view;
    private AplikasiConsole model;
    
    
     public ControllerInputRuangan( AplikasiConsole model) {
        this.model = model;
        view = new InputRuangan();
        view.addListener(this);
        view.setVisible(true);        
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getBtnTambah())){
            try {
                Ruangan r = new Ruangan(view.getTfKapasitas());
                model.createRuangan(r);
                new ControllerDaftarRuangan(model);
                view.dispose();
            } catch (SQLException sQLException) {
            }            
        }if(ae.getSource().equals(view.getBtnBack())){
           try {
            new ControllerDaftarRuangan(model);
            view.dispose();
        } catch (SQLException sQLException) {
        }
    }
    }
     
}
