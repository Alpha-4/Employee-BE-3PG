package com.ad.employee.utils;

public enum Position {
	SE ("Software Engineer"),
	SSE ("Senior Software Engineer"),
	MA("Manager"),
	QA("QA"),
	DEVOPS("Devops");
	
	private final String name;       

    private Position(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    @Override
	public String toString() {
       return this.name;
    }
    
    public static Position fromString(String name) {
        for (Position ele : Position.values()) {
            if (ele.equalsName(name)) {
                return ele;
            }
        }
        
        throw new IllegalArgumentException("No enum constant with name " + name);
    }
}
