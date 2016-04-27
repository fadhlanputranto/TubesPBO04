/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AplikasiConsole;
import model.Dokter;
import model.PasienInap;
import view.DaftarDokter;

/**
 *
 * @author Asus A450CA
 */
public class ControllerDaftarDokter extends MouseAdapter implements ActionListener{
    private DaftarDokter view;
    private AplikasiConsole model;
    private int selected;

    public ControllerDaftarDokter(AplikasiConsole model) throws SQLException {
        this.model = model;
        view = new DaftarDokter();
        view.viewDokter(model.getDokter());
        view.addListener(this);
        view.addAdapter(this);
        view.setVisible(true);
        view.setMnPasien();
        view.setMnDokter();
        view.setMnRuangan();
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
       if(me.getSource().equals(view.getTabelDokter())){
            selected = view.getSelectedDokter();
       }
        
       if(me.getButton() == MouseEvent.BUTTON3){
            view.getjPopupMenu1().show((Component)me.getSource(),me.getX(),me.getY());
       }
    }
    
     @Override
    public void mousePressed(MouseEvent me) {
       if (me.isPopupTrigger()) {
        
    } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(view.getBtnTambahDokter())){
           new ControllerInputDokter(model);
           view.dispose();
       }else if(ae.getSource().equals(view.getBtnHapusDokter())){
           try {
               Dokter d = model.getDokter().get(selected);
               if(model.isDokterTerpakai(d.getId())){
                   JOptionPane.showMessageDialog(view,"Dokter Sedang Terpakai");
                   new ControllerDaftarDokter(model);
                   view.dispose();
               }else
                   model.hapusDokter(d);
                   new ControllerDaftarDokter(model);
                   view.dispose();
           } catch (SQLException ex) {
               Logger.getLogger(ControllerDaftarDokter.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else if(ae.getSource().equals(view.getMnPasien())){
            try {
                new ControllerDaftarPasien(model);
                view.dispose();
            } catch (SQLException sQLException) {
            }
        }else if(ae.getSource().equals(view.getMnDokter())){
            try {
                new ControllerDaftarDokter(model);
                view.dispose();
            } catch (SQLException sQLException) {
            }
        }else if(ae.getSource().equals(view.getMnRuangan())){           
                try {
               new ControllerDaftarRuangan(model);
               view.dispose();
           } catch (SQLException sQLException) {
           }           
        }
           
    }
    
    
}
