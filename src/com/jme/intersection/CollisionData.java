/*
 * Copyright (c) 2003-2004, jMonkeyEngine - Mojo Monkey Coding
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of the Mojo Monkey Coding, jME, jMonkey Engine, nor the
 * names of its contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.jme.intersection;

import java.util.ArrayList;

import com.jme.scene.TriMesh;

/**
 * CollisionData contains information about a collision between two TriMesh
 * objects. The mesh that was hit by the relevant TriMesh (the one making the
 * collision check) is referenced as well as an ArrayList for the triangles that
 * collided.
 * 
 * @author Mark Powell
 */
public class CollisionData {
	private TriMesh targetMesh;

	private TriMesh sourceMesh;

	private ArrayList sourceTris;

	private ArrayList targetTris;
	
	public CollisionData(TriMesh sourceMesh, TriMesh targetMesh) {
		this(sourceMesh, targetMesh, null, null);
	}

	/**
	 * instantiates a new CollisionData object.
	 * 
	 * @param mesh
	 *            the mesh the relevant TriMesh collided with.
	 * @param source
	 *            the triangles of the relevant TriMesh that made contact.
	 * @param target
	 *            the triangles of the second mesh that made contact.
	 */
	public CollisionData(TriMesh sourceMesh, TriMesh targetMesh,
			ArrayList sourceTris, ArrayList targetTris) {
		this.targetMesh = targetMesh;
		this.sourceMesh = sourceMesh;
		this.targetTris = targetTris;
		this.sourceTris = sourceTris;
	}

	/**
	 * @return Returns the source mesh.
	 */
	public TriMesh getSourceMesh() {
		return sourceMesh;
	}
	
	public TriMesh getTargetMesh() {
		return targetMesh;
	}

	/**
	 * @param mesh
	 *            The mesh to set.
	 */
	public void setSourceMesh(TriMesh mesh) {
		this.sourceMesh = mesh;
	}
	
	public void setTargetMesh(TriMesh mesh) {
		this.targetMesh = mesh;
	}

	/**
	 * @return Returns the source.
	 */
	public ArrayList getSourceTris() {
		return sourceTris;
	}

	/**
	 * @param source
	 *            The source to set.
	 */
	public void setSourceTris(ArrayList source) {
		this.sourceTris = source;
	}

	/**
	 * @return Returns the target.
	 */
	public ArrayList getTargetTris() {
		return targetTris;
	}

	/**
	 * @param target
	 *            The target to set.
	 */
	public void setTargetTris(ArrayList target) {
		this.targetTris = target;
	}
}