package pawan_practice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRepoPOJO {
	
	private String name;
	
	@JsonProperty(value="private")
	private boolean privateVa;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrivateVa() {
		return privateVa;
	}

	public void setPrivateVa(boolean privateVa) {
		this.privateVa = privateVa;
	}
	
	

}
