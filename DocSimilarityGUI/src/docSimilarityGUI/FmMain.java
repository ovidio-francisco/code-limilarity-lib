package docSimilarityGUI;

import codeSimilarity.Comparisons;
import codeSimilarity.Document;
import codeSimilarity.FileUtils;
import codeSimilarity.FilesSimilarity;
import codeSimilarity.MessagePrinter;
import java.io.File;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class FmMain extends javax.swing.JFrame {

    private final DefaultTableModel tableModel;
    private File currentDir = new File(System.getProperty("user.home"));

    public FmMain() {
        initComponents();        

        lbStatus.setText(" ");        
        String[] cols = {"Similarity", "Size 1", "Size 2", "Dist.", "File 1", "File 2"};
                
        tableModel = new DefaultTableModel(cols, 4); 
                
        tbComparisons.setModel(tableModel);
        tbComparisons.getColumnModel().getColumn(0).setPreferredWidth(70);
        tbComparisons.getColumnModel().getColumn(0).setMaxWidth(70);
        tbComparisons.getColumnModel().getColumn(0).setMinWidth(70);
        
        tbComparisons.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbComparisons.getColumnModel().getColumn(1).setMaxWidth(50);
        tbComparisons.getColumnModel().getColumn(1).setMinWidth(50);

        tbComparisons.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbComparisons.getColumnModel().getColumn(2).setMaxWidth(50);
        tbComparisons.getColumnModel().getColumn(2).setMinWidth(50);

        tbComparisons.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbComparisons.getColumnModel().getColumn(3).setMaxWidth(50);
        tbComparisons.getColumnModel().getColumn(3).setMinWidth(50);

        tbComparisons.getColumnModel().getColumn(4).setPreferredWidth(200);
        tbComparisons.getColumnModel().getColumn(4).setMinWidth(200);
        
        tbComparisons.getColumnModel().getColumn(5).setPreferredWidth(200);
        tbComparisons.getColumnModel().getColumn(5).setMinWidth(200);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        tbComparisons.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbComparisons.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbComparisons.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbComparisons.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        
        enableButtons();
    }
    
    private void enableButtons() {
        btCompare.setEnabled(comparisons != null && comparisons.getDocs().size() > 0);
        btBlame  .setEnabled(comparisons != null && comparisons.getComparisons().size() > 0);
        btExport .setEnabled(comparisons != null && comparisons.getComparisons().size() > 0);
    }
    
    private void showPaths() {
        DefaultListModel model = new DefaultListModel();        

        for(File f : comparisons.getPaths())    
            model.addElement(f.getName());
        
        lsPaths.setModel(model);    
    }
    

    private void showFiles() {
        DefaultListModel model = new DefaultListModel();        

        comparisons.createDocuments();
        
        for(Document f : comparisons.getDocs())    
            model.addElement(f);
        
        lsFiles.setModel(model);    
    }
    
    private void addPath(File path) {
        comparisons.addPath(path);
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        pnToolBar = new javax.swing.JPanel();
        btAddFiles = new javax.swing.JButton();
        btSettings = new javax.swing.JButton();
        btCompare = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btBlame = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btExport = new javax.swing.JButton();
        pnMain = new javax.swing.JPanel();
        spMain = new javax.swing.JSplitPane();
        pnPathsFiles = new javax.swing.JPanel();
        lbFilesCount = new javax.swing.JLabel();
        tpPaths = new javax.swing.JTabbedPane();
        pnPaths = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsPaths = new javax.swing.JList<>();
        pnFiles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsFiles = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        tbExtensions = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btFilter = new javax.swing.JButton();
        pnSimilarities = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbComparisons = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lbComparisonsCount = new javax.swing.JLabel();
        pnStatusBar = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Code Similarity");

        jToolBar1.setName("tbMain"); // NOI18N

        btAddFiles.setText("Add Files");
        btAddFiles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAddFiles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAddFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddFilesActionPerformed(evt);
            }
        });

        btSettings.setText("Settings");
        btSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSettingsActionPerformed(evt);
            }
        });

        btCompare.setText("Compare");
        btCompare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompareActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");

        btBlame.setText("Blame");
        btBlame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBlameActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setToolTipText("");

        btExport.setText("Export");
        btExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnToolBarLayout = new javax.swing.GroupLayout(pnToolBar);
        pnToolBar.setLayout(pnToolBarLayout);
        pnToolBarLayout.setHorizontalGroup(
            pnToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnToolBarLayout.createSequentialGroup()
                .addComponent(btAddFiles)
                .addGap(18, 18, 18)
                .addComponent(btSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCompare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btBlame)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        pnToolBarLayout.setVerticalGroup(
            pnToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btAddFiles, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
            .addComponent(btSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btBlame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btCompare, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btExport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jToolBar1.add(pnToolBar);

        spMain.setDividerSize(6);

        lbFilesCount.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbFilesCount.setText("jLabel3");
        lbFilesCount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));

        lsPaths.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lsPaths);

        javax.swing.GroupLayout pnPathsLayout = new javax.swing.GroupLayout(pnPaths);
        pnPaths.setLayout(pnPathsLayout);
        pnPathsLayout.setHorizontalGroup(
            pnPathsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        pnPathsLayout.setVerticalGroup(
            pnPathsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        tpPaths.addTab("Paths", pnPaths);

        lsFiles.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(lsFiles);

        javax.swing.GroupLayout pnFilesLayout = new javax.swing.GroupLayout(pnFiles);
        pnFiles.setLayout(pnFilesLayout);
        pnFilesLayout.setHorizontalGroup(
            pnFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        pnFilesLayout.setVerticalGroup(
            pnFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        tpPaths.addTab("Files", pnFiles);

        jLabel3.setText("Extensions");

        btFilter.setText("Filter");
        btFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tbExtensions)
                .addGap(18, 18, 18)
                .addComponent(btFilter))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbExtensions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFilter)))
        );

        javax.swing.GroupLayout pnPathsFilesLayout = new javax.swing.GroupLayout(pnPathsFiles);
        pnPathsFiles.setLayout(pnPathsFilesLayout);
        pnPathsFilesLayout.setHorizontalGroup(
            pnPathsFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPathsFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPathsFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPathsFilesLayout.createSequentialGroup()
                        .addComponent(lbFilesCount)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tpPaths)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnPathsFilesLayout.setVerticalGroup(
            pnPathsFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPathsFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpPaths)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFilesCount))
        );

        spMain.setLeftComponent(pnPathsFiles);

        jScrollPane2.setBorder(null);

        tbComparisons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tbComparisons);

        jLabel2.setText("Similarities");

        lbComparisonsCount.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbComparisonsCount.setText("jLabel4");
        lbComparisonsCount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));

        javax.swing.GroupLayout pnSimilaritiesLayout = new javax.swing.GroupLayout(pnSimilarities);
        pnSimilarities.setLayout(pnSimilaritiesLayout);
        pnSimilaritiesLayout.setHorizontalGroup(
            pnSimilaritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSimilaritiesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSimilaritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addGroup(pnSimilaritiesLayout.createSequentialGroup()
                        .addGroup(pnSimilaritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lbComparisonsCount))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnSimilaritiesLayout.setVerticalGroup(
            pnSimilaritiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSimilaritiesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbComparisonsCount))
        );

        spMain.setRightComponent(pnSimilarities);

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spMain)
                .addContainerGap())
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spMain)
        );

        pnStatusBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));

        lbStatus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbStatus.setText("jLabel3");
        lbStatus.setMaximumSize(new java.awt.Dimension(500, 15));
        lbStatus.setName(""); // NOI18N

        javax.swing.GroupLayout pnStatusBarLayout = new javax.swing.GroupLayout(pnStatusBar);
        pnStatusBar.setLayout(pnStatusBarLayout);
        pnStatusBarLayout.setHorizontalGroup(
            pnStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnStatusBarLayout.createSequentialGroup()
                .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnStatusBarLayout.setVerticalGroup(
            pnStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btAddFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddFilesActionPerformed
        
        JFileChooser fc = new JFileChooser();
        
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setMultiSelectionEnabled(true);        
        fc.setCurrentDirectory(currentDir);
                
        int res = fc.showOpenDialog(this);

        if(res == JFileChooser.APPROVE_OPTION) {

            new Thread(() -> {
                for(File path : fc.getSelectedFiles()){
                    addPath(path);        
                }

                showPaths();
                showFiles();
                enableButtons();
            }).start();
            
            currentDir = fc.getCurrentDirectory();
        }

//        addPath(new File("/home/gowl/Escola/Entregas/bd/Trabalho-Banco-de-Dados-ETEC-2020-07"));
//                showPaths();
//                showFiles();      
//                enableButtons();

    }//GEN-LAST:event_btAddFilesActionPerformed

    private void btCompareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompareActionPerformed
        comparisons.getConfig().setExtentions(tbExtensions.getText());

        new Thread(() -> {
            comparisons.make();
            List<FilesSimilarity> similarities = comparisons.getComparisons();
            tableModel.setRowCount(similarities.size());
          
            int i = 0;            
            for(FilesSimilarity s : similarities) {
                tableModel.setValueAt(String.format("%5.2f%%", s.getSimilarity()*100), i, 0);
                tableModel.setValueAt(s.getDoc1Size(), i, 1);
                tableModel.setValueAt(s.getDoc2Size(), i, 2);
                tableModel.setValueAt(s.getDistance(), i, 3);
                tableModel.setValueAt(s.getDoc1().getSimpleName(), i, 4);
                tableModel.setValueAt(s.getDoc2().getSimpleName(), i, 5);
                i++;
            }
            
            enableButtons();        
        }).start();
        
    }//GEN-LAST:event_btCompareActionPerformed

    private void btSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSettingsActionPerformed
      
        comparisons.getConfig().setExtentions(tbExtensions.getText());
        
        DgSettings dg = new DgSettings(this, true, comparisons.getConfig());
        dg.setVisible(true);
        
        tbExtensions.setText(comparisons.getConfig().getExtensions());
        
        showPaths();
        showFiles();
    }//GEN-LAST:event_btSettingsActionPerformed

    private void btBlameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBlameActionPerformed
        
        DgBlame f = new DgBlame(this, true, comparisons);
        f.setSize(1000, 600);
        f.setVisible(true);
    }//GEN-LAST:event_btBlameActionPerformed

    private void btFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFilterActionPerformed
        comparisons.getConfig().setExtentions(tbExtensions.getText());
        
        showPaths();
        showFiles();
    }//GEN-LAST:event_btFilterActionPerformed

    private void btExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setSelectedFile(new File("Comparisons.csv"));
        
        String[] extensions = {"csv"};
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return FileUtils.checkExtention(file, extensions) || file.isDirectory();
            }

            @Override
            public String getDescription() {
                return "csv";
            }
        });
        
        int res = fc.showSaveDialog(this);

        if(res == JFileChooser.APPROVE_OPTION) {
            FileUtils.saveFile(fc.getSelectedFile(), comparisons.toCSV());
        }
        
    }//GEN-LAST:event_btExportActionPerformed

    
    
    
    private Comparisons comparisons;

    public Comparisons getComparisons() {
        return comparisons;
    }

    public void setComparisons(Comparisons comparisons) {
        this.comparisons = comparisons;
        
//        addPath(new File("files/files1"));
//        addPath(new File("files/files2"));

        
                
        this.comparisons.setMPProcessing(new MessagePrinter() {
            @Override
            public void show(String msg) {
                lbStatus.setText(msg);
            }
        });
        
        this.comparisons.setMPFilesCount(new MessagePrinter() {
            @Override
            public void show(String msg) {
              lbFilesCount.setText(msg);
            }
        });
        
        this.comparisons.setMPCount(new MessagePrinter() {
            @Override
            public void show(String msg) {
                lbComparisonsCount.setText(msg);
            }
        });

        showFiles();
        showPaths();

//        lbFilesCount.setText(comparisons.getDocs().size()+" files"); 
        lbComparisonsCount.setText(comparisons.getComparisons().size() + " comparisons");


    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddFiles;
    private javax.swing.JButton btBlame;
    private javax.swing.JButton btCompare;
    private javax.swing.JButton btExport;
    private javax.swing.JButton btFilter;
    private javax.swing.JButton btSettings;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbComparisonsCount;
    private javax.swing.JLabel lbFilesCount;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JList<String> lsFiles;
    private javax.swing.JList<String> lsPaths;
    private javax.swing.JPanel pnFiles;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnPaths;
    private javax.swing.JPanel pnPathsFiles;
    private javax.swing.JPanel pnSimilarities;
    private javax.swing.JPanel pnStatusBar;
    private javax.swing.JPanel pnToolBar;
    private javax.swing.JSplitPane spMain;
    private javax.swing.JTable tbComparisons;
    private javax.swing.JTextField tbExtensions;
    private javax.swing.JTabbedPane tpPaths;
    // End of variables declaration//GEN-END:variables
}
