package org.view;

/**
 * VFile entity. @author MyEclipse Persistence Tools
 */

public class VFile implements java.io.Serializable {

	// Fields

	private VFileId id;

	// Constructors

	/** default constructor */
	public VFile() {
	}

	/** full constructor */
	public VFile(VFileId id) {
		this.id = id;
	}

	// Property accessors

	public VFileId getId() {
		return this.id;
	}

	public void setId(VFileId id) {
		this.id = id;
	}

}