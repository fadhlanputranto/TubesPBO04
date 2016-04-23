/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Asus A450CA
 */
public class AplikasiConsole {
    private List<Orang> orang= new LinkedList<>(); 
    private List<Ruangan> ruangan = new LinkedList<>();
    
    /**public int cariIndeks(int id){
         for(int i=0;i<= orang.size();i++){
             if(orang.get(i).getId() == id){
                 return i;
             }
         }
         return -1;       
    }**/
    
    public int cariIndeks(List list,int pk){
        for(int i=0;i<= list.size();i++){
             if(list instanceof Orang){
                if(orang.get(i).getId() == pk){
                    return i;
                }
             } else{
                if(ruangan.get(i).getNo() == pk){
                    return i;
                }
             }
                 
         }
         return -1;       
    }
   
  
    //Pasien
    public void addPasien(Pasien p){
        orang.add(p);
    }
    
    public Pasien cariPasien(int i){
        if(i != -1){
            return (Pasien) orang.get(i);
        }
        return null;
    }
    
    public void hapusPasien(int i){
        if(i != -1)
            orang.remove(i);
        else
            System.out.println("ID tidak ditemukan");
    }
    
    //Dokter
    public void addDokter(Dokter d){
        orang.add(d);
    }
    
    public Dokter cariDokter(int i){
        if(i != -1){
            return (Dokter) orang.get(i);
        }
        return null;
    }
    
    public void hapusDokter(int i){
        if(i != -1)
            orang.remove(i);
        else
            System.out.println("ID tidak ditemukan");
    }
    
    //Ruangan
    public void addRuangan(Ruangan p){
        ruangan.add(p);    
    }
    
    public Ruangan cariRuangan(int no){
        for(int i = 0;i< ruangan.size();i++){
            if(ruangan.get(i).getNo() ==  no){
                return ruangan.get(i);
            }
            
        }
        return null;
    }
        
    
    public void hapusRuangan(int i){
        if(i != -1)
            ruangan.remove(i);
        else
            System.out.println("Ruangan tidak ditemukan");
    }
    //Method Menu
//    public Ruangan
    //Main Menu
    public void mainMenu(){
        String nama;
        int id;
        String tlp;
        String specialis;
        String alamat;
        int usia;
        String jenisKelamin;
        Scanner pilihan = new Scanner(System.in);
        Scanner inputan = new Scanner(System.in);
        System.out.println("========= Main Menu =========");
        System.out.println(" 1. Input Pasien ");
        System.out.println(" 2. Mengelola Pasien ");
        System.out.println(" 3. Mengelola Dokter ");
        System.out.println(" 4. Mengelola Dokter ");
        System.out.print("Pilihan : ");
        switch(pilihan.nextInt()){
            case 1:
                System.out.println("========= Input Pasien =========");
                System.out.print("Nama : ");
                nama = inputan.nextLine();
                System.out.print("ID : ");
                id = inputan.nextInt();
                System.out.print("Usia : ");
                usia = inputan.nextInt();
                System.out.print("Telepon : ");
                tlp = inputan.nextLine();
                System.out.print("Jenis Kelamin : ");
                jenisKelamin = inputan.nextLine();
                System.out.print("Alamat : ");
                alamat = inputan.nextLine();
                Pasien p = new Pasien(nama, id, tlp);
                p.setUsia(usia);
                p.setJenisKelamin(jenisKelamin);
                p.setAlamat(alamat);
                System.out.print("Ruangan : ");
                Ruangan r = cariRuangan(inputan.nextInt());
                while( r == null){
                    System.out.print("Ruangan : ");
                    r = cariRuangan(inputan.nextInt());
                }
                System.out.print("Dokter : ");
                Dokter d = cariDokter(cariIndeks(orang, inputan.nextInt()));
                while( d == null){
                    System.out.print("Dokter ID: ");
                    d = cariDokter(cariIndeks(orang, inputan.nextInt()));
                }
                r.tambahPasienInap(p,d );
                System.out.print("Diagnosa : ");
                r.getDaftarPasienById(id).addDiagnosa(inputan.nextLine());
                
                break;
            case 2:
                System.out.println("========= Mengelola Pasien =========");
                System.out.println(" 1. Edit Pasien ");
                System.out.println(" 2. Hapus Pasien ");
                System.out.println(" 3. Cari Pasien ");
                System.out.println("====================================");
                System.out.print("Pilihan : ");
                switch(pilihan.nextInt()){
                    case 1:
                        break;
                    case 2:
                        System.out.println("========= Hapus Pasien=========");
                        System.out.print("ID Pasien : ");
                        hapusPasien(cariIndeks(orang,inputan.nextInt()));
                        break;
                    case 3:
                        Pasien pasien = cariPasien(inputan.nextInt());
                        System.out.println("========= Data Pasien =========");
                        System.out.println("Nama ;: "+ pasien.getNama());
                        System.out.println("ID : "+ pasien.getId());
                        System.out.println("Usia : "+ pasien.getUsia());
                        System.out.println("Jenis Kelamin : "+ pasien.getJenisKelamin());
                        System.out.println("Telpon : "+ pasien.getTlp());
                        System.out.println("Alamat : "+ pasien.getAlamat());
                        System.out.println("==============================");
                        break;
                                             
                }
            case 3:
                System.out.println("========= Mengelola Dokter =========");
                System.out.println(" 1. Tambah Dokter ");
                System.out.println(" 2. Hapus Dokter ");
                System.out.println(" 3. Cari Dokter ");
                System.out.println("====================================");
                System.out.print("Pilihan : ");
                switch(pilihan.nextInt()){
                    case 1:
                        break;
                    case 2:
                        System.out.println("========= Hapus Pasien=========");
                        System.out.print("ID Pasien : ");
                        hapusPasien(cariIndeks(orang,inputan.nextInt()));
                        break;
                    case 3:
                        Dokter dokter = cariDokter(inputan.nextInt());
                        System.out.println("========= Data Pasien =========");
                        System.out.println("Nama ;: "+ dokter.getNama());
                        System.out.println("ID : "+ dokter.getId());
                        System.out.println("Specialis : "+ dokter.getSpecialis());
                        System.out.println("Telpon : "+ dokter.getTlp());
                        System.out.println("==============================");
                        break;
                }
            case 4:
                break;
        }   
    }
    
    
    
}