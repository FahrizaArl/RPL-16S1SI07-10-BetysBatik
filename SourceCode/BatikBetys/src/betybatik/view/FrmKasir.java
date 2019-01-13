/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betybatik.view;

import betybatik.engine.conn_service;
import betybatik.entity.EntityService;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import betybatik.view.*;
import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.System.out;

public class FrmKasir extends javax.swing.JFrame {
    EntityService es = new EntityService();
    public FrmKasir() {
        initComponents();
        load_table();
        loadDiskon();
        txtDiskonJt.setEditable(false);
        txtSubTotal.setEditable(false);
        txtDiscount.setEditable(false);
        txtKembali.setEditable(false);
       
    }
    public void loadDiskon(){
    try {
        FileReader fr = new FileReader(".\\diskon.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String str;
        while((str = br.readLine()) != null){
        //out.println(str+"\n");
        txtDiscount.setText(str);
        }
        br.close();
    } catch (Exception e) {
        out.println("File not Found!");
    }
}
 private void load_table(){
         DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Id");
        model.addColumn("Nama Barang");
        model.addColumn("Jenis Barang");
        model.addColumn("Stok");
        model.addColumn("Merk");
        model.addColumn("Ukuran");
        model.addColumn("Harga");
      try {
             int no=1;
            String sql = "select * from barang";//fungsi untuk mengambil data dari tabel barang
            java.sql.Connection conn=(Connection)conn_service.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});//fungsi untuk menambah data sesuai baris              
            
            }
            tblKasir.setModel(model);
        } catch (Exception e) {
        }
        
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("No.");
        model2.addColumn("Id");
        model2.addColumn("Nama Barang");
        model2.addColumn("Jenis Barang");
        model2.addColumn("Stok");
        model2.addColumn("Merk");
        model2.addColumn("Ukuran");
        model2.addColumn("Harga");
       tblYgDibeli.setModel(model2);

            
    }
 public void subtotal(){
 int sum = 0;
 for(int i = 0;i<tblYgDibeli.getRowCount();i++)
 {
     sum = sum + Integer.parseInt(tblYgDibeli.getValueAt(i, 7).toString());
 }
 if(sum >= 10000000){
     
     int dsc = Integer.parseInt(txtDiscount.getText());
     int a = es.diskon(dsc, sum);
     String c = Integer.toString(a);
   //  txtSubTotal.setText("");
 txtDiskonJt.setText(c);
 }else{
 txtSubTotal.setText(Integer.toString(sum));
 //txtDiskonJt.setText("");
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKasir = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtKembali = new javax.swing.JTextField();
        btnBayar = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnPGantiAkun = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblYgDibeli = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnHitungTotal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtDiscount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDiskonJt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnBersihkan = new javax.swing.JButton();
        btnTotalClear = new javax.swing.JButton();
        BTNMEMBER = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 0));

        tblKasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblKasir.getTableHeader().setReorderingAllowed(false);
        tblKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKasirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKasir);

        jLabel5.setText("Subtotal");

        jLabel7.setText("Bayar");

        jLabel8.setText("Kembali");

        txtSubTotal.setText("0");

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });
        txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBayarKeyTyped(evt);
            }
        });

        txtKembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKembaliKeyTyped(evt);
            }
        });

        btnBayar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBayar.setText("BAYAR");
        btnBayar.setActionCommand("BA");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCetak.setText("CETAK");

        btnPGantiAkun.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPGantiAkun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/betybatik/image/Log-Out-icon.png"))); // NOI18N
        btnPGantiAkun.setText("Log Out");
        btnPGantiAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPGantiAkunActionPerformed(evt);
            }
        });

        tblYgDibeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblYgDibeli.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblYgDibeli);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Barang Yang Dibeli");

        btnHitungTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHitungTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/betybatik/image/03.png"))); // NOI18N
        btnHitungTotal.setText("Hitung Total Bayar");
        btnHitungTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungTotalActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Fitur Transaksi diatas 10 Juta"));

        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });

        jLabel6.setText("Discount");

        jLabel12.setText("Subtotal");

        txtDiskonJt.setText("0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiskonJt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDiskonJt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnBersihkan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBersihkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/betybatik/image/09.png"))); // NOI18N
        btnBersihkan.setText("Hapus Item");
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });

        btnTotalClear.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTotalClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/betybatik/image/05.png"))); // NOI18N
        btnTotalClear.setText("Bersihkan Total");
        btnTotalClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalClearActionPerformed(evt);
            }
        });

        BTNMEMBER.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        BTNMEMBER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/betybatik/image/icon.png"))); // NOI18N
        BTNMEMBER.setText("DAFTAR MEMBER");
        BTNMEMBER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNMEMBERActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPGantiAkun)
                .addGap(40, 40, 40)
                .addComponent(BTNMEMBER)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(546, 546, 546)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(31, 31, 31)
                                        .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnTotalClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBersihkan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHitungTotal, javax.swing.GroupLayout.Alignment.LEADING))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPGantiAkun)
                    .addComponent(BTNMEMBER))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHitungTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnBersihkan)))
                .addGap(21, 21, 21)
                .addComponent(btnTotalClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
         int diskon10jt = Integer.parseInt(txtDiskonJt.getText());

       int b = Integer.parseInt(txtBayar.getText());
       int sub=Integer.parseInt(txtSubTotal.getText());
       if(diskon10jt > 10000000){
            int a = Integer.parseInt(txtDiskonJt.getText());
            int bayar = es.transaksi(a,b);
            String byr = Integer.toString(bayar);
            txtKembali.setText(byr);
       }else
        if(sub < 10000000){
        int c = Integer.parseInt(txtSubTotal.getText());
            int bayar2 = es.transaksi(c,b);
            String byr2 = Integer.toString(bayar2);
            txtKembali.setText(byr2);
       }
        
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnHitungTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungTotalActionPerformed
                      subtotal();  
                      
    }//GEN-LAST:event_btnHitungTotalActionPerformed

    private void tblKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKasirMouseClicked
                TableModel mode1 = tblKasir.getModel();
      int[] indexs = tblKasir.getSelectedRows();
      Object[] row = new Object[9];
      DefaultTableModel model2 = (DefaultTableModel) tblYgDibeli.getModel();
              for(int i=0;i<indexs.length;i++){
              row[0] = mode1.getValueAt(indexs[i], 0);
              row[1] = mode1.getValueAt(indexs[i], 1);
              row[2] = mode1.getValueAt(indexs[i], 2);
              row[3] = mode1.getValueAt(indexs[i], 3);
              row[4] = mode1.getValueAt(indexs[i], 4);
              row[5] = mode1.getValueAt(indexs[i], 5);
              row[6] = mode1.getValueAt(indexs[i], 6);
              row[7] = mode1.getValueAt(indexs[i], 7);
//              row[8] = mode1.getValueAt(indexs[i], 8);
              model2.addRow(row);
              }

    }//GEN-LAST:event_tblKasirMouseClicked

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed

        removeSelectedRows(tblYgDibeli);
    }//GEN-LAST:event_btnBersihkanActionPerformed

    private void btnTotalClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalClearActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblYgDibeli.getModel();
        model.setRowCount(0);
        txtSubTotal.setText("0");
        txtDiskonJt.setText("0");
        txtBayar.setText("");
        txtKembali.setText("");
    }//GEN-LAST:event_btnTotalClearActionPerformed

    private void btnPGantiAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPGantiAkunActionPerformed
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPGantiAkunActionPerformed

    private void BTNMEMBERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNMEMBERActionPerformed
        // TODO add your handling code here:
        new FrmKasirDaftarMember().setVisible(true);
      this.dispose();
    }//GEN-LAST:event_BTNMEMBERActionPerformed

    private void txtBayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyTyped
              char c=evt.getKeyChar();
        if((!Character.isDigit(c)))//Fungsi untuk hanya bisa mengetikkan angka
        {evt.consume();}
       
    }//GEN-LAST:event_txtBayarKeyTyped

    private void txtKembaliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKembaliKeyTyped
              char c=evt.getKeyChar();
        if((!Character.isDigit(c)))//Fungsi untuk hanya bisa mengetikkan angka
        {evt.consume();}
       
    }//GEN-LAST:event_txtKembaliKeyTyped

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountActionPerformed
   public void removeSelectedRows(JTable table){
   DefaultTableModel model = (DefaultTableModel) this.tblYgDibeli.getModel();
   int[] rows = table.getSelectedRows();
   for(int i=0;i<rows.length;i++){
     model.removeRow(rows[i]-i);
   }
}
    /**}
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
            java.util.logging.Logger.getLogger(FrmKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNMEMBER;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHitungTotal;
    private javax.swing.JButton btnPGantiAkun;
    private javax.swing.JButton btnTotalClear;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKasir;
    private javax.swing.JTable tblYgDibeli;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDiskonJt;
    private javax.swing.JTextField txtKembali;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
