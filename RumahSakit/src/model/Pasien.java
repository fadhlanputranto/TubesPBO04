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
public class Pasien extends Orang{
    private String alamat;
    private int usia;
    private String jenisKelamin;

    public Pasien() {
        super(null, 0);
    }
    
    
    public Pasien(String nama, int id, String tlp) {
        super(nama, id);
        super.setTlp(tlp);
    }

    public Pasien(String nama, int id, String tlp,String alamat, int usia, String jenisKelamin ) {
        super(nama, id, tlp);
        this.alamat = alamat;
        this.usia = usia;
        this.jenisKelamin = jenisKelamin;
    }

    public Pasien(String alamat, int usia, String jenisKelamin, String nama, String tlp) {
        super(nama, tlp);
        this.alamat = alamat;
        this.usia = usia;
        this.jenisKelamin = jenisKelamin;
    }

    
    
    
    
    

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public int getUsia() {
        return usia;
    }

    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNama() {
        return super.getNama(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTlp() {
        return super.getTlp(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

