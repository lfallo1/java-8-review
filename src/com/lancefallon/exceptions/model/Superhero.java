package com.lancefallon.exceptions.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Superhero implements Serializable {

	private static final long serialVersionUID = 4244973572026371256L;
	
	private final Integer id;
	private final String alias;
	private final String firstName;
	private final String lastName;
	private final Set<Suit> suits;
	
	public Superhero(Integer id){
		this.id = id;
		this.alias = "";
		this.firstName = "";
		this.lastName = "";
		suits = new HashSet<>();
	}

	public Superhero(Integer id, String alias, String firstName, String lastName) {
		this.id = id;
		this.alias = alias;
		this.firstName = firstName;
		this.lastName = lastName;
		suits = new HashSet<>();
	}
	
	public void addSuit(Suit suit){
		suits.add(suit);
	}

	public Integer getId() {
		return id;
	}

	public String getAlias() {
		return alias;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Set<Suit> getSuits() {
		return new HashSet<>(suits);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Superhero other = (Superhero) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Superhero [id=" + id + ", alias=" + alias + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", suits=" + suits + "]";
	}

}
