/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JComboBox;

/**
 *
 * @author Asus A450CA
 */
public class AplikasiConsole {
    private ArrayList<Pasien> pasien; 
    private ArrayList<Dokter> dokter; 
    private ArrayList<Ruangan> ruangan; 
    private Database con;

    public AplikasiConsole() throws SQLException {
        pasien= new ArrayList(); 
        dokter= new ArrayList(); 
        ruangan= new ArrayList(); 
        con = new Database();
        con.connect();
    }
    
    //===== create
    public void createPasienInap(Pasien p,String namaDokter,int noRuangan,String diagnosa) throws SQLException{
        Dokter d = con.cariDokter(namaDokter);
        Ruangan r = con.cariRuangan(noRuangan);
        r.setDaftarPasien(r.getMaxPasien());
        r.tambahPasienInap(p, d,diagnosa);;
        con.savePasien(p);
        con.updateRuangan(r);
        con.savePasienInap(p, d, r);
    }      
    //=== Hapus
    public void hapusPasien(Pasien p) throws SQLException{
        con.hapusPasienInap(p.getId());
    }
    
//    public void hapusDokter(Pasien p) throws SQLException{
//        con.hapusPasienInap(p.getId());
//    }
//    
//    public void hapusPasien(Pasien p) throws SQLException{
//        con.hapusPasienInap(p.getId());
//    }
    
    //==== Update
    /**public void updateTambahPasienInap(Pasien p,String namaDokter, int no) throws SQLException{
        p = cariDeletePasienInap(p.getId());
        Dokter d = con.cariDokter(namaDokter);
        Ruangan r = con.cariRuangan(no);
        r.setDaftarPasien(r.getMaxPasien());
        r.tambahPasienInap(p, d);
        con.updateRuangan(r);
        con.updatePasienINap(p, r, d);
        
        
    }**/
    
    public void updatePasienInap(Pasien p,String namaDokter, int no) throws SQLException{
        Dokter d = con.cariDokter(namaDokter);
        Ruangan r = cariRuangan(no);
        r.tambahPasienInap();
        r.setJumlahPasien(r.getJumlahPasien()-1);
        con.updateRuangan(r);
        con.updatePasienINap(p, r, d);        
    }
    
    public void updateHapusPasienInap(Pasien p, int no) throws SQLException{
        Ruangan r = cariRuangan(no);
        r.setJumlahPasien(r.getJumlahPasien()-1);
        con.hapusPasienInap(p.getId());
        con.updateRuangan(r);
        
        
    }
    
    public void updateRuangan(Ruangan r) throws SQLException{
        con.updateRuangan(r);
    }
    //==== GET
    public PasienInap getPasienInap(int selected) throws SQLException{
        ArrayList<PasienInap> pi = con.loadPasienInap();
        PasienInap pai = pi.get(selected);
        return pai;
    }
    public ArrayList<Ruangan> getPasienInap() throws SQLException{
        return con.loadRuanganPasienInap();
    }
    
     public ArrayList<Ruangan> getRuangan() throws SQLException{
        return con.loadRuangan();
    }
     
     public ArrayList<Dokter> getDokter() throws SQLException{
        return con.loadDokter();
    }
     
    public ArrayList<String> getComboDokter() throws SQLException{
        return con.comboDokter();
    }
    
     public  ArrayList<String> getComboRuangan() throws SQLException{
        return con.comboRuangan();
    }
     //======= SET
     
    //===== ADD 
    public void addPasien(Pasien p){
        pasien.add(p);
    }
    
    public void addDokter(Dokter d){
        dokter.add(d);
    }
    
    public void addRuangan(Ruangan p){
        ruangan.add(p);    
    }
    
    //==== CARI
    public Pasien cariPasien(int id) throws SQLException{        
        return con.cariPasien(id);
    }
    
    public Dokter cariDokter(int id){        
        for(int i=0;i<= dokter.size();i++){
            if(dokter.get(i).getId() == id){
                return dokter.get(i);
            }
        }
        return null;
    }
    
    public Dokter cariDokter(String nama){        
        for(int i=0;i<= dokter.size();i++){
            if(dokter.get(i).getNama()== nama){
                return dokter.get(i);
            }
        }
        return null;
    }
    
    public Ruangan cariArrRuangan(int no){        
        for(int i=0;i<= ruangan.size();i++){
            if(ruangan.get(i).getNo() == no){
                return ruangan.get(i);
            }
        }
        return null;
    }
    
    public int cariNoRuangan(int id) throws SQLException{
        return con.cariNoRuangan(id);
    }
    public Ruangan cariRuangan(int no) throws SQLException{
        return con.cariRuangan(no);
    }
    
    public Pasien cariDeletePasienInap(int id) throws SQLException{
         for(int i = 0;i< ruangan.size();i++){
             for(int j = 0;j< ruangan.get(i).getJumlahPasien();i++){
                 if(ruangan.get(i).getDaftarPasienByIndex(j).getPasien().getId() ==  id){
                     Pasien p = ruangan.get(i).getDaftarPasienByIndex(j).getPasien();
                     ruangan.get(i).deletePasienInap(j);
                     con.updateRuangan(ruangan.get(i));
                    return p;
                }            
             }    
        }
        return null;
    }

    public void setPasien(ArrayList<Pasien> pasien) {
        this.pasien = pasien;
    }

    public void setDokter(ArrayList<Dokter> dokter) {
        this.dokter = dokter;
    }

    public void setRuangan(ArrayList<Ruangan> ruangan) {
        this.ruangan = ruangan;
    }
    
    
    
    //====================================
   
    /**public int cariIndeks(int id){
         for(int i=0;i<= orang.size();i++){
             if(orang.get(i).getId() == id){
                 return i;
             }
         }
         return -1;       
    }**/
    
    

    
//    
//    public void hapusPasien(int i){
//        if(i != -1)
//            orang.remove(i);
//        else
//            System.out.println("ID tidak ditemukan");
//    }
//    
//    //Dokter
//    
//    
//    public Dokter cariDokter(int i){
//        if(i != -1){
//            return dokter.get(i);
//        }
//        return null;
//    }
//    
//    public void hapusDokter(int i){
//        if(i != -1)
//            orang.remove(i);
//        else
//            System.out.println("ID tidak ditemukan");
//    }
//    
//    //Ruangan
//    
//    
//    
//        
//    
//    public void hapusRuangan(int i){
//        if(i != -1)
//            ruangan.remove(i);
//        else
//            System.out.println("Ruangan tidak ditemukan");
//    }
//    //Method Menu
////    public Ruangan
//    //Main Menu
//    public void mainMenu(){
//        String nama;
//        int id;
//        String tlp;
//        String specialis;
//        String alamat;
//        int usia;
//        String jenisKelamin;
//        Scanner pilihan = new Scanner(System.in);
//        Scanner inputan = new Scanner(System.in);
//        System.out.println("========= Main Menu =========");
//        System.out.println(" 1. Input Pasien ");
//        System.out.println(" 2. Mengelola Pasien ");
//        System.out.println(" 3. Mengelola Dokter ");
//        System.out.println(" 4. Mengelola Dokter ");
//        System.out.print("Pilihan : ");
//        switch(pilihan.nextInt()){
//            case 1:
//                System.out.println("========= Input Pasien =========");
//                System.out.print("Nama : ");
//                nama = inputan.nextLine();
//                System.out.print("ID : ");
//                id = inputan.nextInt();
//                System.out.print("Usia : ");
//                usia = inputan.nextInt();
//                System.out.print("Telepon : ");
//                tlp = inputan.nextLine();
//                System.out.print("Jenis Kelamin : ");
//                jenisKelamin = inputan.nextLine();
//                System.out.print("Alamat : ");
//                alamat = inputan.nextLine();
//                Pasien p = new Pasien(nama, id, tlp);
//                p.setUsia(usia);
//                p.setJenisKelamin(jenisKelamin);
//                p.setAlamat(alamat);
//                System.out.print("Ruangan : ");
//                Ruangan r = cariRuangan(inputan.nextInt());
//                while( r == null){
//                    System.out.print("Ruangan : ");
//                    r = cariRuangan(inputan.nextInt());
//                }
//                System.out.print("Dokter : ");
//                Dokter d = cariDokter(cariIndeks(orang, inputan.nextInt()));
//                while( d == null){
//                    System.out.print("Dokter ID: ");
//                    d = cariDokter(cariIndeks(orang, inputan.nextInt()));
//                }
//                r.tambahPasienInap(p,d );
//                System.out.print("Diagnosa : ");
//                r.getDaftarPasienById(id).addDiagnosa(inputan.nextLine());
//                
//                break;
//            case 2:
//                System.out.println("========= Mengelola Pasien =========");
//                System.out.println(" 1. Edit Pasien ");
//                System.out.println(" 2. Hapus Pasien ");
//                System.out.println(" 3. Cari Pasien ");
//                System.out.println("====================================");
//                System.out.print("Pilihan : ");
//                switch(pilihan.nextInt()){
//                    case 1:
//                        break;
//                    case 2:
//                        System.out.println("========= Hapus Pasien=========");
//                        System.out.print("ID Pasien : ");
//                        hapusPasien(cariIndeks(orang,inputan.nextInt()));
//                        break;
//                    case 3:
//                        Pasien pasien = cariPasien(inputan.nextInt());
//                        System.out.println("========= Data Pasien =========");
//                        System.out.println("Nama ;: "+ pasien.getNama());
//                        System.out.println("ID : "+ pasien.getId());
//                        System.out.println("Usia : "+ pasien.getUsia());
//                        System.out.println("Jenis Kelamin : "+ pasien.getJenisKelamin());
//                        System.out.println("Telpon : "+ pasien.getTlp());
//                        System.out.println("Alamat : "+ pasien.getAlamat());
//                        System.out.println("==============================");
//                        break;
//                                             
//                }
//            case 3:
//                System.out.println("========= Mengelola Dokter =========");
//                System.out.println(" 1. Tambah Dokter ");
//                System.out.println(" 2. Hapus Dokter ");
//                System.out.println(" 3. Cari Dokter ");
//                System.out.println("====================================");
//                System.out.print("Pilihan : ");
//                switch(pilihan.nextInt()){
//                    case 1:
//                        break;
//                    case 2:
//                        System.out.println("========= Hapus Pasien=========");
//                        System.out.print("ID Pasien : ");
//                        hapusPasien(cariIndeks(orang,inputan.nextInt()));
//                        break;
//                    case 3:
//                        Dokter dokter = cariDokter(inputan.nextInt());
//                        System.out.println("========= Data Pasien =========");
//                        System.out.println("Nama ;: "+ dokter.getNama());
//                        System.out.println("ID : "+ dokter.getId());
//                        System.out.println("Specialis : "+ dokter.getSpecialis());
//                        System.out.println("Telpon : "+ dokter.getTlp());
//                        System.out.println("==============================");
//                        break;
//                }
//            case 4:
//                break;
//        }   
//    }
//    
//    
    
}
