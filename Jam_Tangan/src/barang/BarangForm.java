package barang;

import javax.swing.JOptionPane;

/**
 *
 * @author GRK
 */
public class BarangForm extends javax.swing.JFrame {

    private int id;
    private BarangDAO dao;
    private int tag;

    public BarangForm() {
        initComponents();

        dao = new BarangDAOImp();
        reset();
    }

    public void reset() {
        tag = 0;
        tfNama.setText("");
        taDeskripsi.setText("");
        tfHarga.setText("");
        tfStok.setText("");
        read();
    }

    //form validasi input
    public boolean validasi() {
        boolean hasil = false;
        if (tfNama.getText().isEmpty() || taDeskripsi.getText().isEmpty()
                || tfHarga.getText().isEmpty() || tfStok.getText().isEmpty()) {
            //tidak valid
            hasil = false;
        } else {
            //valid
            hasil = true;
        }
        return hasil;
    }

    public void read() {
        dao.read(tbBarang);
    }

    public void create() {
        Barang barang = new Barang();
        barang.setNama(tfNama.getText());
        barang.setDeskripsi(taDeskripsi.getText());
        barang.setHarga(Double.parseDouble(tfHarga.getText()));
        barang.setStok(Integer.parseInt(tfStok.getText()));
        dao.create(barang);
    }

    public void update() {
        Barang barang = new Barang();
        barang.setNama(tfNama.getText());
        barang.setDeskripsi(taDeskripsi.getText());
        barang.setHarga(Double.parseDouble(tfHarga.getText()));
        barang.setStok(Integer.parseInt(tfStok.getText()));
        barang.setId(id);
        dao.update(barang);
    }

    public void save() {
        //cek validasi
        if (validasi() == true) {
            if (tag == 0) {
                //create
                create();
            } else if (tag == 1) {
                //update
                update();
            }
            reset();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Input belum lengkap!");
        }
    }

    public void getRecord() {
        int selected = tbBarang.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk mengubah?",
                    "Confirm!", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                //update data
                tag = 1;
                int baris = tbBarang.getSelectedRow();
                id = Integer.valueOf(tbBarang.getValueAt(baris, 0).toString());
                tfNama.setText(tbBarang.getValueAt(baris, 1).toString());
                taDeskripsi.setText(tbBarang.getValueAt(baris, 2).toString());
                tfHarga.setText(tbBarang.getValueAt(baris, 3).toString());
                tfStok.setText(tbBarang.getValueAt(baris, 4).toString());
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
        }
    }

    public void delete() {
        int selected = tbBarang.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk menghapus?",
                    "Confirm!", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                int baris = tbBarang.getSelectedRow();
                id = Integer.valueOf(tbBarang.getValueAt(baris, 0).toString());
                dao.delete(id);
                reset();
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        tfNama = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        tfStok = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDeskripsi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBarang = new javax.swing.JTable();
        btBatal = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Barang");

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        jLabel1.setText("Nama");

        jLabel2.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        jLabel2.setText("Deskripsi");

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        jLabel3.setText("Harga");

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        jLabel5.setText("Stok");

        btnSimpan.setBackground(new java.awt.Color(0, 204, 255));
        btnSimpan.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diskette.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(0, 204, 255));
        btnUbah.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_edit.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(0, 204, 255));
        btnHapus.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_delete.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        taDeskripsi.setColumns(20);
        taDeskripsi.setRows(5);
        jScrollPane1.setViewportView(taDeskripsi);

        tbBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbBarang);

        btBatal.setBackground(new java.awt.Color(0, 204, 255));
        btBatal.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        btBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_warning.png"))); // NOI18N
        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setBackground(new java.awt.Color(153, 0, 153));
        jLabel6.setFont(new java.awt.Font("Tekton Pro Cond", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Barang Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btBatal))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfHarga)
                                .addComponent(tfNama)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jLabel5)
                            .addGap(13, 13, 13)
                            .addComponent(tfStok, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btBatal, btnHapus, btnSimpan, btnUbah});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btBatal))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btBatal, btnHapus, btnSimpan, btnUbah});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        save(); //tag=0, jadi menjalankan create
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        getRecord();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btBatalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taDeskripsi;
    private javax.swing.JTable tbBarang;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfStok;
    // End of variables declaration//GEN-END:variables
}
