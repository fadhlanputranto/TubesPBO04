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
public class Dokter extends Orang{
    private String specialis;

    public Dokter(String nama, int id, String tlp) {
        super(nama, id);
        super.setTlp(tlp);
    }

    public Dokter(String nama, int id,String specialis, String tlp) {
        super(nama, id, tlp);
        this.specialis = specialis;
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

    public void setSpecialis(String specialis) {
        this.specialis = specialis;
    }

    public String getSpecialis() {
        return specialis;
    }
    
    
        
}
