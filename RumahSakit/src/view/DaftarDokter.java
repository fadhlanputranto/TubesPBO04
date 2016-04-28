/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Dokter;
import model.Ruangan;

/**
 *
 * @author Asus A450CA
 */
public class DaftarDokter extends javax.swing.JFrame {

    /**
     * Creates new form DaftarDokter
     */
    public DaftarDokter() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnPasien = new javax.swing.JMenuItem();
        mnDokter = new javax.swing.JMenuItem();
        mnRuangan = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDokter = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        btnHapusDokter = new javax.swing.JButton();
        btnTambahDokter = new javax.swing.JButton();

        mnPasien.setText("jMenuItem1");
        jPopupMenu1.add(mnPasien);

        mnDokter.setText("jMenuItem2");
        jPopupMenu1.add(mnDokter);

        mnRuangan.setText("jMenuItem3");
        jPopupMenu1.add(mnRuangan);

        setTitle("Dokter");

        tabelDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Dokter", "Nama Dokter", "Keahlian", "Telepon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelDokter);

        btnHapusDokter.setText("Hapus Dokter");

        btnTambahDokter.setText("Tambah Dokter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHapusDokter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTambahDokter)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapusDokter, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnTambahDokter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusDokter;
    private javax.swing.JButton btnTambahDokter;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnDokter;
    private javax.swing.JMenuItem mnPasien;
    private javax.swing.JMenuItem mnRuangan;
    private javax.swing.JTable tabelDokter;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getMnDokter() {
        return mnDokter;
    }
    
     public void setMnDokter() {
      this.mnDokter.setText("Daftar Dokter");
    }

    public JMenuItem getMnPasien() {
        return mnPasien;
    }

    public void setMnPasien() {
        this.mnPasien.setText("Daftar Pasien");
    }

    public JMenuItem getMnRuangan() {
        return mnRuangan;
    }

    public void setMnRuangan() {
        this.mnRuangan.setText("Daftar Ruangan");
    }
    
    public JButton getBtnHapusDokter() {
        return btnHapusDokter;
    }

    public JButton getBtnTambahDokter() {
        return btnTambahDokter;
    }

    public JTable getTabelDokter() {
        return tabelDokter;
    }
    public int getSelectedDokter(){
        return tabelDokter.getSelectedRow();
    }

    public JPopupMenu getjPopupMenu1() {
        return jPopupMenu1;
    }
    
    
    public void addAdapter(MouseAdapter me){
        tabelDokter.addMouseListener(me);
    }
    public void addListener(ActionListener e){
        btnHapusDokter.addActionListener(e);
        btnTambahDokter.addActionListener(e);
        mnPasien.addActionListener(e);
        mnDokter.addActionListener(e);
        mnRuangan.addActionListener(e);
    }
    
    //==========================================
    public void viewDokter(ArrayList<Dokter> listDokter){
        int t;
        if(listDokter.size() == 0 )
            t = 1;
        else 
            t = listDokter.size();
         String[] title = {
            "id Dokter", "Nama Dokter", "Keahlian", "Telepon"
        };
        String[][] data = new String[t][4];
        for (int i = 0; i < listDokter.size(); i++){
            Dokter d = listDokter.get(i);           
                data[i][0] = String.valueOf( d.getId());
                data[i][1] = d.getNama();
                data[i][2] = d.getSpecialis();
                data[i][3] = d.getTlp();
                
            
        }
        tabelDokter.setModel(new DefaultTableModel(data, title));
    }
}
