/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Pasien;
import model.PasienInap;
import model.Ruangan;

/**
 *
 * @author Asus A450CA
 */
public class DaftarPasien extends javax.swing.JFrame {

    /**
     * Creates new form DaftarPasien
     */
    public DaftarPasien() {
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
        TabelPasien = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        btnPasienBaru = new javax.swing.JButton();
        btnHapusPasien = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnEdit = new javax.swing.JButton();

        mnPasien.setText("jMenuItem1");
        mnPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPasienActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnPasien);

        mnDokter.setText("jMenuItem2");
        jPopupMenu1.add(mnDokter);

        mnRuangan.setText("jMenuItem3");
        jPopupMenu1.add(mnRuangan);

        setTitle("Pasien INAP");

        TabelPasien.setAutoCreateRowSorter(true);
        TabelPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Pasien", "Nama Pasien", "Diagnosa", "Nama Dokter", "Ruangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TabelPasien.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(TabelPasien);

        btnPasienBaru.setText("Pasien Baru");

        btnHapusPasien.setText("Hapus Pasien");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );

        btnEdit.setText("Edit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnHapusPasien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPasienBaru)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPasienBaru, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnHapusPasien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPasienActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_mnPasienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelPasien;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapusPasien;
    private javax.swing.JButton btnPasienBaru;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem mnDokter;
    private javax.swing.JMenuItem mnPasien;
    private javax.swing.JMenuItem mnRuangan;
    // End of variables declaration//GEN-END:variables

    public JTable getTabelPasien() {
        return TabelPasien;
    }

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

    
    public JPopupMenu getjPopupMenu1() {
        return jPopupMenu1;
    }
    
    
 
    public JButton getBtnHapusPasien() {
        return btnHapusPasien;
    }

    public JButton getBtnPasienBaru() {
        return btnPasienBaru;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }
    
        
    public void addListener(ActionListener e){
        btnHapusPasien.addActionListener(e);
        btnPasienBaru.addActionListener(e);
        btnEdit.addActionListener(e);
        mnPasien.addActionListener(e);
        mnDokter.addActionListener(e);
        mnRuangan.addActionListener(e);
    }
    
    public  void addAdapter(MouseAdapter me){
        TabelPasien.addMouseListener(me);  
       
    }
   
    
    public int getSelectedPasien(){
        return TabelPasien.getSelectedRow();
    }
    
    public void viewPasienIinap(ArrayList<Ruangan> listPasienInap){
        int j = 0;
         String[] title = {
            "id Pasien", "Nama Pasien", "Diagnosa", "Nama Dokter","Ruangan"
        };
        String[][] data = new String[50][5];
        for (int i = 0; i < listPasienInap.size(); i++){
            Ruangan r = listPasienInap.get(i);
            for(int k = 0; k< r.getJumlahPasien();k++){
                data[j][0] = String.valueOf( r.getDaftarPasienByIndex(k).getPasien().getId());
                data[j][1] = r.getDaftarPasienByIndex(k).getPasien().getNama();
                data[j][2] = r.getDaftarPasienByIndex(k).getDiagnosa();
                data[j][3] = r.getDaftarPasienByIndex(k).getDokter().getNama();
                data[j][4] = String.valueOf(r.getNo());
                j++;
            }
            
        }
        TabelPasien.setModel(new DefaultTableModel(data, title));
    }
    
    public PasienInap getViewPasienInap(ArrayList<Ruangan> listPasienInap,int selected){
        int j = 0;
        PasienInap pi;
        String[][] data = new String[50][3];
        for (int i = 0; i < listPasienInap.size(); i++){
            Ruangan r = listPasienInap.get(i);
            for(int k = 0; k< r.getJumlahPasien();k++){
                data[j][0] = String.valueOf( r.getDaftarPasienByIndex(k).getPasien().getId());
                data[j][1] = String.valueOf( r.getDaftarPasienByIndex(k).getDokter().getId());
                data[j][2] = r.getDaftarPasienByIndex(k).getDiagnosa();
                j++;
            }
            
        }
        
        return pi = new PasienInap(Integer.parseInt(data[selected][0]),Integer.parseInt(data[selected][1]), data[selected][2]);
    }
    
}
