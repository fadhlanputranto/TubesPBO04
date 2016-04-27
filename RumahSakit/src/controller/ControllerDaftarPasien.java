/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.oracle.util.Checksums;
import database.Database;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AplikasiConsole;
import model.Pasien;
import model.PasienInap;
import model.Ruangan;
import view.DaftarPasien;

/**
 *
 * @author Asus A450CA
 */
public class ControllerDaftarPasien extends MouseAdapter implements ActionListener{    
    private DaftarPasien view;
    private AplikasiConsole model;
    private int selected;

    public ControllerDaftarPasien(AplikasiConsole model) throws SQLException {
        this.model = model;
        view = new DaftarPasien();
        view.viewPasienIinap(model.getPasienInap());
        view.addListener(this);
        view.addAdapter(this);
        view.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       if(me.getSource().equals(view.getTabelPasien())){
            selected = view.getSelectedPasien();
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getBtnPasienBaru())){
            try {
                new ControllerInputPasien(model);
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerDaftarPasien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(ae.getSource().equals(view.getBtnEdit())){
            try {
                PasienInap pi = view.getViewPasienInap(model.getPasienInap(), selected);
                Pasien p = model.cariPasien(pi.getPasien().getId());
                new ControllerInputPasien(model, p);
                view.dispose();
            } catch (SQLException sQLException) {
                    JOptionPane.showMessageDialog(view,"gagal");
            }
        }else if(ae.getSource().equals(view.getBtnHapusPasien())){
            try {
                PasienInap pi = view.getViewPasienInap(model.getPasienInap(), selected);
                model.updateHapusPasienInap(pi.getPasien(), model.cariNoRuangan(pi.getPasien().getId()));
                view.dispose();
                new ControllerDaftarPasien(model);
            } catch (SQLException sQLException) {
                 JOptionPane.showMessageDialog(view,"gagal");
            }
        }
    }
    
    
    
}
