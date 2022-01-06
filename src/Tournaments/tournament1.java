package Tournaments;

import Home.window;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author faisa
 */
public class tournament1 extends javax.swing.JFrame {

    /**
     * Creates new form tournament
     */
    String m_area;

    public tournament1() {
        initComponents();
        show_tournament();
        
        Toolkit tk = getToolkit();
        Dimension size = tk.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
    }

    public ArrayList<tournament_User> userList() {
        ArrayList<tournament_User> userslist = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1 = "SELECT * FROM Tournament";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                tournament_User user = new tournament_User(rs.getString("Match_Date"), rs.getString("Match_Type"), rs.getString("Match_Area"), rs.getString("Stadium"), rs.getString("Result"));
                userslist.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userslist;
    }
//For showing in the columns of jtable

    public void show_tournament() {
        ArrayList<tournament_User> list = userList();
        DefaultTableModel model = (DefaultTableModel) show_jTable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getmDate();
            row[1] = list.get(i).getmType();
            row[2] = list.get(i).getmArea();
            row[3] = list.get(i).getSta();
            row[4] = list.get(i).getRes();
            model.addRow(row);
        }
    }
    
    public void leauge_info(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            
            
            int row = show_jTable.getSelectedRow();
            String value = (show_jTable.getModel().getValueAt(row, 0).toString());
            String m_type = match_type_combo.getSelectedItem().toString();
            
            if(m_type == "La Liga")
            {
                String sql= "select Match_Opponent,(select Cast(Cast((Win/(win+loss+draw))*100 as \n" +
"decimal(18,2)) as varchar(50)) + ' %' as Percentage)\n" +
"from Tournament \n" +
"inner join [La Liga] on [La Liga].Match_Date = Tournament.Match_Date where Tournament.Match_Date = " + "'" + value +"'";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                
                m_oppo_tf.setText(rs.getString(1));
                w_r_tf.setText(rs.getString(2));
                
            }
            }
            else
            {
                String sql= "select Match_Opponent,(select Cast(Cast((Win/(win+loss+draw))*100 as \n" +
"decimal(18,2)) as varchar(50)) + ' %' as Percentage) \n" +
"from Tournament\n" +
"inner join [Champions league] on [Champions league].Match_Date = Tournament.Match_Date where Tournament.Match_Date = " + "'" + value +"'";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                
                m_oppo_tf.setText(rs.getString(1));
                w_r_tf.setText(rs.getString(2));
            }
            }
            
            String fee ="select\n" +
"case\n" +
"	when result = 'win' then 50000*1.00\n" +
"	when result = 'draw' then 50000*.75\n" +
"	when result = 'loss' then 50000*.50\n" +
"end as cost\n" +
"from Tournament where Match_Date = " + "'" + value +"'";
            
            PreparedStatement pst_fee = con.prepareStatement(fee);
                ResultSet rs_fee = pst_fee.executeQuery();
                while (rs_fee.next()) {
                
                m_f_tf.setText(rs_fee.getString(1));

            }
            
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        back_btn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        match_type_combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        home_radio = new javax.swing.JRadioButton();
        away_radio = new javax.swing.JRadioButton();
        stadium_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        result_combo = new javax.swing.JComboBox<>();
        insert_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        show_jTable = new javax.swing.JTable();
        m_oppo_tf = new javax.swing.JTextField();
        w_r_tf = new javax.swing.JTextField();
        m_f_tf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 505));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_btn1.setText("Back");
        back_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 80));
        jPanel2.setMaximumSize(new java.awt.Dimension(1000, 505));
        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 505));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Tournament");

        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Match Date:");

        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Match Type:");

        match_type_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "La Liga", "Champions League" }));
        match_type_combo.setBorder(null);

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Match Area:");

        home_radio.setForeground(java.awt.Color.white);
        home_radio.setText("Home");
        home_radio.setBorder(null);
        home_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_radioActionPerformed(evt);
            }
        });

        away_radio.setForeground(java.awt.Color.white);
        away_radio.setText("Away");
        away_radio.setBorder(null);
        away_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                away_radioActionPerformed(evt);
            }
        });

        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Stadium:");

        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Result:");

        result_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Win", "Loss", "Draw", "Abandoned" }));
        result_combo.setBorder(null);

        insert_btn.setText("Insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });

        clear_btn.setText("Clear");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        update_btn.setText("Update");

        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });

        show_jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Match Date", "Match Type", "Match Area", "Stadium", "Result"
            }
        ));
        show_jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(show_jTable);

        m_oppo_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        m_oppo_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_oppo_tfActionPerformed(evt);
            }
        });

        w_r_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        w_r_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w_r_tfActionPerformed(evt);
            }
        });

        m_f_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        m_f_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_f_tfActionPerformed(evt);
            }
        });

        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Match Fee");

        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Win Ratio");

        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Opponent");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(44, 44, 44)
                        .addComponent(result_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(match_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(home_radio)
                                        .addGap(18, 18, 18)
                                        .addComponent(away_radio))
                                    .addComponent(stadium_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1)))
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(refresh_btn)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insert_btn)
                            .addComponent(update_btn))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(clear_btn))
                            .addComponent(delete_btn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(m_oppo_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(w_r_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel7)
                                .addGap(137, 137, 137)
                                .addComponent(jLabel8)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(m_f_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(124, 124, 124))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel6)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(match_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(home_radio)
                                    .addComponent(away_radio))
                                .addGap(18, 18, 18)
                                .addComponent(stadium_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(result_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(refresh_btn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(insert_btn)
                        .addGap(18, 18, 18)
                        .addComponent(update_btn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(clear_btn)
                        .addGap(18, 18, 18)
                        .addComponent(delete_btn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(m_f_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(m_oppo_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(w_r_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 505));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Staffs/gg.jpg"))); // NOI18N
        jLabel10.setIconTextGap(0);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 505));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void home_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_radioActionPerformed
        // TODO add your handling code here:
        if (home_radio.isSelected()) {
            away_radio.setSelected(false);
        }
    }//GEN-LAST:event_home_radioActionPerformed

    private void away_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_away_radioActionPerformed
        // TODO add your handling code here:
        if (away_radio.isSelected()) {
            home_radio.setSelected(false);
        }
    }//GEN-LAST:event_away_radioActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to Delete?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirm == 0) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
                Connection con = DriverManager.getConnection(url);
                int row = show_jTable.getSelectedRow();
                String value = (show_jTable.getModel().getValueAt(row, 0).toString());
                String query = "Delete from tournament where match_date=" + value;
                PreparedStatement pst = con.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) show_jTable.getModel();
                model.setRowCount(0);
                show_tournament();

                JOptionPane.showMessageDialog(null, "Deleted Sucessfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        date.setCalendar(null);
        match_type_combo.setSelectedIndex(-1);
        home_radio.setSelected(false);
        away_radio.setSelected(false);
        stadium_tf.setText("");
        result_combo.setSelectedIndex(-1);
    }//GEN-LAST:event_clear_btnActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query = "insert into tournament(match_date, match_type, match_area, stadium, result)values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String m_date = sdf.format(date.getDate());
            pst.setString(1, m_date);
            String m_type;
            m_type = match_type_combo.getSelectedItem().toString();
            pst.setString(2, m_type);
            if (home_radio.isSelected()) {
                m_area = "Home";
            }
            if (away_radio.isSelected()) {
                m_area = "Away";
            }
            pst.setString(3, m_area);
            pst.setString(4, stadium_tf.getText());
            String m_result;
            m_result = result_combo.getSelectedItem().toString();
            pst.setString(5, m_result);

            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) show_jTable.getModel();
            model.setRowCount(0);
            show_tournament();

            JOptionPane.showMessageDialog(null, "Inserted Sucessfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_insert_btnActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) show_jTable.getModel();
        model.setRowCount(0);
        show_tournament();
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void back_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btn1ActionPerformed
        // TODO add your handling code here:
        window field = new window();
        field.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_back_btn1ActionPerformed

    private void show_jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show_jTableMouseClicked
        // TODO add your handling code here:
        int i = show_jTable.getSelectedRow();
        TableModel model = show_jTable.getModel();
        try {
            Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(((String) model.getValueAt(i, 0)));
            date.setDate(dt);
        } catch (ParseException ex) {
            Logger.getLogger(tournament1.class.getName()).log(Level.SEVERE, null, ex);
        }

        String league = model.getValueAt(i, 1).toString();
        switch (league) {
            case "La Liga":
                match_type_combo.setSelectedIndex(0);
                break;
            case "Champions League":
                match_type_combo.setSelectedIndex(1);
                break;
        }

        String area = model.getValueAt(i, 2).toString();
        if (area.equals("Home")) {
            home_radio.setSelected(true);
            away_radio.setSelected(false);
        }
        if (area.equals("Away")) {
            away_radio.setSelected(true);
            home_radio.setSelected(false);
        }

        stadium_tf.setText(model.getValueAt(i, 3).toString());

        String result = model.getValueAt(i, 4).toString();
        switch (result) {
            case "Win":
                result_combo.setSelectedIndex(0);
                break;
            case "Loss":
                result_combo.setSelectedIndex(1);
                break;
            case "Draw":
                result_combo.setSelectedIndex(2);
                break;
            case "Abandoned":
                result_combo.setSelectedIndex(3);
                break;
        }
        
        leauge_info();

    }//GEN-LAST:event_show_jTableMouseClicked

    private void w_r_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w_r_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_w_r_tfActionPerformed

    private void m_oppo_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_oppo_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_oppo_tfActionPerformed

    private void m_f_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_f_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_f_tfActionPerformed

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
            java.util.logging.Logger.getLogger(tournament1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tournament1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tournament1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tournament1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tournament1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton away_radio;
    private javax.swing.JButton back_btn1;
    private javax.swing.JButton clear_btn;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton delete_btn;
    private javax.swing.JRadioButton home_radio;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField m_f_tf;
    private javax.swing.JTextField m_oppo_tf;
    private javax.swing.JComboBox<String> match_type_combo;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JComboBox<String> result_combo;
    private javax.swing.JTable show_jTable;
    private javax.swing.JTextField stadium_tf;
    private javax.swing.JButton update_btn;
    private javax.swing.JTextField w_r_tf;
    // End of variables declaration//GEN-END:variables
}
