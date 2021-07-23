
package newpackage;

import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class T extends javax.swing.JFrame 
{
    public Connection con;
    public Statement st;
    PreparedStatement pst;
    String pname,pnum,pmoney,pdate;
    
    public T() 
    {
        initComponents();
        connect();
    }
    
    private void setvalues()
    {
        try
        {
            pst = con.prepareStatement("insert into patientrecord(Name,Mobile_Number,Date,Payment)values(?,?,?,?)");
            pst.setString(1,pname);
            pst.setString(2,pnum);
            pst.setString(3,pdate);
            pst.setString(4,pmoney);
            pst.executeUpdate();  
            JOptionPane.showMessageDialog(this,"RECORDS SAVED");
            pname_tfield.setText("");
            pnum_tfield.setText("");
            pmoney_tfield.setText("");
            pdate_tfield.setText("");
        }
        catch(Exception e){JOptionPane.showMessageDialog(this,"ERROR IN SAVINGS RECORDS");}
    }
    
    private void getvalues()
    {
        try
        {
            pname=pname_tfield.getText();
            pnum=pnum_tfield.getText();
            pmoney=pmoney_tfield.getText();
            pdate=pdate_tfield.getText();
        }
        catch(Exception e){JOptionPane.showMessageDialog(this,"ERROR IN GETTING RECORDS");}
    }
    
    private void table_update()
    {
        int CC;
        try
        {
            pst = con.prepareStatement("select * from patientrecord where Name ='"+pname+"'"+"or Mobile_Number='"+pnum+"'");
            ResultSet Rs=pst.executeQuery();
            ResultSetMetaData RSMD=Rs.getMetaData();
            CC=RSMD.getColumnCount();
            DefaultTableModel DFT=(DefaultTableModel)jTable1.getModel();
            DFT.setRowCount(0);
           while(Rs.next())
           {
               Vector v2=new Vector();
               for(int ii=1;ii<=CC;ii++)
               {
                   v2.add(Rs.getString("Name"));
                   v2.add(Rs.getLong("Mobile_Number"));
                   v2.add(Rs.getString("Date"));
                   v2.add(Rs.getInt("Payment"));
               }
               DFT.addRow(v2);
           }  
        }
        catch(Exception e){System.out.println(e);}
    }
    
    private void connect()
    {
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patient?zeroDateTimeBehavior=convertToNull","root","");
            st=con.createStatement();
            System.out.println("Connected");
            JOptionPane.showMessageDialog(this,"Connected");  
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Xampp Connection Error");
            JOptionPane.showMessageDialog(this,e);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pname_label = new javax.swing.JLabel();
        pnum_tfield = new javax.swing.JTextField();
        pnum_label = new javax.swing.JLabel();
        pname_tfield = new javax.swing.JTextField();
        pmoney_label = new javax.swing.JLabel();
        pdate_tfield = new javax.swing.JTextField();
        pdate_label = new javax.swing.JLabel();
        pmoney_tfield = new javax.swing.JTextField();
        logo = new javax.swing.JLabel();
        See = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setForeground(new java.awt.Color(100, 100, 100));

        pname_label.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pname_label.setText("Patient Name");

        pnum_tfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnum_tfieldActionPerformed(evt);
            }
        });

        pnum_label.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pnum_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnum_label.setText("Patient Number");

        pmoney_label.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pmoney_label.setText("Amount");

        pdate_tfield.setText("2021-06-14");
        pdate_tfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdate_tfieldActionPerformed(evt);
            }
        });

        pdate_label.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pdate_label.setText("Date");

        pmoney_tfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmoney_tfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnum_label)
                    .addComponent(pname_label)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pmoney_label)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(pdate_label)))))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pname_tfield, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnum_tfield, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                        .addComponent(pdate_tfield)
                        .addComponent(pmoney_tfield)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pname_tfield, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pname_label, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnum_tfield, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnum_label, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pmoney_label)
                    .addComponent(pmoney_tfield, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdate_label)
                    .addComponent(pdate_tfield, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        logo.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setText("GURU NANAK DENTAL CLINIC");

        See.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        See.setText("SEE");
        See.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeeActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Mobile_Number", "Date", "Payment"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(See)
                                .addGap(178, 178, 178)
                                .addComponent(exit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(285, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(See)
                    .addComponent(exit)
                    .addComponent(add))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pdate_tfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdate_tfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pdate_tfieldActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void pmoney_tfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmoney_tfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pmoney_tfieldActionPerformed

    private void SeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeeActionPerformed
        getvalues();
        table_update();
    }//GEN-LAST:event_SeeActionPerformed

    private void pnum_tfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnum_tfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnum_tfieldActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        getvalues();
        setvalues();
    }//GEN-LAST:event_addActionPerformed

    
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
            java.util.logging.Logger.getLogger(T.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(T.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(T.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(T.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new T().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton See;
    private javax.swing.JButton add;
    private javax.swing.JButton exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel pdate_label;
    private javax.swing.JTextField pdate_tfield;
    private javax.swing.JLabel pmoney_label;
    private javax.swing.JTextField pmoney_tfield;
    private javax.swing.JLabel pname_label;
    private javax.swing.JTextField pname_tfield;
    private javax.swing.JLabel pnum_label;
    private javax.swing.JTextField pnum_tfield;
    // End of variables declaration//GEN-END:variables
}
