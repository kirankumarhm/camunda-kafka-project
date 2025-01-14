package com.example.workflow.delegate;

import java.io.Serializable;

public class Message implements Serializable{
	public String compositeID;
	public String payload;
	
	public Message() {
	}

	public Message(String compositeID, String payload) {
		this.compositeID = compositeID;
		this.payload = payload;
	}

	public String getCompositeID() {
		return compositeID;
	}

	public void setCompositeID(String compositeID) {
		this.compositeID = compositeID;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Message [compositeID=" + compositeID + ", payload=" + payload + "]";
	}
	
	
}