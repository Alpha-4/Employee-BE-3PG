package com.ad.employee.utils;


public enum Department {
	ADMIN ("Administration"),
	TECH ("Technology"),
	ACC ("Accounts"),
	MANAGE ("Management");
	
	private final String name;       

    private Department(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    @Override
	public String toString() {
       return this.name;
    }
    
    public static Department fromString(String name) {
        for (Department ele : Department.values()) {
            if (ele.equalsName(name)) {
                return ele;
            }
        }
        
        throw new IllegalArgumentException("No enum constant with name " + name);
    }
	
}
