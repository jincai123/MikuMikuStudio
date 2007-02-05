/*
 * Copyright (c) 2003-2007 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors 
 *   may be used to endorse or promote products derived from this software 
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme.util;

import com.jme.animation.Bone;
import com.jme.animation.SkinNode;
import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.renderer.Renderer;
import com.jme.scene.Node;
import com.jme.scene.Spatial;
import com.jme.scene.shape.Cylinder;
import com.jme.scene.shape.Sphere;
import com.jme.scene.state.LightState;
import com.jme.scene.state.TextureState;
import com.jme.scene.state.ZBufferState;

public final class BoneDebugger {

    private static Sphere boneSphere = new Sphere("boneSphere", new Vector3f(), 6, 6, .065f);
    private static Cylinder boneCylinder = new Cylinder("boneCylinder", 3, 8, .015f, 1f);
    static {
        boneSphere.getBatch(0).setLightCombineMode(LightState.OFF);
        boneSphere.getBatch(0).setTextureCombineMode(TextureState.OFF);
        boneSphere.getBatch(0).setSolidColor(ColorRGBA.red);
        boneSphere.getBatch(0).setRenderQueueMode(Renderer.QUEUE_SKIP);

        boneCylinder.getBatch(0).setLightCombineMode(LightState.OFF);
        boneCylinder.getBatch(0).setTextureCombineMode(TextureState.OFF);
        boneCylinder.getBatch(0).setSolidColor(ColorRGBA.white);
        boneCylinder.getBatch(0).setRenderQueueMode(Renderer.QUEUE_SKIP);
    }

    private static boolean inited = false;
    private static Vector3f tempTrans = new Vector3f();
    private static Quaternion tempRot = new Quaternion();
    private static Quaternion tempQ = new Quaternion();
    private static Vector3f tempA = new Vector3f();
    private static Vector3f tempB = new Vector3f();
    private static Vector3f tempC = new Vector3f();
    private static Vector3f tempD = new Vector3f();

    public static void drawBones(Spatial spat, Renderer r) {
        drawBones(spat, r, true);
    }

    public static void drawBones(Spatial spat, Renderer r, boolean drawChildren) {
        if (!inited) {
            TextureState noTextureState = r.createTextureState();
            noTextureState.setEnabled(false);
            boneSphere.getBatch(0).setRenderState(noTextureState);
            boneCylinder.getBatch(0).setRenderState(noTextureState);
            
            ZBufferState noBufferState = r.createZBufferState();
            noBufferState.setEnabled(true);
            noBufferState.setWritable(true);
            noBufferState.setFunction(ZBufferState.CF_ALWAYS);
            boneSphere.getBatch(0).setRenderState(noBufferState);
            boneCylinder.getBatch(0).setRenderState(noBufferState);

            boneSphere.updateRenderState();
            boneSphere.updateGeometricState(0, false);
            boneCylinder.updateRenderState();
            boneCylinder.updateGeometricState(0, false);
            boneSphere.lockMeshes();
            boneCylinder.lockMeshes();
            inited = true;
        }
        
        if (spat instanceof SkinNode) {
            drawSkinBones((SkinNode)spat, r);
        }
        
        if (spat instanceof Bone) {
            drawTheBones(null, (Bone)spat, r);
        }

        if ((spat instanceof Node) && drawChildren) {
            Node n = (Node) spat;
            for (int x = 0, count = n.getQuantity(); x < count; x++) {
                drawBones(n.getChild(x), r, true);
            }
        }
    }

    private static void drawSkinBones(SkinNode node, Renderer r) {
        for (int x = node.getSkeletons().size(); --x >= 0; ) {
            drawTheBones(node.getSkin(), node.getSkeletons().get(x), r);
        }
    }
    
    private static void drawTheBones(Spatial skin, Bone bone, Renderer r) {
        if(skin == null) {
            tempTrans.set(0,0,0);
            tempRot.set(0, 0, 0, 1);
        } else {
            tempTrans.set(skin.getWorldTranslation());
            tempRot.set(skin.getWorldRotation());
        }
        
        boneSphere.getWorldTranslation().set(tempTrans).addLocal(tempRot.mult(bone.getWorldTranslation(), tempA).multLocal(bone.getWorldScale()));
        boneSphere.getWorldRotation().set(tempRot).multLocal(bone.getWorldRotation());
        
        boneSphere.getBatch(0).draw(r);
        
        Vector3f here = tempA;
        Vector3f there = tempB;
        Vector3f diff = tempC;

        for (int x = 0, count = bone.getQuantity(); x < count; x++) {
            Spatial child = bone.getChild(x);
            if (child instanceof Bone) {
                bone.localToWorld(Vector3f.ZERO, here);
                child.localToWorld(Vector3f.ZERO, there);
                diff.set(there).subtractLocal(here);
                
                float distance = here.distance(there);
                
                boneCylinder.getWorldScale().set(1, 1, distance);
                boneCylinder.getWorldTranslation().set(diff).multLocal(0.5f).addLocal(here);
                tempD.set(boneCylinder.getWorldTranslation());
                boneCylinder.getWorldTranslation().set(tempTrans).addLocal(tempRot.mult(tempD, tempD));

                diff.normalizeLocal();
                boneCylinder.getWorldRotation().set(bone.getWorldRotation()).lookAt(diff, Vector3f.UNIT_Z);
                tempQ.set(boneCylinder.getWorldRotation());
                boneCylinder.getWorldRotation().set(tempRot).multLocal(tempQ);


                boneCylinder.getBatch(0).draw(r);
                drawTheBones(skin, (Bone)child, r);
            }
        }
    }

}
