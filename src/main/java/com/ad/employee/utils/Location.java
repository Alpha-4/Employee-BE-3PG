package com.ad.employee.utils;

public enum Location {
	UK ("UK"),
	US ("USA"),
	IND ("India"),
	AUS ("Sydney Office");
	
	private final String name;       

    private Location(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    @Override
	public String toString() {
       return this.name;
    }
    
    public static Location fromString(String name) {
        for (Location ele : Location.values()) {
            if (ele.equalsName(name)) {
                return ele;
            }
        }
        
        throw new IllegalArgumentException("No enum constant with name " + name);
    }
}
