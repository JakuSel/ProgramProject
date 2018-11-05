package project;

import com.mysql.jdbc.*;
import java.awt.Color;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import javax.annotation.processing.Processor;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ToDo extends javax.swing.JFrame {
    
    Show showItems = new Show() {
        @Override
        public void apply() {
            ArrayList<ToDoItem> list = new MySQL().getAll();
            DefaultTableModel model = (DefaultTableModel) jTable1_ToDoItems.getModel();
            Object[] row = new Object[5];
            for (int i = 0; i < list.size(); i++)
            {
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getDate();
                row[2] = list.get(i).getName();
                row[3] = list.get(i).getDesc();
                row[4] = list.get(i).getStatus();
                  
                model.addRow(row);
            }
        }
    };
    
    Show refreshTable = new Show(){
        @Override
        public void apply(){       
            DefaultTableModel model = (DefaultTableModel) jTable1_ToDoItems.getModel();
            model.setRowCount(0);
            showItems.apply();
        }
    };

    public void ShowTodoItems()
    {
        ArrayList<ToDoItem> list = new MySQL().getAll();
        DefaultTableModel model = (DefaultTableModel) jTable1_ToDoItems.getModel();
        Object[] row = new Object[5];     
        
        for (int i = 0; i < list.size(); i++) 
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getDate();
            row[2] = list.get(i).getName();
            row[3] = list.get(i).getDesc();
            row[4] = list.get(i).getStatus();            
            
            model.addRow(row);
        }        
    }
    
    public void messageInfo(String message)
    {
        JOptionPane.showMessageDialog(null, "Data "+message+" successfully");
    }
    
    Message msg = (String msg) -> {
        JOptionPane.showMessageDialog(null, "Data "+msg+" successfully");
        return null;
    };
            
    public ToDo() {
        initComponents();
        showItems.apply();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1_Date = new com.toedter.calendar.JDateChooser();
        jTextField1_Name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1_Desc = new javax.swing.JTextArea();
        jComboBox1_Status = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1_ToDoItems = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Činnosť");

        jLabel2.setText("Popis");

        jLabel4.setText("Dátum");

        jLabel5.setText("Stav");

        jTextField1_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_NameActionPerformed(evt);
            }
        });

        jTextArea1_Desc.setColumns(20);
        jTextArea1_Desc.setRows(5);
        jScrollPane1.setViewportView(jTextArea1_Desc);

        jComboBox1_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SPLNENÉ", "NESPLNENÉ" }));

        jTable1_ToDoItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dátum", "Činnosť", "Popis", "Stav"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_ToDoItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_ToDoItemsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1_ToDoItemsMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1_ToDoItems);

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/Icons/add.png"))); // NOI18N
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/Icons/update.png"))); // NOI18N
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/Icons/delete.png"))); // NOI18N
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooser1_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1_Name)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDateChooser1_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addBtn)
                            .addComponent(updateBtn)
                            .addComponent(deleteBtn))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_NameActionPerformed

    private void jTable1_ToDoItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_ToDoItemsMouseClicked
    //Display selectd row in fields
        int i = jTable1_ToDoItems.getSelectedRow();
        TableModel model = jTable1_ToDoItems.getModel();
        jTextField1_Name.setText(model.getValueAt(i, 2).toString());
        jTextArea1_Desc.setText(model.getValueAt(i, 3).toString());
        jLabel6.setText(model.getValueAt(i, 0).toString());

            if (model.getValueAt(i, 4).equals(true)) {
                jComboBox1_Status.setSelectedIndex(0);
            }
            else
                jComboBox1_Status.setSelectedIndex(1);

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((model.getValueAt(i, 1)).toString());
            jDateChooser1_Date.setDate(date);
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jTable1_ToDoItemsMouseClicked

    private void jTable1_ToDoItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_ToDoItemsMousePressed
        
    }//GEN-LAST:event_jTable1_ToDoItemsMousePressed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        MySQL insertOpp = new MySQL();
        
        java.sql.Date sqldate = new java.sql.Date(jDateChooser1_Date.getDate().getTime());
        
        Integer status;
        if (jComboBox1_Status.getSelectedItem().equals("SPLNENÉ")) {
            status = 1;
        }else
            status= 0;
        
        insertOpp.Insert(jTextField1_Name.getText().trim(), 
                        jTextArea1_Desc.getText().trim(), 
                            sqldate,status);
        
        refreshTable.apply();
        msg.msg("ADDED");
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        MySQL updateOpp = new MySQL();

        java.sql.Date sqldate = new java.sql.Date(jDateChooser1_Date.getDate().getTime());
        
        Integer status;
        if (jComboBox1_Status.getSelectedItem().equals("SPLNENÉ")) {
            status = 1;
        }else
            status= 0;

        updateOpp.Update(jTextField1_Name.getText().trim(), 
                        jTextArea1_Desc.getText().trim(), 
                            sqldate,status,Integer.parseInt(jLabel6.getText().toString()));
        
        refreshTable.apply();
        msg.msg("UPDATED");    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        MySQL deleteOpp = new MySQL();
        
        deleteOpp.Delete(Integer.parseInt(jLabel6.getText().toString()));
        
        
        jTextField1_Name.setText("");
        jTextArea1_Desc.setText("");
        jLabel6.setText("");
        
        refreshTable.apply();
        msg.msg("DELETED");
    }//GEN-LAST:event_deleteBtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(ToDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToDo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> jComboBox1_Status;
    private com.toedter.calendar.JDateChooser jDateChooser1_Date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1_ToDoItems;
    private javax.swing.JTextArea jTextArea1_Desc;
    private javax.swing.JTextField jTextField1_Name;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

@FunctionalInterface
interface Message{
    JOptionPane msg(String msg);
}

interface Show{
    void apply();
}