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
import model.Dokter;
import model.Ruangan;

/**
 *
 * @author Asus A450CA
 */
public class Database {
    private String dbname = "jdbc:mysql://localhost:3306/tubespbo";
    private String dbuser = "root";
    private String dbpass = "";
    private Statement statement;
    private Connection connection;
    
    
    public void connect() throws SQLException{
        connection = DriverManager.getConnection(dbname, dbuser, dbpass);
        statement = connection.createStatement();
    }
    
    public void  saveDokter(Dokter d) throws SQLException{
        String query = " insert into dokter(nama_dokter,keahlian,telepon) values ('"+d.getNama()+"',"
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
    
    public void  saveDokter(Dokter d) throws SQLException{
        String query = " insert into pasien(nama_dokter,keahlian,telepon) values ('"+d.getNama()+"',"
                + "'"+d.getSpecialis()+"','"+d.getTlp()+"')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        int generatedId = -1;
        if (rs.next()) {
            generatedId = rs.getInt(1);
        }
        d.setId(generatedId);
    }
}
