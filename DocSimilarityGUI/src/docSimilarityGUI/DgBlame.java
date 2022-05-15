/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docSimilarityGUI;

import codeSimilarity.Blame;
import codeSimilarity.Comparisons;
import codeSimilarity.Document;
import codeSimilarity.FileUtils;
import codeSimilarity.FilesSimilarity;
import java.awt.Font;
import java.io.File;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gowl
 */
public class DgBlame extends javax.swing.JDialog {

    private final Comparisons comparisons;
    private boolean showAll = true;

    public DgBlame(java.awt.Frame parent, boolean modal, Comparisons comparisons) {
        super(parent, modal);
        initComponents();
        
        this.comparisons = comparisons;
        
        showComparisons();
        
        tbBlames.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            int line = tbBlames.getSelectedRow();

            if (line < 0) {
                ta1.setText("");
                ta2.setText("");
            }
            else {
                Document suspect = (Document) tbBlames.getModel().getValueAt(line, 0);
                Document other   = (Document) tbBlames.getModel().getValueAt(line, 2);

                loadFile(suspect.getFile(), ta1);
                loadFile(other  .getFile(), ta2);
            }
        });
        
        ta1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        ta2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        ta1.setEditable(false);
        ta2.setEditable(false);
    }

    private void loadFile(File file, JTextArea ta) {
        String content = FileUtils.readFile(file);
        ta.setText(content);
        ta.setCaretPosition(0);
    }
    
//    private void showComparison() {
//        if(showAll) 
//            showAll();
//        else
//            showBlames();
//    }
//    
//    private void showAll() {
//        
//    }
//    
    
    private void showComparisons() {
        String[] cols = {"Suspect", "Similarity", "Other"};

        DefaultTableModel tableModel = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if(showAll){
            List<FilesSimilarity> list = comparisons.getComparisons();
            tableModel.setRowCount(list.size());
            int i = 0;
            for(FilesSimilarity fs : list) {
                String similarity = String.format("%.2f%%", fs.getSimilarity()*100);

                tableModel.setValueAt(fs.getDoc1()  , i, 0);
                tableModel.setValueAt(similarity    , i, 1);
                tableModel.setValueAt(fs.getDoc2()  , i, 2);
                i++;
            }
        }
        else {
            List<Blame> blames = comparisons.makeBlameList();  //criar um getBlameList() que chama o makeBlameList() quando precisar.
            tableModel.setRowCount(blames.size());
            int i = 0;
            for(Blame b : blames) {
                String similarity = String.format("%.2f%%", b.getSimilarity()*100);

                tableModel.setValueAt(b.getSuspect()   , i, 0);
                tableModel.setValueAt(similarity       , i, 1);
                tableModel.setValueAt(b.getTheOther()  , i, 2);
                i++;
            }            
        }
        
        tbBlames.setModel(tableModel);
        
        tbBlames.getColumnModel().getColumn(1).setPreferredWidth(70);
        tbBlames.getColumnModel().getColumn(1).setMaxWidth(70);
        tbBlames.getColumnModel().getColumn(1).setMinWidth(70);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbBlames.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spTableFiles = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBlames = new javax.swing.JTable();
        spFiles = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta2 = new javax.swing.JTextArea();
        cbShowAll = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Blame");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        spTableFiles.setDividerLocation(200);
        spTableFiles.setDividerSize(7);
        spTableFiles.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        tbBlames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBlames.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tbBlames);

        spTableFiles.setTopComponent(jScrollPane1);

        spFiles.setBorder(null);
        spFiles.setDividerLocation(320);
        spFiles.setDividerSize(7);

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane2.setViewportView(ta1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
        );

        spFiles.setLeftComponent(jPanel1);

        ta2.setColumns(20);
        ta2.setRows(5);
        jScrollPane3.setViewportView(ta2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
        );

        spFiles.setRightComponent(jPanel2);

        spTableFiles.setRightComponent(spFiles);

        cbShowAll.setText("Show all comparisons");
        cbShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTableFiles)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbShowAll)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbShowAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTableFiles, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        spFiles.setDividerLocation(spFiles.getWidth()/2);
    }//GEN-LAST:event_formWindowActivated

    private void cbShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowAllActionPerformed
        showAll = cbShowAll.isSelected();
        showComparisons();
    }//GEN-LAST:event_cbShowAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbShowAll;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane spFiles;
    private javax.swing.JSplitPane spTableFiles;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextArea ta2;
    private javax.swing.JTable tbBlames;
    // End of variables declaration//GEN-END:variables
}
