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
import model.Ruangan;
import view.DaftarRuangan;

/**
 *
 * @author Asus A450CA
 */
public class ControllerDaftarRuangan extends MouseAdapter implements ActionListener {
    private DaftarRuangan view;
    private AplikasiConsole model;
    private int selected;
    
    
     public ControllerDaftarRuangan( AplikasiConsole model) throws SQLException {
        this.model = model;
        view = new DaftarRuangan();
        view.viewRuangan(model.getRuangan());
        view.addListener(this);
        view.addAdapter(this);
        view.setVisible(true);
        view.setMnPasien();
        view.setMnDokter();
        view.setMnRuangan();
    }
     
      @Override
    public void mouseClicked(MouseEvent me) {
       if(me.getSource().equals(view.getTabelRuangan())){
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
       if(ae.getSource().equals(view.getBtnTambahRuangan())){
            try {
               new ControllerInputRuangan(model);
               view.dispose();
           } catch (Exception e) {
           }
       }else if(ae.getSource().equals(view.getBtnHapusRuangan())){
           try {
               Ruangan r = model.getRuangan().get(selected);
               if(r.getJumlahPasien()== 0){
                   model.hapusRuangan(r);
                   new ControllerDaftarRuangan(model);
                   view.dispose();
               }else{
                   JOptionPane.showMessageDialog(view,"Dokter Sedang Terisi");
                   new ControllerDaftarRuangan(model);
                   view.dispose();
               }                   
           } catch (SQLException ex) {
               Logger.getLogger(ControllerDaftarRuangan.class.getName()).log(Level.SEVERE, null, ex);
           }
            }if(ae.getSource().equals(view.getMnPasien())){
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
