/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit;

/**
 *
 * @author Asus A450CA
 */
public class Ruangan {
    private int no;
    private int maxPasien;
    private int jumlahPasien;
    private PasienInap[] daftarPasien;

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

    public PasienInap getDaftarPasien(int i) {
        return daftarPasien[i];
    }
    
    
    
    
    
    
    
    
    
}
