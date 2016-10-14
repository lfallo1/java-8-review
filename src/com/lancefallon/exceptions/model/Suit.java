package com.lancefallon.exceptions.model;

import java.io.Serializable;

public class Suit implements Serializable {
	
	private static final long serialVersionUID = 6683519698344637335L;
	
	private final Integer id;
	private final String material;
	private final String color;
	private final Integer superheroId;

	public Suit(Integer id, String material, String color, Integer superheroId) {
		this.id = id;
		this.material = material;
		this.color = color;
		this.superheroId = superheroId;
	}

	public Integer getId() {
		return id;
	}

	public String getMaterial() {
		return material;
	}

	public String getColor() {
		return color;
	}
	
	public Integer getSuperheroId(){
		return superheroId;
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
		Suit other = (Suit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Suit [id=" + id + ", material=" + material + ", color=" + color + "]";
	}

}
