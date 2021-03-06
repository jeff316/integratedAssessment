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
             
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    //the block bellow make the text fiels on the user page available 
    //to be filled
        private void add(){
            String sql = "insert into tbusers(iduser, u_name, u_login, u_password, u_Type)values(?, ?, ?, ?, ?)";
            try {
                  pst= con.prepareStatement(sql);
                  pst.setString(1, txtUserId.getText());
                pst.setString(2, txtUserName.getText());
                pst.setString(3, txtUserLogin.getText());
                pst.setString(4, txtUserPassword.getText());
                pst.setString(5, cboUserType.getSelectedItem().toString());
                
                if ((txtUserId.getText().isEmpty())||(txtUserName.getText().isEmpty())||(txtUserLogin.getText().isEmpty())||(txtUserPassword.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null,"Fill required fields");
                } else {
                
                
                //line bellow save a new user profile on the database
                //strutcute bellow confirm the addition of new user 
               int added = pst.executeUpdate();
               if (added > 0){
                   JOptionPane.showMessageDialog(null,"New user added successfully");
                txtUserId.setText(null);
                txtUserName.setText(null);
                txtUserLogin.setText(null);
                txtUserPassword.setText(null);
           
               }
                }  
            } catch (Exception e) {
                  JOptionPane.showMessageDialog(null,e);
            }
        }
    private void update (){
        String sql="update tbusers set u_name=?, u_login=?, u_password=?, u_type=? where iduser=?";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, txtUserName.getText());
            pst.setString(2, txtUserLogin.getText());
            pst.setString(3, txtUserPassword.getText());
            pst.setString(4, cboUserType.getSelectedItem().toString());
            pst.setString(5, txtUserId.getText());
             if ((txtUserId.getText().isEmpty())||(txtUserName.getText().isEmpty())||(txtUserLogin.getText().isEmpty())||(txtUserPassword.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null,"Fill required fields");
                } else {
                
                
                //line bellow save a new user profile on the database
                //strutcute bellow update a user file
               int added = pst.executeUpdate();
               if (added > 0){
                   JOptionPane.showMessageDialog(null,"Update saved successfully");
                txtUserId.setText(null);
                txtUserName.setText(null);
                txtUserLogin.setText(null);
                txtUserPassword.setText(null);
           
               }
              }     
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e);
              
        }
    }
    //delete method
    private void delete(){
        //the structure bellow confirm a uder delete
        int confirm=JOptionPane.showConfirmDialog(null, "Are you sure you want to delere this user","Attention",JOptionPane.YES_NO_OPTION);
        if(confirm==JOptionPane.YES_OPTION){
            String sql="delete from tbusers where iduser=?";
            try{
                pst=con.prepareStatement(sql);
                pst.setString(1, txtUserId.getText());
                int deleted = pst.executeUpdate();
                if(deleted > 0){
                    JOptionPane.showMessageDialog(null, "User successfuly deleted");
                    txtUserId.setText(null);
                    txtUserName.setText(null);
                    txtUserLogin.setText(null);
                    txtUserPassword.setText(null);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
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
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Users");
        setToolTipText("Add");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(700, 550));

        jLabel1.setText("*ID");

        jLabel2.setText("*Name");

        jLabel3.setText("*Login");

        jLabel4.setText("*Password");

        jLabel5.setText("*Type");

        cboUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin\t", "user" }));

        btnUserCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/create file.png"))); // NOI18N
        btnUserCreate.setToolTipText("Create new");
        btnUserCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserCreateActionPerformed(evt);
            }
        });

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
        btnUserUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserUpActionPerformed(evt);
            }
        });

        btnUserDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete file.png"))); // NOI18N
        btnUserDelete.setToolTipText("Delete file");
        btnUserDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserDeleteActionPerformed(evt);
            }
        });

        jLabel6.setText("*Required Fields");

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
                                        .addGap(187, 187, 187)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)
                                .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(297, 297, 297)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(21, 21, 21)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(132, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
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

    private void btnUserCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserCreateActionPerformed
        // call method add
        add();
    }//GEN-LAST:event_btnUserCreateActionPerformed

    private void btnUserUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserUpActionPerformed
        // call update method
        update();
    }//GEN-LAST:event_btnUserUpActionPerformed

    private void btnUserDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDeleteActionPerformed
        // calling delete meyhod 
        delete();
    }//GEN-LAST:event_btnUserDeleteActionPerformed


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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JTextField txtUserLogin;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserPassword;
    // End of variables declaration//GEN-END:variables
}
