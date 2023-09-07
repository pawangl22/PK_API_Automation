package class_10;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubUpdateRepoPOJO {
	
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPrivateVal() {
		return privateVal;
	}

	public void setPrivateVal(boolean privateVal) {
		this.privateVal = privateVal;
	}

	@JsonProperty(value = "private")
	private boolean privateVal;
	

}
