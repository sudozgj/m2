package org.model;

/**
 * Fileio entity. @author MyEclipse Persistence Tools
 */

public class Fileio implements java.io.Serializable {

	// Fields

	private Long id;
	private String username;
	private String filename;
	private Long time;
	private String dir;
	private String url;

	// Constructors

	/** default constructor */
	public Fileio() {
	}

	/** full constructor */
	public Fileio(String username, String filename, Long time, String dir,
			String url) {
		this.username = username;
		this.filename = filename;
		this.time = time;
		this.dir = dir;
		this.url = url;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getDir() {
		return this.dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}