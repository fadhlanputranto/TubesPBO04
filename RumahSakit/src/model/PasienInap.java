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
public class PasienInap {
    private Pasien pasien;
    private Dokter dokter;
    private String diagnosa;
    private int nDiagnosa;

    public PasienInap() {
    }

   public PasienInap(int idPasien,int idDokter,String diagnosa) {
        this.pasien = new Pasien();
        this.dokter = new Dokter();
        this.pasien.setId(idPasien);
        this.dokter.setId(idDokter);
        this.diagnosa = diagnosa;
    }
    
    public PasienInap(Pasien p, Dokter d) {
        pasien = p;
        setDokter(d);
    }
    
    public PasienInap(Pasien p, Dokter d,String diagnosa) {
        pasien = p;
        setDokter(d);
        this.diagnosa = diagnosa;
    }

//    public void addDiagnosa(String diagnosa) {
//        if(nDiagnosa < 20){
//            this.diagnosa[nDiagnosa] = diagnosa;
//            nDiagnosa++;
//        }else System.out.println("Penuh");    
//    }
    
    public void setDokter(Dokter d) {
        dokter = d;
    }
    
    public Dokter getDokter() {
        return dokter;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public String getDiagnosa() {
        return diagnosa;
    }
    
        
    public int getnDiagnosa() {
        return nDiagnosa;
    }
 
}
