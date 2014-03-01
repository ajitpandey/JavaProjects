package com.ajit.xml.vo;


public class Label {
	private String type;
	private String value;
	private String labeltext;
	
	
	public Label(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}


	public String getLabeltext() {
		return labeltext;
	}


	public void setLabeltext(String labeltext) {
		this.labeltext = labeltext;
	}
	
	
	
	public String getType() {
		return type;
	}


	public String getValue() {
		return value;
	}


	@Override
	public String toString() {
		return this.type + " - " + this.value + " - " + this.labeltext + " : " + super.toString();
	}
	
}
