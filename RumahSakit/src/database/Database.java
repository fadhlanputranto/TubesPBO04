/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Dokter;
import model.Pasien;
import model.PasienInap;
import model.Ruangan;

/**
 *
 * @author Asus A450CA
 */
public class Database {
    private String dbname = "jdbc:mysql://localhost:3306/pbo";
    private String dbuser = "root";
    private String dbpass = "";
    private Statement statement;
    private Connection connection;
    Ruangan ru;
    
    
    public void connect() throws SQLException{
        connection = DriverManager.getConnection(dbname, dbuser, dbpass);
        statement = connection.createStatement();
    }
    //====== SAVE
    public void  saveDokter(Dokter d) throws SQLException{
        String query = " insert into dokter(nama_dokter,keahlian,tlp_dokter) values ('"+d.getNama()+"',"
                + "'"+d.getSpecialis()+"','"+d.getTlp()+"')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        int generatedId = -1;
        if (rs.next()) {
            generatedId = rs.getInt(1);
        }
        d.setId(generatedId);
    }
    
    public void  saveRuangan(Ruangan r) throws SQLException{
        String query = " insert into ruangan(jml_pasien,kapasitas,status) values ('"+r.getJumlahPasien()+"',"
                + "'"+r.getMaxPasien()+"','"+r.getKetersediaan()+"')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        int generatedId = -1;
        if (rs.next()) {
            generatedId = rs.getInt(1);
        }
        r.setNo(generatedId);
    }
    
    public void  savePasien(Pasien p) throws SQLException{
        String query = " insert into pasien(nama_pasien,usia,jenis_kelamin,tlp_pasien,alamat) values ('"+p.getNama()+"',"
                + "'"+p.getUsia()+"','"+p.getJenisKelamin()+"','"+p.getTlp()+"','"+p.getAlamat()+"')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        int generatedId = -1;
        if (rs.next()) {
            generatedId = rs.getInt(1);
        }
        p.setId(generatedId);
    }
    
    public void savePasienInap(Pasien p,Dokter d, Ruangan r) throws SQLException{
       String query = " insert into pasien_inap(id_pasien,id_dokter,no) values ('"+p.getId()+"',"
                + "'"+d.getId()+"','"+r.getNo()+"')";
       statement.executeUpdate(query);
    }
    //======= LOAD
    public ArrayList<PasienInap> loadPasienInap() throws SQLException{
       String query = "select * from pasien_inap";
       ArrayList<PasienInap> tmp= new ArrayList();
       ResultSet rs = statement.executeQuery(query);
        while (rs.next()){            
            PasienInap pi = new PasienInap(rs.getInt(1), rs.getInt(2), rs.getString(3));
            tmp.add(pi);
        }
        return tmp;
    }
    
    public ArrayList<Ruangan> loadRuanganPasienInap() throws SQLException{
        int i=0;int no;int j = 0;
        ArrayList<Ruangan> tmp = new ArrayList();
        String query = "select * from ruangan,pasien_inap,pasien,dokter "
                + "where ruangan.no = pasien_inap.no "
                + "AND pasien_inap.id_pasien = pasien.id_pasien "
                + "AND pasien_inap.id_dokter = dokter.id_dokter  ";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Pasien p = new Pasien(rs.getString("nama_pasien"), rs.getInt("id_pasien"), rs.getString("tlp_pasien"),
                    rs.getString("alamat"),rs.getInt("usia"), rs.getString("jenis_kelamin"));
            Dokter d = new Dokter(rs.getString("nama_dokter"), rs.getInt("id_dokter"), rs.getString("tlp_dokter"),rs.getString("keahlian"));
            
            if(rs.getInt("no")!=i){
                ru = new Ruangan();
                while(rs.getInt("no")!=i){
                    i++;
                }
                ru.setNo(i);
                ru.setMaxPasien(rs.getInt("kapasitas"));
                ru.setDaftarPasien(ru.getMaxPasien());
                ru.tambahPasienInap(p, d);  
                
            }else
                ru.tambahPasienInap(p, d);
            if(rs.getInt("jml_pasien")==ru.getJumlahPasien())
                tmp.add(ru);
           
        }
        return tmp;        
    }
    
    public ArrayList<Ruangan> loadRuangan() throws SQLException{
        ArrayList<Ruangan> tmp = new ArrayList();
        String query = "select * from ruangan";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Ruangan r = new Ruangan(rs.getInt("no"), rs.getInt("jml_pasien"),
                    rs.getInt("kapasitas"), rs.getString("status"));
           tmp.add(r);
        }
        return tmp;
    }
    public ArrayList<Pasien> loadPasien() throws SQLException{
        ArrayList<Pasien> tmp = new ArrayList();
        String query = "select * from pasien";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Pasien p = new Pasien(rs.getString("nama_pasien"),rs.getInt("id_pasien"),
                    rs.getString("tlp_pasien"),rs.getString("alamat"), rs.getInt("usia"),
                    rs.getString("jenis_kelamin"));
           tmp.add(p);
        }
        return tmp;
    }
    
    public ArrayList<Dokter> loadDokter() throws SQLException{
        ArrayList<Dokter> tmp = new ArrayList();
        String query = "select * from ruangan";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Dokter d = new Dokter(rs.getString("nama_dokter"),rs.getInt("id_dokter"), 
                    rs.getString("Keahlian"), rs.getString("tlp_dokter"));
           tmp.add(d);
        }
        return tmp;
    }
    //===== combo
    public ArrayList<String> comboDokter() throws SQLException{
        ArrayList<String> tmp = new ArrayList();
        String query = "select * from dokter";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            tmp.add(rs.getString("nama_dokter"));
        }
        return tmp;
    }
    
     public  ArrayList<String> comboRuangan() throws SQLException{
         ArrayList<String> tmp = new  ArrayList();
        String query = "select * from ruangan where status = 'Tersedia'";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            tmp.add(String.valueOf(rs.getInt("no")));
        }
        return tmp;
    }
     //====== UPDATE
     public void updateRuangan(Ruangan r) throws SQLException{
         String query = "update ruangan set jml_pasien = '"+r.getJumlahPasien()+"',status = '"+r.getKetersediaan()+"' "
                 + "where no = '"+r.getNo()+"'";
         statement.executeUpdate(query);
     }
     
      public void updatePasienINap(Pasien p,Ruangan r,Dokter d) throws SQLException{
         String query = "update pasien_inap set id_dokter = '"+d.getId()+"',no = '"+r.getNo()+"'"
                 + "where id_pasien = '"+p.getId()+"'";
         statement.executeUpdate(query);
     }
    //====== CARI
      public Dokter cariDokter(String nama) throws SQLException{
          String query= "select * from dokter where nama_dokter = '"+nama+"'";
          ResultSet rs = statement.executeQuery(query);
          
          while(rs.next()){
              Dokter d = new Dokter(rs.getString(2),rs.getInt(1),rs.getString(3),rs.getString(4));
              return d;
          }
          return null;
      }
      
       public Ruangan cariRuangan(int no) throws SQLException{
          String query= "select * from ruangan where no = '"+no+"'";
          ResultSet rs = statement.executeQuery(query);          
          while(rs.next()){
              Ruangan r = new Ruangan(rs.getInt(1),rs.getInt(3),rs.getInt(2),rs.getString(4));
              return r;
          }
          return null;
      }
       
       public Pasien cariPasien(int id) throws SQLException{
          String query= "select * from pasien where id_pasien = '"+id+"'";
          ResultSet rs = statement.executeQuery(query);          
          while(rs.next()){
              Pasien p = new Pasien(rs.getString(2),rs.getInt(1),rs.getString(5),rs.getString(6),rs.getInt(3),rs.getString(4));
              return p;
          }
          return null;
      }
}
