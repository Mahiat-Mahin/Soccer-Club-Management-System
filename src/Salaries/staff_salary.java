package Salaries;

import Medical.staff_medical;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author faisa
 */
public class staff_salary extends javax.swing.JFrame {

    /**
     * Creates new form staff_salary
     */
    public staff_salary() {
        initComponents();
        Toolkit tk = getToolkit();
        Dimension size = tk.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
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
        s_id_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        s_salary_tf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        join_date = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        leave_date = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        s_bonus_tf = new javax.swing.JTextField();
        clear_btn = new javax.swing.JButton();
        insert_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(326, 450));
        setMinimumSize(new java.awt.Dimension(326, 450));
        setPreferredSize(new java.awt.Dimension(326, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Staff Id:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 66, -1, -1));

        s_id_tf.setPreferredSize(new java.awt.Dimension(100, 25));
        s_id_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_id_tfActionPerformed(evt);
            }
        });
        getContentPane().add(s_id_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 61, -1, -1));

        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Staff Salary:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 116, -1, -1));

        s_salary_tf.setMinimumSize(new java.awt.Dimension(100, 25));
        s_salary_tf.setPreferredSize(new java.awt.Dimension(100, 25));
        s_salary_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_salary_tfActionPerformed(evt);
            }
        });
        getContentPane().add(s_salary_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 111, -1, -1));

        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Joinning Date:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 161, -1, -1));

        join_date.setPreferredSize(new java.awt.Dimension(100, 25));
        getContentPane().add(join_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 161, 150, -1));

        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Leaving Date:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 211, -1, -1));
        getContentPane().add(leave_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 211, 150, 25));

        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Staff Bonus:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 268, -1, -1));

        s_bonus_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_bonus_tfActionPerformed(evt);
            }
        });
        getContentPane().add(s_bonus_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 263, 130, 25));

        clear_btn.setText("Clear");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });
        getContentPane().add(clear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 306, -1, -1));

        insert_btn.setText("Insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });
        getContentPane().add(insert_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 306, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Staff salary");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Salaries/eleven.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void s_salary_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_salary_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_salary_tfActionPerformed

    private void s_bonus_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_bonus_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_bonus_tfActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        s_salary_tf.setText("");
        s_salary_tf.setText("");
        s_bonus_tf.setText("");

    }//GEN-LAST:event_clear_btnActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query = "insert into [Staff Salary](S_ID,S_salary, joining_date, leaving_date, S_bonus)values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, s_id_tf.getText());
            pst.setString(2, s_salary_tf.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String j_date = sdf.format(join_date.getDate());
            pst.setString(3, j_date);
            String l_date = sdf.format(leave_date.getDate());
            pst.setString(4, l_date);
            pst.setString(5, s_bonus_tf.getText());

            pst.executeUpdate();
            /* DefaultTableModel model = (DefaultTableModel) player_jTable.getModel();
            model.setRowCount(0);
            show_player();*/

            staff_medical sf = new staff_medical();
            sf.setVisible(true);
            setVisible(false);

            //JOptionPane.showMessageDialog(null, "Inserted Sucessfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_insert_btnActionPerformed

    private void s_id_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_id_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_id_tfActionPerformed

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
            java.util.logging.Logger.getLogger(staff_salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staff_salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staff_salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staff_salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staff_salary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.toedter.calendar.JDateChooser join_date;
    private com.toedter.calendar.JDateChooser leave_date;
    private javax.swing.JTextField s_bonus_tf;
    private javax.swing.JTextField s_id_tf;
    private javax.swing.JTextField s_salary_tf;
    // End of variables declaration//GEN-END:variables
}
