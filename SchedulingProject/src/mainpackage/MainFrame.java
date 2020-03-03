package mainpackage;

import javax.swing.JOptionPane;


/**
 *
 * @author 光る諒
 */
public class MainFrame extends javax.swing.JFrame {
    private static final int P_LENGTH = 4;
    private Process[] process;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        calculateButton = new javax.swing.JButton();
        algorithmSelector = new javax.swing.JComboBox();
        box1 = new javax.swing.JTextField();
        box2 = new javax.swing.JTextField();
        box3 = new javax.swing.JTextField();
        box4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scheduling Algorithm");
        setResizable(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null},
                {"2", null},
                {"3", null},
                {"4", null}
            },
            new String [] {
                "Process", "Burst Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
        }

        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });

        algorithmSelector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Shortest Job First", "First Come First Serve" }));

        box1.setBackground(new java.awt.Color(255, 255, 153));

        box2.setBackground(new java.awt.Color(153, 255, 153));

        box3.setBackground(new java.awt.Color(255, 204, 153));

        box4.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(392, 392, 392)
                            .addComponent(algorithmSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(box4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calculateButton)
                    .addComponent(algorithmSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        try {
            process = new Process[P_LENGTH];
            for (int i = 0; i < P_LENGTH; i++) {
                process[i] = new Process();
                process[i].processNumber = table.getValueAt(i, 0).toString();
                process[i].burstTime = Integer.parseInt(table.getValueAt(i, 1).toString());
            }
        }
        catch(NullPointerException npe) {
            JOptionPane.showMessageDialog(rootPane, "Please fill up all the labels before calculating.");
        }
        catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(rootPane, "Please input numbers only in the burst time.");
        }
        
        SJF sjf = new SJF();
        sjf.sortProcess(process);
//        sjf.displayArray(process);
        
        setGanttChart(process);
    }//GEN-LAST:event_calculateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    public void setGanttChart(Process[] p) {
        final int totalWidth = 670, height = 40, y = box1.getY();
        float sumOfBurstTime = 0;
        float[] boxRate = new float[P_LENGTH];
        
        // get the total burst time
        for (int i = 0; i < P_LENGTH; i++) {
            sumOfBurstTime += p[i].burstTime;
        }
        // set the box size's rating
        for (int i = 0; i < P_LENGTH; i++) {
            boxRate[i] = (p[i].burstTime / sumOfBurstTime);
        }
        
        // set box sizes
        box1.setSize((int) (boxRate[0] * totalWidth), height);
        box2.setSize((int) (boxRate[1] * totalWidth), height);
        box3.setSize((int) (boxRate[2] * totalWidth), height);
        box4.setSize((int) (boxRate[3] * totalWidth), height);
        
        // set the location of boxes
        box2.setLocation(box1.getWidth() + box1.getX(), y);
        box3.setLocation(box2.getWidth() + box2.getX(), y);
        box4.setLocation(box3.getWidth() + box3.getX(), y);
        
        // setting the labels of the boxes
        box1.setText(p[0].processNumber);
        box2.setText(p[1].processNumber);
        box3.setText(p[2].processNumber);
        box4.setText(p[3].processNumber);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox algorithmSelector;
    private javax.swing.JTextField box1;
    private javax.swing.JTextField box2;
    private javax.swing.JTextField box3;
    private javax.swing.JTextField box4;
    private javax.swing.JButton calculateButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
