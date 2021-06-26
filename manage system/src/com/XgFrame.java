package com;

/**��������
 * */
public class XgFrame extends javax.swing.JFrame {

   
	private static final long serialVersionUID = 1L;
	/**
     * ���췽��
     */
    public XgFrame() {
        initComponents();
    }
    /**��ʼ����Ʒѡ�
     * */
    private void initCombobox(){
    	String[][] name = Main.toArray(
        		Main.select("select * from shangpin", 6));
        String[] shangpin = new String[name.length];
        for(int i = 0;i < name.length;i++) {
        	shangpin[i] = name[i][0];
        }
        jComboBox1.setModel(
        		new javax.swing.DefaultComboBoxModel<>(shangpin));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
        		new String[] { "����", "�ۼ�", "����", "��Ӧ��", "��ע" }));
    }
    
    
    /**��ʼ�����
     * */                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(350, 200));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        jLabel1.setText("Ҫ�޸���Ʒ��");

        jLabel2.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        jLabel2.setText("Ҫ�޸ĵ��");

        jLabel3.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        jLabel3.setText("�޸ĺ��ֵ��");
        
        initCombobox();

        

        jButton1.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        jButton1.setText("ȷ��");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox1, 0, 115, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    /**ȷ����ť
     * */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	System.out.println("�޸�");
    	String sqlcode = "update shangpin set ";
    	String item = jComboBox2.getSelectedItem().toString();
    	if(item.equals("����")) {
    		sqlcode = sqlcode + "purchase_price = ";
    		String s = jTextField1.getText();
    		sqlcode = sqlcode + s;
    	}else if(item.equals("�ۼ�")) {
    		sqlcode = sqlcode + "sell_price = ";
    		String s = jTextField1.getText();
    		sqlcode = sqlcode + s;
    	}else if(item.equals("����")) {
    		sqlcode = sqlcode + "current_number = ";
    		String s = jTextField1.getText();
    		sqlcode = sqlcode + s;
    	}else if(item.equals("��Ӧ��")) {
    		sqlcode = sqlcode + "supplier = ";
    		String s = jTextField1.getText();
    		sqlcode = sqlcode +"'"+ s +"'";
    	}else {
    		sqlcode = sqlcode + "remark = ";
    		String s = jTextField1.getText();
    		sqlcode = sqlcode +"'"+ s +"'";
    	}
    	sqlcode = sqlcode + "where name = "+"'"+
    			jComboBox1.getSelectedItem().toString()+"'";
    	Main.update(sqlcode);
    	System.out.println("�޸ĳɹ�");
        setVisible(false);
    }                                        

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
            java.util.logging.Logger.getLogger(XgFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XgFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XgFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XgFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XgFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}

