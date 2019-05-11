package com.tylert.harmony.launcher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 * Game Model class, represents a game in the user's computer
 * 
 * @author tyler
 *
 */
@Entity
@NamedQuery(name = "find_all_games", query = "select g from GameModel g")
public class GameModel {

	/** ID used by JPA */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/** name of the game */
	@NotNull
	private String name;

	/** location of the game on disk */
	@Column(unique = true)
	@NotNull
	private String location;
	
	/** Parent launcher or company of the game */
	@NotNull
	private String parent;

	/**
	 * Protected Constructor for use by JPA
	 */
	public GameModel() {}

	/**
	 * Constructor
	 * 
	 * @param name     name of the game
	 * @param location location of the game on disk
	 */
	public GameModel(String name, String location, String parent) {
		super();
		this.name = name;
		this.location = location;
		this.parent = parent;
	}

	// ACCESSORS
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}
	
	public String getParent() {
		return parent;
	}

	// MUTATORS
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setParent(String parent) {
		this.parent = parent;
	}
}
