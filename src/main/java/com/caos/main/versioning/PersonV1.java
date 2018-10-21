package com.caos.main.versioning;

public class PersonV1 {

	private String name;

	protected PersonV1(String name) {
		super();
		this.name = name;
	}
	
	protected PersonV1() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
