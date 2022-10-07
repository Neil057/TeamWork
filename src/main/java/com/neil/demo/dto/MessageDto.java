package com.neil.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("text")
	private String inputText;

	public MessageDto() {
	}

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	
	

}
