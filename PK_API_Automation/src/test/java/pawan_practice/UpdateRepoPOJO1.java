package pawan_practice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRepoPOJO1 {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty(value = "private")
	private boolean privateValue;

	public boolean isPrivateValue() {
		return privateValue;
	}

	public void setPrivateValue(boolean privateValue) {
		this.privateValue = privateValue;
	}

}
