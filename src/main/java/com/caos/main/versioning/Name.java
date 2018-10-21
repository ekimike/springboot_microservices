package com.caos.main.versioning;

public class Name {

	private String firsName;
	private String lastName;
	
	public Name() {}

	protected Name(String firsName, String lastName) {
		super();
		this.firsName = firsName;
		this.lastName = lastName;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
