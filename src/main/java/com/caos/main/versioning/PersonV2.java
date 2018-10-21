package com.caos.main.versioning;

public class PersonV2 {

	private Name name;

	protected PersonV2(Name name) {
		super();
		this.name = name;
	}
	
	protected PersonV2() {
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	
	
}
