package main;

import login.Login;
import login.LoginDAO;
import login.LoginDAOImp;
import login.LoginForm;
import javax.swing.JOptionPane;

import barang.BarangForm;
import penjualan.PenjualanForm;
import user.UserForm;

/**
 *
 * @author GRK
 */
public class Main extends javax.swing.JFrame {

    private final LoginDAO dao = new LoginDAOImp();

    public Main() {
        initComponents();
        lbUser.setText("User: " + Login.NAMA);
    }

    public void logout() {
        int conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk Logout?", "Logout?",
                JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            dao.logout();
            this.dispose();
            new LoginForm().setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        btBarang = new javax.swing.JButton();
        btUser = new javax.swing.JButton();
        btPenjualan = new javax.swing.JButton();
        btLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Form");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbUser.setText("___________________________");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUser)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUser, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        btBarang.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        btBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MX-Icons-Clearance-Medium.png"))); // NOI18N
        btBarang.setText("Barang");
        btBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBarangActionPerformed(evt);
            }
        });

        btUser.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        btUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Admin-icon.png"))); // NOI18N
        btUser.setText("User");
        btUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserActionPerformed(evt);
            }
        });

        btPenjualan.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        btPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Shoppingcart-03-arrow-down-icon.png"))); // NOI18N
        btPenjualan.setText("Penjualan");
        btPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPenjualanActionPerformed(evt);
            }
        });

        btLogout.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        btLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout_icon-icons.com_51025.png"))); // NOI18N
        btLogout.setText("Logout");
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tekton Pro Cond", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("JAM TANGAN PRODUK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBarang))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLogout))
                .addGap(0, 85, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btPenjualan, btUser});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        // TODO add your handling code here:
        logout();
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBarangActionPerformed
        // TODO add your handling code here:
        new BarangForm().setVisible(true);
    }//GEN-LAST:event_btBarangActionPerformed

    private void btUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserActionPerformed
        // TODO add your handling code here:
        new UserForm().setVisible(true);
    }//GEN-LAST:event_btUserActionPerformed

    private void btPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPenjualanActionPerformed
        // TODO add your handling code here:
        new PenjualanForm().setVisible(true);
    }//GEN-LAST:event_btPenjualanActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBarang;
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btPenjualan;
    private javax.swing.JButton btUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbUser;
    // End of variables declaration//GEN-END:variables
}
