/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import java.sql.*;
import dal.ConnectionModule;
import javax.swing.JOptionPane;
 
/**
 *
 * @author Jefferson
 */
public class UserPage extends javax.swing.JInternalFrame {
Connection con = null;
PreparedStatement pst = null;
ResultSet rs = null;

    /**
     * Creates new form UserPage
     */
    public UserPage() {
        initComponents();
        con = ConnectionModule.conector();
    }
    private void read(){
        String sql = "Select * from tbusers where iduser=?";
        try {
            pst= con.prepareStatement(sql);
            pst.setString(1, txtUserId.getText());
            rs= pst.executeQuery();
            if (rs.next()) {
                txtUserName.setText(rs.getString(2));
                txtUserLogin.setText(rs.getString(3));
                txtUserPassword.setText(rs.getString(4));
                cboUserType.setSelectedItem(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null,"User not registered");
                //code bellow clean the text fields
                txtUserName.setText(null);
                txtUserLogin.setText(null);
                txtUserPassword.setText(null);
                cboUserType.setSelectedItem(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtUserLogin = new javax.swing.JTextField();
        cboUserType = new javax.swing.JComboBox<>();
        txtUserId = new javax.swing.JTextField();
        txtUserPassword = new javax.swing.JTextField();
        btnUserCreate = new javax.swing.JButton();
        btnUserRead = new javax.swing.JButton();
        btnUserUp = new javax.swing.JButton();
        btnUserDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Users");
        setToolTipText("Add");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(700, 550));

        jLabel1.setText("ID");

        jLabel2.setText("Name");

        jLabel3.setText("Login");

        jLabel4.setText("Password");

        jLabel5.setText("Type");

        cboUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin\t", "user" }));

        btnUserCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/create file.png"))); // NOI18N
        btnUserCreate.setToolTipText("Create new");
        btnUserCreate.setPreferredSize(new java.awt.Dimension(80, 80));

        btnUserRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/read file.png"))); // NOI18N
        btnUserRead.setToolTipText("Read");
        btnUserRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserRead.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserReadActionPerformed(evt);
            }
        });

        btnUserUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update file.png"))); // NOI18N
        btnUserUp.setToolTipText("Update");
        btnUserUp.setPreferredSize(new java.awt.Dimension(80, 80));

        btnUserDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete file.png"))); // NOI18N
        btnUserDelete.setToolTipText("Delete file");
        btnUserDelete.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(cboUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(btnUserRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56)
                                        .addComponent(btnUserUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(btnUserDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel4)
                                        .addGap(37, 37, 37)
                                        .addComponent(txtUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)
                                .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(21, 21, 21)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(140, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        setBounds(0, 0, 700, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserReadActionPerformed
        // call read method
        read();
    }//GEN-LAST:event_btnUserReadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUserCreate;
    private javax.swing.JButton btnUserDelete;
    private javax.swing.JButton btnUserRead;
    private javax.swing.JButton btnUserUp;
    private javax.swing.JComboBox<String> cboUserType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JTextField txtUserLogin;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserPassword;
    // End of variables declaration//GEN-END:variables
}
