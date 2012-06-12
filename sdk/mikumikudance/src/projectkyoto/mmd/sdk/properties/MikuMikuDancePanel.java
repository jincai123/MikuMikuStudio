/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkyoto.mmd.sdk.properties;

import projectkyoto.mmd.sdk.MikuMikuDanceSupport;
import org.openide.util.NbPreferences;

final class MikuMikuDancePanel extends javax.swing.JPanel {

    private final MikuMikuDanceOptionsPanelController controller;

    MikuMikuDancePanel(MikuMikuDanceOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        // TODO listen to changes in form fields and call controller.changed()
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        glslSkinningCheckBox = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(glslSkinningCheckBox, org.openide.util.NbBundle.getMessage(MikuMikuDancePanel.class, "MikuMikuDancePanel.glslSkinningCheckBox.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(glslSkinningCheckBox)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(glslSkinningCheckBox)
                .addContainerGap(149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    void load() {
        // TODO read settings and initialize GUI
        // Example:        
        // someCheckBox.setSelected(Preferences.userNodeForPackage(MikuMikuDancePanel.class).getBoolean("someFlag", false));
        // or for org.openide.util with API spec. version >= 7.4:
        // someCheckBox.setSelected(NbPreferences.forModule(MikuMikuDancePanel.class).getBoolean("someFlag", false));
        // or:
        // someTextField.setText(SomeSystemOption.getDefault().getSomeStringProperty());
        glslSkinningCheckBox.setSelected(MikuMikuDanceSupport.isGlslSkinningEnabled());
    }

    void store() {
        // TODO store modified settings
        // Example:
        // Preferences.userNodeForPackage(MikuMikuDancePanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or for org.openide.util with API spec. version >= 7.4:
        // NbPreferences.forModule(MikuMikuDancePanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or:
        // SomeSystemOption.getDefault().setSomeStringProperty(someTextField.getText());
        MikuMikuDanceSupport.setGlslSkinningEnabled(glslSkinningCheckBox.isSelected());
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox glslSkinningCheckBox;
    // End of variables declaration//GEN-END:variables
}