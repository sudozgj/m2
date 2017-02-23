package org.view;

/**
 * VFileId entity. @author MyEclipse Persistence Tools
 */

public class VFileId implements java.io.Serializable {

	// Fields

	private Long id;
	private String username;
	private String filename;
	private String dir;
	private String url;
	private String time;

	// Constructors

	/** default constructor */
	public VFileId() {
	}

	/** minimal constructor */
	public VFileId(Long id, String username, String filename, String dir,
			String url) {
		this.id = id;
		this.username = username;
		this.filename = filename;
		this.dir = dir;
		this.url = url;
	}

	/** full constructor */
	public VFileId(Long id, String username, String filename, String dir,
			String url, String time) {
		this.id = id;
		this.username = username;
		this.filename = filename;
		this.dir = dir;
		this.url = url;
		this.time = time;
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

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VFileId))
			return false;
		VFileId castOther = (VFileId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getFilename() == castOther.getFilename()) || (this
						.getFilename() != null
						&& castOther.getFilename() != null && this
						.getFilename().equals(castOther.getFilename())))
				&& ((this.getDir() == castOther.getDir()) || (this.getDir() != null
						&& castOther.getDir() != null && this.getDir().equals(
						castOther.getDir())))
				&& ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
						&& castOther.getUrl() != null && this.getUrl().equals(
						castOther.getUrl())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getFilename() == null ? 0 : this.getFilename().hashCode());
		result = 37 * result
				+ (getDir() == null ? 0 : this.getDir().hashCode());
		result = 37 * result
				+ (getUrl() == null ? 0 : this.getUrl().hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		return result;
	}

}