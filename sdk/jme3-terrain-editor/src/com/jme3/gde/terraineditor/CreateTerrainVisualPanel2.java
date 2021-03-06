/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.terraineditor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class CreateTerrainVisualPanel2 extends JPanel {

    //String[] types = {"Flat", "Image Based", "Hill", "Fault Fractal"};


    /** Creates new form CreateTerrainVisualPanel2 */
    public CreateTerrainVisualPanel2() {
        initComponents();
        
        _flatPanel.setVisible(true);
        _imagePanel.setVisible(false);
        _hillPanel.setVisible(false);
        _faultPanel.setVisible(false);
        this.validate();
    }

    @Override
    public String getName() {
        return "Heightmap";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageFileChooser = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        heightmapTypeComboBox = new javax.swing.JComboBox();
        _flatPanel = new javax.swing.JPanel();
        _flatDescriptionLabel = new javax.swing.JLabel();
        _imagePanel = new javax.swing.JPanel();
        _imageDescriptionLabel = new javax.swing.JLabel();
        _imageBrowseTextField = new javax.swing.JTextField();
        _imageBrowseButton = new javax.swing.JButton();
        _hillPanel = new javax.swing.JPanel();
        _hillDescriptionLabel = new javax.swing.JLabel();
        _hillIterationsTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        _hillFlatteningTextField = new javax.swing.JTextField();
        _hillMinRadiusTextField = new javax.swing.JTextField();
        _hillMaxRadiusTextField = new javax.swing.JTextField();
        _faultPanel = new javax.swing.JPanel();
        _faultDescriptionLabel = new javax.swing.JLabel();

        imageFileChooser.setApproveButtonText(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2.imageFileChooser.approveButtonText")); // NOI18N
        imageFileChooser.setApproveButtonToolTipText(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2.imageFileChooser.approveButtonToolTipText")); // NOI18N
        imageFileChooser.setCurrentDirectory(new java.io.File("C:\\Java\\NetBeans 6.9.1"));
        imageFileChooser.setDialogTitle(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2.imageFileChooser.dialogTitle")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2.jLabel1.text")); // NOI18N

        heightmapTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Flat", "Image Based", "Hill" }));
        heightmapTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightmapTypeComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(_flatDescriptionLabel, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._flatDescriptionLabel.text")); // NOI18N

        javax.swing.GroupLayout _flatPanelLayout = new javax.swing.GroupLayout(_flatPanel);
        _flatPanel.setLayout(_flatPanelLayout);
        _flatPanelLayout.setHorizontalGroup(
            _flatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_flatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_flatDescriptionLabel)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        _flatPanelLayout.setVerticalGroup(
            _flatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_flatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_flatDescriptionLabel)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(_imageDescriptionLabel, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._imageDescriptionLabel.text")); // NOI18N

        _imageBrowseTextField.setText(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._imageBrowseTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(_imageBrowseButton, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._imageBrowseButton.text")); // NOI18N
        _imageBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _imageBrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout _imagePanelLayout = new javax.swing.GroupLayout(_imagePanel);
        _imagePanel.setLayout(_imagePanelLayout);
        _imagePanelLayout.setHorizontalGroup(
            _imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_imagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(_imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(_imagePanelLayout.createSequentialGroup()
                        .addComponent(_imageBrowseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_imageBrowseButton))
                    .addComponent(_imageDescriptionLabel))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        _imagePanelLayout.setVerticalGroup(
            _imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_imagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_imageDescriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(_imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_imageBrowseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_imageBrowseButton))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(_hillDescriptionLabel, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._hillDescriptionLabel.text")); // NOI18N

        _hillIterationsTextField.setText(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._hillIterationsTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2.jLabel5.text")); // NOI18N

        _hillFlatteningTextField.setText(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._hillFlatteningTextField.text")); // NOI18N

        _hillMinRadiusTextField.setText(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._hillMinRadiusTextField.text")); // NOI18N

        _hillMaxRadiusTextField.setText(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._hillMaxRadiusTextField.text")); // NOI18N

        javax.swing.GroupLayout _hillPanelLayout = new javax.swing.GroupLayout(_hillPanel);
        _hillPanel.setLayout(_hillPanelLayout);
        _hillPanelLayout.setHorizontalGroup(
            _hillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_hillPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(_hillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_hillDescriptionLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, _hillPanelLayout.createSequentialGroup()
                        .addGroup(_hillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, _hillPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(_hillFlatteningTextField))
                            .addGroup(_hillPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(_hillIterationsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(_hillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(_hillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(_hillMinRadiusTextField)
                    .addComponent(_hillMaxRadiusTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        _hillPanelLayout.setVerticalGroup(
            _hillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_hillPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_hillDescriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(_hillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_hillIterationsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(_hillMinRadiusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(_hillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(_hillFlatteningTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(_hillMaxRadiusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(_faultDescriptionLabel, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel2.class, "CreateTerrainVisualPanel2._faultDescriptionLabel.text")); // NOI18N

        javax.swing.GroupLayout _faultPanelLayout = new javax.swing.GroupLayout(_faultPanel);
        _faultPanel.setLayout(_faultPanelLayout);
        _faultPanelLayout.setHorizontalGroup(
            _faultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_faultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_faultDescriptionLabel)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        _faultPanelLayout.setVerticalGroup(
            _faultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_faultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_faultDescriptionLabel)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(_hillPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_flatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heightmapTypeComboBox, 0, 428, Short.MAX_VALUE)
                    .addComponent(_faultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(heightmapTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(_flatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_hillPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_faultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = imageFileChooser.showOpenDialog(this);
        if (returnVal == imageFileChooser.APPROVE_OPTION) {
            File file = imageFileChooser.getSelectedFile();
            //try {
              // What to do with the file, e.g. display it in a TextArea
            _imageBrowseTextField.setText( file.getAbsolutePath() );
            //} catch (IOException ex) {
            //  System.out.println("problem accessing file"+file.getAbsolutePath());
            //}
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void heightmapTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightmapTypeComboBoxActionPerformed
        if ("Flat".equals(heightmapTypeComboBox.getSelectedItem()) ) {
            _flatPanel.setVisible(true);
            _imagePanel.setVisible(false);
            _hillPanel.setVisible(false);
            _faultPanel.setVisible(false);
        }
        else if ("Image Based".equals(heightmapTypeComboBox.getSelectedItem()) ) {
            _flatPanel.setVisible(false);
            _imagePanel.setVisible(true);
            _hillPanel.setVisible(false);
            _faultPanel.setVisible(false);
        }
        else if ("Hill".equals(heightmapTypeComboBox.getSelectedItem()) ) {
            _flatPanel.setVisible(false);
            _imagePanel.setVisible(false);
            _hillPanel.setVisible(true);
            _faultPanel.setVisible(false);
        }
        else if ("Fault Fractal".equals(heightmapTypeComboBox.getSelectedItem()) ) {
            _flatPanel.setVisible(false);
            _imagePanel.setVisible(false);
            _hillPanel.setVisible(false);
            _faultPanel.setVisible(true);
        }

        this.validate();
    }//GEN-LAST:event_heightmapTypeComboBoxActionPerformed

    private void _imageBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__imageBrowseButtonActionPerformed
        openFileActionPerformed(evt);
    }//GEN-LAST:event__imageBrowseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _faultDescriptionLabel;
    private javax.swing.JPanel _faultPanel;
    private javax.swing.JLabel _flatDescriptionLabel;
    private javax.swing.JPanel _flatPanel;
    private javax.swing.JLabel _hillDescriptionLabel;
    private javax.swing.JTextField _hillFlatteningTextField;
    private javax.swing.JTextField _hillIterationsTextField;
    private javax.swing.JTextField _hillMaxRadiusTextField;
    private javax.swing.JTextField _hillMinRadiusTextField;
    private javax.swing.JPanel _hillPanel;
    private javax.swing.JButton _imageBrowseButton;
    private javax.swing.JTextField _imageBrowseTextField;
    private javax.swing.JLabel _imageDescriptionLabel;
    private javax.swing.JPanel _imagePanel;
    private javax.swing.JComboBox heightmapTypeComboBox;
    private javax.swing.JFileChooser imageFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public JComboBox getHeightmapTypeComboBox() {
        return heightmapTypeComboBox;
    }

    public JTextField getHillFlatteningTextField() {
        return _hillFlatteningTextField;
    }

    public JTextField getHillIterationsTextField() {
        return _hillIterationsTextField;
    }

    public JTextField getHillMaxRadiusTextField() {
        return _hillMaxRadiusTextField;
    }

    public JTextField getHillMinRadiusTextField() {
        return _hillMinRadiusTextField;
    }

    public JTextField getImageBrowseTextField() {
        return _imageBrowseTextField;
    }

    
}
