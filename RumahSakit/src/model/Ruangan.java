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
public class Ruangan {
    private int no;
    private int maxPasien;
    private int jumlahPasien;
    private PasienInap[] daftarPasien;
    private String ketersediaan;
    
    public Ruangan(int no, int maxPasien) {
        setNo(no);
        setMaxPasien(maxPasien);
    }
    
    public void tambahPasienInap(Pasien p, Dokter d){
        PasienInap PI = new PasienInap(p,d);
        if(jumlahPasien < maxPasien){
            daftarPasien[jumlahPasien] = PI;
            jumlahPasien++;
        }else System.out.println("Penuh");
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    
    public int getMaxPasien() {
        return maxPasien;
    }

    public void setMaxPasien(int maxPasien) {
        this.maxPasien = maxPasien;
    }
    
    public int getJumlahPasien() {
        return jumlahPasien;
    }

    public void setKetersediaan(String ketersediaan) {
        this.ketersediaan = ketersediaan;
    }

    public String getKetersediaan() {
        return ketersediaan;
    }
    
    

    public PasienInap getDaftarPasienByIndex(int i) {
        return daftarPasien[i];
    }

    public PasienInap getDaftarPasienById(int id) {
        int i = 0;
        while(daftarPasien[i].getPasien().getId() != id){
            i++;
        }
        return daftarPasien[i];
        
        
    }
    
    public void deletePasienInap(int i){
        if(daftarPasien[i+1]==null){
            daftarPasien[i]=null;
            jumlahPasien = jumlahPasien-1;
        }else {
            for(int j = i;j<jumlahPasien;j++){
                daftarPasien[j]=daftarPasien[j+1];
                jumlahPasien = jumlahPasien-1;
            }
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
}