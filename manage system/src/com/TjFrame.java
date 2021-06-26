package com;

/**统计窗体
 * */
public class TjFrame extends javax.swing.JFrame {

   
	private static final long serialVersionUID = 1L;
	/**
     * 构造方法
     */
    public TjFrame() {
        initComponents();
    }

    
    @SuppressWarnings({ "serial" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    /**初始化按钮
     * */
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(350, 200));
        setResizable(false);

        System.out.println("统计");
    	String[][] result = Main.toArray(
    			Main.select("select * from yuangong",4));
    	String[] xingming = new String[result.length];
    	for(int i = 0;i < xingming.length;i++) {
    		xingming[i] = result[i][0];
    	}
    	String[][] tongji = new String[xingming.length][3];
    	int jinhuo = 0;
    	int xiaoshou = 0;
    	for(int i = 0;i < xingming.length;i++) {
    		tongji[i][0] = xingming[i];
    		String sqlcode = "select count(*) from jinhuo where caigouyuan = ";
    		sqlcode = sqlcode + "'" + xingming[i] + "'";
    		result = Main.toArray(
        			Main.select(sqlcode,1));
    		jinhuo = Integer.valueOf(result[0][0]);
    		sqlcode = "select count(*) from xiaoshou where xiaoshouyuan = ";
    		sqlcode = sqlcode + "'" + xingming[i] + "'";
    		result = Main.toArray(
        			Main.select(sqlcode,1));
    		xiaoshou = Integer.valueOf(result[0][0]);
    		tongji[i][1] = ""+jinhuo;
    		tongji[i][2] = ""+xiaoshou;
    	}
    	jTable1.setModel(new javax.swing.table.DefaultTableModel(
                tongji,
                new String [] {
                    "员工姓名", "进货单数", "销售单数"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        System.out.println("统计成功");
        
       
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jButton1.setText("确定");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    /**确定按钮
     * */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	
        setVisible(false);
    }                                        

    /**
     * main函数
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
            java.util.logging.Logger.getLogger(TjFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TjFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TjFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TjFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TjFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}

