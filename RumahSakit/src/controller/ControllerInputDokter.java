/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.AplikasiConsole;
import model.Dokter;
import view.InputDokter;


/**
 *
 * @author Asus A450CA
 */
public class ControllerInputDokter implements ActionListener{
     private InputDokter view;
    private AplikasiConsole model;

    public ControllerInputDokter( AplikasiConsole model) {
        this.model = model;
        view = new InputDokter();
        view.addListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getBtnTambah())){
            try {
                Dokter d = new Dokter(view.getTfNama(), view.getTfKeahlian(), view.getTfTelepon());
                model.createDokter(d);
                new ControllerDaftarDokter(model);
                view.dispose();
            } catch (SQLException sQLException) {
            }
        } if(ae.getSource().equals(view.getBtnBack())){
           try {
            new ControllerDaftarDokter(model);
            view.dispose();
        } catch (SQLException sQLException) {
        }
        }
    }
    
    
    
    
}
