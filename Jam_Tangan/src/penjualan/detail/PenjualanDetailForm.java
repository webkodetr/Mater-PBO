package penjualan.detail;

import login.Login;
import barang.Barang;
import java.util.List;
import javax.swing.JOptionPane;
import penjualan.Penjualan;
import user.User;

/**
 *
 * @author GRK
 */
public class PenjualanDetailForm extends javax.swing.JFrame {

    private PenjualanDetailDAO dao;
    private List<Barang> barangList;

    private int barangId;

    private Barang barang;
    private PenjualanDetail pd;
    private double total;
    private int TAG = 0;
    private int INDEX;

    /**
     * Creates new form PenjualanItemView
     */
    public PenjualanDetailForm() {
        initComponents();
        barang = new Barang();
        pd = new PenjualanDetail();
        dao = new PenjualanDetailDAOImp();
        lbUser.setText(Login.NAMA);
        loadBarang();
        reset();
    }

    public void reset() {
        cbBarang.setSelectedIndex(0);
        barangId = 0;
        tfHarga.setText("");
        tfQty.setText("");
        TAG = 0;
        refreshItem();

    }

    public void refreshItem() {
        tbPenjualanDetail.setModel(dao.refreshItem());
    }

    public void loadBarang() {
        barangList = dao.loadBarang();
        //store combobox
        cbBarang.removeAllItems();
        cbBarang.addItem("Pilih...");
        for (Barang b : barangList) {
            cbBarang.addItem(b.getNama());
        }
    }

    public void selectBarang() {
        int index = cbBarang.getSelectedIndex();
        if (index == 0) {
            barangId = 0;
            tfHarga.setText("");
        } else {
            barangId = barangList.get(index - 1).getId();
            tfHarga.setText(String.valueOf(barangList.get(index - 1).getHarga()));
        }
    }

    public void save() {
        if (TAG == 0) {
            addItem();
        } else {
            editItem();
        }
        reset();
    }

    public void addItem() {
        PenjualanDetail pd = new PenjualanDetail();
        Barang barang = new Barang();

        barang.setId(barangId);
        barang.setNama(cbBarang.getSelectedItem().toString());
        barang.setHarga(Double.valueOf(tfHarga.getText()));
        pd.setBarang(barang);

        pd.setQty(Integer.valueOf(tfQty.getText()));
        pd.setSubTotal(Double.valueOf(tfHarga.getText()) * Integer.valueOf(tfQty.getText()));

        dao.addItem(pd);

        total = dao.getTotalBayar();
        lbTotal.setText("Rp. " + String.valueOf(total));
    }

    public void editItem() {
        PenjualanDetail pd = new PenjualanDetail();
        Barang barang = new Barang();
        barang.setId(barangId);
        barang.setNama(cbBarang.getSelectedItem().toString());
        barang.setHarga(Double.valueOf(tfHarga.getText()));
        pd.setBarang(barang);

        pd.setQty(Integer.valueOf(tfQty.getText()));
        pd.setSubTotal(Double.valueOf(tfHarga.getText()) * Integer.valueOf(tfQty.getText()));

        dao.editItem(pd, INDEX);

        total = dao.getTotalBayar();
        lbTotal.setText("Rp. " + String.valueOf(total));
    }

    public void getItem() {
        int selected = tbPenjualanDetail.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk ubah?",
                    "Confirm!", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                int baris = tbPenjualanDetail.getSelectedRow();
                barangId = Integer.valueOf(tbPenjualanDetail.getValueAt(baris, 0).toString());
                cbBarang.setSelectedItem(tbPenjualanDetail.getValueAt(baris, 1).toString());
                tfHarga.setText(tbPenjualanDetail.getValueAt(baris, 2).toString());
                tfQty.setText(tbPenjualanDetail.getValueAt(baris, 3).toString());
                TAG = 1;
                INDEX = baris;
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
        }
    }

    public void removeItem() {
        int selected = tbPenjualanDetail.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk hapus?",
                    "Confirm !", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                int baris = tbPenjualanDetail.getSelectedRow();
                dao.deleteItem(baris);
                refreshItem();

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih !");
        }
    }

    public void create() {
        Penjualan p = new Penjualan();
        p.setTotal(total);

        User u = new User();
        u.setId(Login.USER_ID);
        p.setUser(u);

        dao.create(p);
        reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfHarga = new javax.swing.JTextField();
        tfQty = new javax.swing.JTextField();
        btSimpanItem = new javax.swing.JButton();
        btUbah = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPenjualanDetail = new javax.swing.JTable();
        btSimpan = new javax.swing.JButton();
        lbTotal = new javax.swing.JLabel();
        cbBarang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Penjualan Detail");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("User :");

        lbUser.setText("_____________________________________________");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Barang :");

        jLabel4.setText("Harga :");

        jLabel5.setText("Qty :");

        tfHarga.setEditable(false);
        tfHarga.setBackground(new java.awt.Color(255, 102, 102));
        tfHarga.setEnabled(false);
        tfHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHargaActionPerformed(evt);
            }
        });

        tfQty.setBackground(new java.awt.Color(51, 255, 51));
        tfQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQtyActionPerformed(evt);
            }
        });
        tfQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQtyKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfQtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQtyKeyReleased(evt);
            }
        });

        btSimpanItem.setBackground(new java.awt.Color(255, 255, 0));
        btSimpanItem.setFont(new java.awt.Font("Tekton Pro", 0, 12)); // NOI18N
        btSimpanItem.setText("Simpan");
        btSimpanItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanItemActionPerformed(evt);
            }
        });

        btUbah.setBackground(new java.awt.Color(255, 255, 0));
        btUbah.setFont(new java.awt.Font("Tekton Pro", 0, 12)); // NOI18N
        btUbah.setText("Ubah");
        btUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUbahActionPerformed(evt);
            }
        });

        btHapus.setBackground(new java.awt.Color(255, 255, 0));
        btHapus.setFont(new java.awt.Font("Tekton Pro", 0, 12)); // NOI18N
        btHapus.setText("Hapus");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        tbPenjualanDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbPenjualanDetail);

        btSimpan.setBackground(new java.awt.Color(204, 0, 204));
        btSimpan.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        btSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTotal.setText("Rp. 0");

        cbBarang.setBackground(new java.awt.Color(0, 204, 204));
        cbBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbBarangMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbBarangMouseClicked(evt);
            }
        });
        cbBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBarangActionPerformed(evt);
            }
        });
        cbBarang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbBarangPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btSimpanItem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSimpanItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btHapus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(lbTotal))
                .addGap(10, 10, 10))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btHapus, btSimpanItem});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSimpanItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanItemActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btSimpanItemActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        create();
    }//GEN-LAST:event_btSimpanActionPerformed

    private void tfQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtyKeyTyped
        // TODO add your handling code here:
        //hitungSubTotal();

    }//GEN-LAST:event_tfQtyKeyTyped

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        removeItem();
    }//GEN-LAST:event_btHapusActionPerformed

    private void btUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUbahActionPerformed
        // TODO add your handling code here:
        getItem();
    }//GEN-LAST:event_btUbahActionPerformed

    private void cbBarangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBarangMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBarangMousePressed

    private void cbBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBarangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBarangMouseClicked

    private void cbBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBarangActionPerformed
        // TODO add your handling code here:
        selectBarang();
    }//GEN-LAST:event_cbBarangActionPerformed

    private void cbBarangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbBarangPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBarangPropertyChange

    private void tfQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtyKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:

    }//GEN-LAST:event_tfQtyKeyPressed

    private void tfQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtyKeyReleased

    }//GEN-LAST:event_tfQtyKeyReleased

    private void tfHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHargaActionPerformed

    private void tfQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQtyActionPerformed

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
            java.util.logging.Logger.getLogger(PenjualanDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjualanDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjualanDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjualanDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PenjualanDetailForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btSimpanItem;
    private javax.swing.JButton btUbah;
    private javax.swing.JComboBox<String> cbBarang;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbUser;
    private javax.swing.JTable tbPenjualanDetail;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfQty;
    // End of variables declaration//GEN-END:variables
}
