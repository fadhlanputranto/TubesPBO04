/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Asus A450CA
 */
public class DaftarRuangan extends javax.swing.JInternalFrame {

    /**
     * Creates new form DaftarRuangan
     */
    public DaftarRuangan() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelRuangan = new javax.swing.JTable();
        btnHapusRuangan = new javax.swing.JButton();
        btnTambahRuangan = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ruangan");

        tabelRuangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Jumlah Pasien", "Kapasitas", "Status"
            }
        ));
        jScrollPane1.setViewportView(tabelRuangan);

        btnHapusRuangan.setText("Hapus Ruangan");

        btnTambahRuangan.setText("Tambah Ruangan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHapusRuangan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTambahRuangan)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapusRuangan, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnTambahRuangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusRuangan;
    private javax.swing.JButton btnTambahRuangan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelRuangan;
    // End of variables declaration//GEN-END:variables
    
    
    
    public void addListener(ActionListener e){
        btnHapusRuangan.addActionListener(e);
        btnTambahRuangan.addActionListener(e);
    }

    public JButton getBtnHapusRuangan() {
        return btnHapusRuangan;
    }

    public JButton getBtnTambahRuangan() {
        return btnTambahRuangan;
    }

    public JTable getTabelRuangan() {
        return tabelRuangan;
    }
    
    
}
