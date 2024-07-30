package com.ad.employee.utils;

public enum EmpStatus {
	FT ("Full Time"),
	PT ("Part Time"),
	CON ("Contractual");
	
	private final String name;       

    private EmpStatus(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    @Override
	public String toString() {
       return this.name;
    }
    
    public static EmpStatus fromString(String name) {
        for (EmpStatus ele : EmpStatus.values()) {
            if (ele.equalsName(name)) {
                return ele;
            }
        }
        
        throw new IllegalArgumentException("No enum constant with name " + name);
    }
}
