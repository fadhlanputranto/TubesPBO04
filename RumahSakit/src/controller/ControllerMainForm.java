/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.AplikasiConsole;
import view.MainForm;

/**
 *
 * @author Asus A450CA
 */
public class ControllerMainForm {
    AplikasiConsole model;
    MainForm view;

    public ControllerMainForm(AplikasiConsole model) {
        this.model = model;
        view = new MainForm();
    }
    
    
}
