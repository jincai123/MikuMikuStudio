/*
 * Copyright (c) 2009-2010 jMonkeyEngine All rights reserved. <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. <p/> * Redistributions
 * in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. <p/> * Neither the name of
 * 'jMonkeyEngine' nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written
 * permission. <p/> THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.gde.core.sceneviewer;

import com.jme3.gde.core.filters.FilterExplorerTopComponent;
import com.jme3.gde.core.scene.SceneApplication;
import com.jme3.gde.core.scene.SceneRequest;
import com.jme3.input.awt.AwtKeyInput;
import com.jme3.input.event.KeyInputEvent;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.openide.util.ImageUtilities;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.NotifyDescriptor.Message;
import org.openide.awt.UndoRedo;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.jme3.gde.core.sceneviewer//SceneViewer//EN",
autostore = false)
public final class SceneViewerTopComponent extends TopComponent {

    private static SceneViewerTopComponent instance;
    /**
     * path to the icon used by the component and its open action
     */
    static final String ICON_PATH = "com/jme3/gde/core/sceneviewer/jme-logo.png";
    private static final String PREFERRED_ID = "SceneViewerTopComponent";
    private SceneApplication app;
    private HelpCtx helpContext = new HelpCtx("com.jme3.gde.core.sceneviewer");
//    private Canvas oglCanvas;
    private Component oglCanvas;

    public SceneViewerTopComponent() {
        initComponents();
        oGLPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        setFocusable(true);
        setName(NbBundle.getMessage(SceneViewerTopComponent.class, "CTL_SceneViewerTopComponent"));
        setToolTipText(NbBundle.getMessage(SceneViewerTopComponent.class, "HINT_SceneViewerTopComponent"));
        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        try {
            app = SceneApplication.getApplication();
//            oglCanvas = ((JmeCanvasContext) app.getContext()).getCanvas();
            oglCanvas = app.getMainPanel();
            oGLPanel.add(oglCanvas);

        } catch (Exception e) {
            Exceptions.printStackTrace(e);
            showOpenGLError(e.toString());
        } catch (Error err) {
            Exceptions.printStackTrace(err);
            showOpenGLError(err.toString());
        }

        //We add a mouse wheel listener to the top conmponent in order to correctly dispatch the event ot the cam controller
        //the oGLPanel may naver have the focus.
        addMouseWheelListener(new MouseWheelListener() {

            public void mouseWheelMoved(MouseWheelEvent e) {
                String action = "MouseWheel-";
                if (e.getWheelRotation() < 0) {
                    action = "MouseWheel";
                }
                app.getActiveCameraController().onAnalog(action, e.getWheelRotation(), 0);
            }
        });
        addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent evt) {
            }

            public void keyPressed(KeyEvent evt) {
                int code = AwtKeyInput.convertAwtKey(evt.getKeyCode());
                KeyInputEvent keyEvent = new KeyInputEvent(code, evt.getKeyChar(), true, false);
                keyEvent.setTime(evt.getWhen());
                if (app.getActiveCameraController() != null) {
                    app.getActiveCameraController().onKeyEvent(keyEvent);
                }
            }

            public void keyReleased(KeyEvent evt) {
                int code = AwtKeyInput.convertAwtKey(evt.getKeyCode());
                KeyInputEvent keyEvent = new KeyInputEvent(code, evt.getKeyChar(), false, false);
                keyEvent.setTime(evt.getWhen());
                if (app.getActiveCameraController() != null) {
                    app.getActiveCameraController().onKeyEvent(keyEvent);
                }
            }
        });

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        enableCamLight = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        enableWireframe = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        enableStats = new javax.swing.JToggleButton();
        oGLPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);

        enableCamLight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/core/sceneviewer/icons/lightbulb_off.gif"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(enableCamLight, org.openide.util.NbBundle.getMessage(SceneViewerTopComponent.class, "SceneViewerTopComponent.enableCamLight.text")); // NOI18N
        enableCamLight.setToolTipText(org.openide.util.NbBundle.getMessage(SceneViewerTopComponent.class, "SceneViewerTopComponent.enableCamLight.toolTipText")); // NOI18N
        enableCamLight.setFocusable(false);
        enableCamLight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        enableCamLight.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/core/sceneviewer/icons/lightbulb.gif"))); // NOI18N
        enableCamLight.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        enableCamLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableCamLightActionPerformed(evt);
            }
        });
        jToolBar1.add(enableCamLight);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/core/filters/icons/eye.gif"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jToggleButton1, org.openide.util.NbBundle.getMessage(SceneViewerTopComponent.class, "SceneViewerTopComponent.jToggleButton1.text")); // NOI18N
        jToggleButton1.setToolTipText(org.openide.util.NbBundle.getMessage(SceneViewerTopComponent.class, "SceneViewerTopComponent.jToggleButton1.toolTipText")); // NOI18N
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton1);
        jToolBar1.add(jSeparator1);

        enableWireframe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/core/sceneviewer/icons/box_color.gif"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(enableWireframe, org.openide.util.NbBundle.getMessage(SceneViewerTopComponent.class, "SceneViewerTopComponent.enableWireframe.text")); // NOI18N
        enableWireframe.setToolTipText(org.openide.util.NbBundle.getMessage(SceneViewerTopComponent.class, "SceneViewerTopComponent.enableWireframe.toolTipText")); // NOI18N
        enableWireframe.setFocusable(false);
        enableWireframe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        enableWireframe.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/core/sceneviewer/icons/box_wire.gif"))); // NOI18N
        enableWireframe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        enableWireframe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableWireframeActionPerformed(evt);
            }
        });
        jToolBar1.add(enableWireframe);
        jToolBar1.add(jPanel1);

        enableStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/core/sceneviewer/icons/65.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(enableStats, org.openide.util.NbBundle.getMessage(SceneViewerTopComponent.class, "SceneViewerTopComponent.enableStats.text")); // NOI18N
        enableStats.setToolTipText(org.openide.util.NbBundle.getMessage(SceneViewerTopComponent.class, "SceneViewerTopComponent.enableStats.toolTipText")); // NOI18N
        enableStats.setFocusable(false);
        enableStats.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        enableStats.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        enableStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableStatsActionPerformed(evt);
            }
        });
        jToolBar1.add(enableStats);

        add(jToolBar1, java.awt.BorderLayout.NORTH);

        oGLPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        oGLPanel.setLayout(new java.awt.GridLayout(1, 0));
        add(oGLPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void enableCamLightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableCamLightActionPerformed
        app.enableCamLight(enableCamLight.isSelected());
    }//GEN-LAST:event_enableCamLightActionPerformed

    private void enableWireframeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableWireframeActionPerformed
        app.enableWireFrame(enableWireframe.isSelected());
    }//GEN-LAST:event_enableWireframeActionPerformed

    private void enableStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableStatsActionPerformed
        app.enableStats(enableStats.isSelected());
    }//GEN-LAST:event_enableStatsActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        FilterExplorerTopComponent.findInstance().setFilterEnabled(jToggleButton1.isSelected());
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton enableCamLight;
    private javax.swing.JToggleButton enableStats;
    private javax.swing.JToggleButton enableWireframe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel oGLPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized SceneViewerTopComponent getDefault() {
        if (instance == null) {
            instance = new SceneViewerTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the SceneViewerTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized SceneViewerTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(SceneViewerTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof SceneViewerTopComponent) {
            return (SceneViewerTopComponent) win;
        }
        Logger.getLogger(SceneViewerTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    public static void showOpenGLError(String e) {
        Message msg = new NotifyDescriptor.Message(
                "Error opening OpenGL window!\n"
                + "Error: " + e,
                NotifyDescriptor.ERROR_MESSAGE);
        DialogDisplayer.getDefault().notifyLater(msg);
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public HelpCtx getHelpCtx() {
        //this call is for single components:
        //HelpCtx.setHelpIDString(this, "com.jme3.gde.core.sceneviewer");
        return helpContext;
    }

    public void setHelpContext(HelpCtx ctx) {
        this.helpContext = ctx;
    }

    @Override
    public void componentOpened() {
        super.componentOpened();
//        oglCanvas.setActiveUpdates(true);
    }

    @Override
    protected void componentShowing() {
        super.componentShowing();
    }

    @Override
    protected void componentHidden() {
        super.componentHidden();
    }

    @Override
    public void componentClosed() {
        super.componentClosed();
//        oglCanvas.setActiveUpdates(false);
        SceneRequest req = SceneApplication.getApplication().getCurrentSceneRequest();
        if (req != null) {
            SceneApplication.getApplication().closeScene(req);
        }
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    @Override
    public UndoRedo getUndoRedo() {
        return Lookup.getDefault().lookup(UndoRedo.class);
    }
}
