/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.AplikasiConsole;
import view.MainForm;

/**
 *
 * @author Asus A450CA
 */
public class ControllerMainForm implements ActionListener{
    AplikasiConsole model;
    MainForm view;

    public ControllerMainForm(AplikasiConsole model) {
        this.model = model;
        view = new MainForm();
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getMnPasien())){
            try {
                new ControllerDaftarPasien(model);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
