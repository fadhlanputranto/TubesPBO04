/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AplikasiConsole;
import model.Pasien;
import model.Ruangan;
import view.InputPasien;

/**
 *
 * @author Asus A450CA
 */
public class ControllerInputPasien implements ActionListener{
    AplikasiConsole model;
    InputPasien view;
    Pasien p;

    public ControllerInputPasien(AplikasiConsole model) throws SQLException {
        this.model = model;
        view = new InputPasien();
        view.setVisible(true);
        view.addListener(this);
        p = null;
        view.setCbNoRuangan(model.getComboRuangan());
        view.setCbNamaDokter(model.getComboDokter());        
    }
    
    public ControllerInputPasien(AplikasiConsole model,Pasien p) throws SQLException{
       this.model = model;
       view = new InputPasien();
       view.setVisible(true);
       view.addListener(this);
       this.p = p;
       view.setTfId(p.getId());
       view.setTfNama(p.getNama());
       view.setTfUsia(p.getUsia());
       view.setTaAlamat(p.getAlamat());
       view.setCbNoRuangan(model.getComboRuangan());
       view.setCbNamaDokter(model.getComboDokter());
       view.getBtnTambah().setText("Edit");
       view.setTitle("Edit Pasien");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getBtnTambah())){            
            if(p==null){
                 p = new Pasien(view.getTaAlamat(),view.getTfUsia()
                    , view.getJenisKelamin(), view.getTfNama(), view.getTfTelepon());
                try {
                    model.createPasienInap(p, view.getCbNamaDokter(), view.getCbNoRuangan());
                    view.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(view,"create gagal");
                }
            }
            
            else{
                  p = new Pasien(view.getTaAlamat(),view.getTfUsia()
                    , view.getJenisKelamin(), view.getTfNama(), view.getTfTelepon());
                try {
                    model.updatePasienInap(p, view.getCbNamaDokter(), view.getCbNoRuangan());
                    new ControllerDaftarPasien(model);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(view,"create gagal");
                }                
                view.dispose();
            }
        }
    }
    
    
    
}
