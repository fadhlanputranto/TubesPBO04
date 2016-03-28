/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Asus A450CA
 */
public class AplikasiConsole {
    private List<Orang> orang= new ArrayList<>(); 
    
    public int cariIndeks(int id){
         for(int i=0;i<= orang.size();i++){
             if(orang.get(i).getId() == id){
                 return i;
             }
         }
         return -1;       
    }
    //Pasien
    public void addPasien(Pasien p){
        orang.add(p);
    }
    
    public Pasien cariPasien(int id){
        if((cariIndeks(id)!= -1) && (orang.get(cariIndeks(id)) instanceof 
                Pasien)){
            return (Pasien) orang.get(cariIndeks(id));
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
    
    public Dokter cariDokter(int id){
        for(int i=0;i<= orang.size();i++){
            if(orang.get(i).getId() == id){
                if(orang.get(i) instanceof Dokter){
                    return (Dokter) orang.get(i);
                }
            }
        }
        return null;
    }
    
    public void hapusDokter(int i){
        if(i != -1)
            orang.remove(i);
        else
            System.out.println("ID tidak ditemukan");
    }
    
    //Main Menu
    public void mainMenu(){
        Scanner pilihan = new Scanner(System.in);
        Scanner inputan = new Scanner(System.in);
        System.out.println("========= Main Menu =========");
        System.out.println(" 1. Mengelola Pasien ");
        System.out.println(" 2. Mengelola Dokter ");
        System.out.print("Pilihan : ");
        switch(pilihan.nextInt()){
            
            case 1:
                System.out.println("========= Mengelola Pasien =========");
                System.out.println(" 1. Tambah Pasien ");
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
                        hapusPasien(cariIndeks(inputan.nextInt()));
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
            case 2:
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
                        hapusPasien(cariIndeks(inputan.nextInt()));
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
        }   
    }
    
    
    
}
