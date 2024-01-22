package com.delume.domain.enums;

public enum Position {
	
	HEALTH(1, "Health"),
	ADMINISTRATIVE(2, "Administrative"),
	FINANCIAL(3, "Financial"),
	RECEPTIONIST(4, "Receptionist");
	
	private int cod;
	private String description;
	
	Position(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getdescription() {
		return description;
	}

	public static Position toEnum(String description) {
		if(description == null) {
			return null;
		}
		
		for(Position x : Position.values()) {
			if(description.equals(x.getdescription())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + description);
	}
}
