/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Asus A450CA
 */
public abstract class Orang {
    private String nama;
    private int id;
    private String tlp;

    public Orang(String nama, int id) {
        setNama(nama);
        setId(id);
    }
    
    public Orang(String nama, String tlp) {
        setNama(nama);
        setTlp(tlp);
    }

    public Orang(String nama, int id, String tlp) {
        this.nama = nama;
        this.id = id;
        this.tlp = tlp;
    }
    
   
    

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }
    
        
}