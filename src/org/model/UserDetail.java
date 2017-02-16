package org.model;

/**
 * UserDetail entity. @author MyEclipse Persistence Tools
 */

public class UserDetail implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String email;
	private Long userId;

	// Constructors

	/** default constructor */
	public UserDetail() {
	}

	/** minimal constructor */
	public UserDetail(Long userId) {
		this.userId = userId;
	}

	/** full constructor */
	public UserDetail(String name, String email, Long userId) {
		this.name = name;
		this.email = email;
		this.userId = userId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}