/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.AplikasiConsole;
import view.DaftarPasien;
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
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       //</editor-fold>
        //</editor-fold>
         try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());//ini untuk look and feel (tampilannya nimbuz)
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        view = new MainForm();
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.addListener(this);
        view.setVisible(true);
         
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getItmPasien())){
            //try {
                DaftarPasien dp = new DaftarPasien();
                view.add(dp);
                dp.setVisible(true);
               // new ControllerDaftarPasien(model);
//            } catch (SQLException ex) {
//                Logger.getLogger(ControllerMainForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
    
    
    
}
