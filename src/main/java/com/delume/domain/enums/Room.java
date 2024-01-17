package com.delume.domain.enums;

public enum Room {
	
	TYPEONE(1, "TypeOne"),
	TYPETWO(2, "TypeTwo"),
	TYPETHREE(3, "TypeThree"),
	TYPEFOUR(4, "TypeFour");
	
	private int cod;
	private String description;
	
	Room(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getdescription() {
		return description;
	}

	public static Room toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Room x : Room.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
