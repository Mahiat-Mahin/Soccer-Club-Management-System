/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical;

import Staffs.p_player;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahin Opu
 */
public class player_medical extends javax.swing.JFrame {

    /**
     * Creates new form player_medical
     */
    public player_medical() {
        initComponents();
        
        Toolkit tk = getToolkit();
        Dimension size = tk.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        p_id_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        p_name_tf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        leave_tf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        m_description_tf = new javax.swing.JTextField();
        insert_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(320, 380));
        setMinimumSize(new java.awt.Dimension(320, 380));
        setPreferredSize(new java.awt.Dimension(320, 420));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Player Id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        getContentPane().add(p_id_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 75, 100, 25));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Player Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 124, -1, 30));
        getContentPane().add(p_name_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 130, 180, 25));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Leave");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));
        getContentPane().add(leave_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 185, 100, 25));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Description");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
        getContentPane().add(m_description_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 240, 180, 25));

        insert_btn.setText("Insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });
        getContentPane().add(insert_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        clear_btn.setText("Clear");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });
        getContentPane().add(clear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Player Medical Status");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 11, -1, -1));

        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\3.1\\image\\eleven.jpg")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(320, 380));
        jLabel1.setMinimumSize(new java.awt.Dimension(320, 380));
        jLabel1.setPreferredSize(new java.awt.Dimension(320, 380));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        // TODO add your handling code here:
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query = "insert into [Player Medical Status](P_ID,P_Name,Leave,M_Description)values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, p_id_tf.getText());
            pst.setString(2, p_name_tf.getText());
            pst.setString(3, leave_tf.getText());
            pst.setString(4, m_description_tf.getText());
           
            pst.executeUpdate();


            JOptionPane.showMessageDialog(null, "Inserted Sucessfully!");
            
            
            setVisible(false);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_insert_btnActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        p_id_tf.setText("");
        p_name_tf.setText("");
        leave_tf.setText("");
        m_description_tf.setText("");
    }//GEN-LAST:event_clear_btnActionPerformed

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
            java.util.logging.Logger.getLogger(player_medical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(player_medical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(player_medical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(player_medical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new player_medical().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField leave_tf;
    private javax.swing.JTextField m_description_tf;
    private javax.swing.JTextField p_id_tf;
    private javax.swing.JTextField p_name_tf;
    // End of variables declaration//GEN-END:variables
}
