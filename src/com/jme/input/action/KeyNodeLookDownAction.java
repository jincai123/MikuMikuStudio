/*
 * Copyright (c) 2003-2005 jMonkeyEngine
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

package com.jme.input.action;

import com.jme.math.Matrix3f;
import com.jme.math.Vector3f;
import com.jme.scene.Spatial;

/**
 * <code>KeyNodeLookDownAction</code> defines an action to tilt the node
 * towards the node's negative up axis. The rotation is along the node's left
 * vector (the first column of it's rotation matrix).
 * 
 * @author Mark Powell
 * @version $Id: KeyNodeLookDownAction.java,v 1.13 2004/10/14 01:23:01
 *          mojomonkey Exp $
 */
public class KeyNodeLookDownAction extends KeyInputAction {
	//temporary variables to handle rotation
	private static final Matrix3f incr = new Matrix3f();

	private static final Matrix3f tempMa = new Matrix3f();

	private static final Matrix3f tempMb = new Matrix3f();

	private static final Vector3f tempV = new Vector3f();

	//the node to manipulate
	private Spatial node;

	/**
	 * Constructor instatiates a new <code>KeyNodeLookDownAction</code> object
	 * using the supplied node and speed for it's rotation. Speed is multiplied
	 * by the time per frame, providing a frame rate independant speed. Thus,
	 * speed should be considered in (unit/second).
	 * 
	 * @param node
	 *            the node that will be affected by this action.
	 * @param speed
	 *            the speed at which the node can move.
	 */
	public KeyNodeLookDownAction(Spatial node, float speed) {
		this.node = node;
		this.speed = speed;
	}

	/**
	 * <code>performAction</code> rotates the node towards the nodes'
	 * negative up axis at a speed of movement speed * time. Where time is the
	 * time between frames and 1 corresponds to 1 second.
	 * 
	 * @see com.jme.input.action.KeyInputAction#performAction(InputActionEvent)
	 */
	public void performAction(InputActionEvent evt) {
		incr.fromAxisAngle(node.getLocalRotation().getRotationColumn(0, tempV),
				speed * evt.getTime());
		node.getLocalRotation().fromRotationMatrix(
				incr.mult(node.getLocalRotation().toRotationMatrix(tempMa),
						tempMb));
		node.getLocalRotation().normalize();
	}
}