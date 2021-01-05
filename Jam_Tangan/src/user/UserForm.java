package user;

import javax.swing.JOptionPane;

/**
 *
 * @author GRK
 */
public class UserForm extends javax.swing.JFrame {

    private int id;
    private UserDAO dao;
    private int tag;

    public UserForm() {
        initComponents();
        //membuat dao service
        dao = new UserDAOImp();
        reset();
    }

    //reset atribut/ tag, form, dan tabel
    public void reset() {
        tag = 0;
        tfUsername.setText("");
        tfPassword.setText("");
        tfNama.setText("");
        tfNoTelp.setText("");
        taAlamat.setText("");

        read();
    }

    //form validasi input
    public boolean validasi() {
        boolean hasil = false;
        if (tfUsername.getText().isEmpty() || tfPassword.getText().isEmpty() || tfNama.getText().isEmpty()
                || tfNoTelp.getText().isEmpty() || taAlamat.getText().isEmpty()) {
            //tidak valid
            hasil = false;
        } else {
            //valid
            hasil = true;
        }
        return hasil;
    }

    public void read() {
        dao.read(tbUser);
    }

    public void create() {
        User user = new User();
        user.setUsername(tfUsername.getText());
        user.setPassword(tfPassword.getText());
        user.setNama(tfNama.getText());
        user.setNoTelp(tfNoTelp.getText());
        user.setAlamat(taAlamat.getText());

        dao.create(user);
    }

    public void update() {
        User user = new User();
        user.setNama(tfUsername.getText());
        user.setUsername(tfUsername.getText());
        user.setPassword(tfPassword.getText());
        user.setNama(tfNama.getText());
        user.setNoTelp(tfNoTelp.getText());
        user.setAlamat(taAlamat.getText());

        user.setId(id);
        dao.update(user);
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
        int selected = tbUser.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk mengubah?",
                    "Confirm!", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                //update data
                tag = 1;
                int baris = tbUser.getSelectedRow();
                id = Integer.valueOf(tbUser.getValueAt(baris, 0).toString());
                tfUsername.setText(tbUser.getValueAt(baris, 1).toString());
                tfPassword.setText(tbUser.getValueAt(baris, 2).toString());
                tfNama.setText(tbUser.getValueAt(baris, 3).toString());
                tfNoTelp.setText(tbUser.getValueAt(baris, 4).toString());
                taAlamat.setText(tbUser.getValueAt(baris, 5).toString());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
        }
    }

    public void delete() {
        int selected = tbUser.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk menghapus?",
                    "Confirm!", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                int baris = tbUser.getSelectedRow();
                id = Integer.valueOf(tbUser.getValueAt(baris, 0).toString());
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
        jLabel4 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        tfUsername = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        tfNoTelp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        btBatal = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form User");

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Alamat");

        jLabel4.setText("No Telp");

        btnSimpan.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diskette.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_edit.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_delete.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane1.setViewportView(taAlamat);

        tbUser.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbUser);

        btBatal.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        btBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_warning.png"))); // NOI18N
        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama");

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));

        jLabel7.setFont(new java.awt.Font("Tekton Pro Cond", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("User Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                                    .addComponent(tfNoTelp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfUsername, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbah)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)
                                .addGap(18, 18, 18)
                                .addComponent(btBatal)))
                        .addContainerGap(70, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btBatal, btnHapus, btnSimpan, btnUbah});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btBatal)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah))
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForm().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTable tbUser;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNoTelp;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
