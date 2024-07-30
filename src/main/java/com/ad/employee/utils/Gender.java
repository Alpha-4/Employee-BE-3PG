package com.ad.employee.utils;

public enum Gender {
	MALE ("Male"), 
	FEMALE ("Female");
	
	private final String name;       

    private Gender(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    @Override
	public String toString() {
       return this.name;
    }
    
    
    public static Gender fromString(String name) {
        for (Gender gender : Gender.values()) {
            if (gender.equalsName(name)) {
                return gender;
            }
        }
        
        throw new IllegalArgumentException("No enum constant with name " + name);
    }
}
