package com.lancefallon.section8.ooreview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MobilePhone {

	private List<Contact> contacts = new ArrayList<>();
	private String myNumber;
	
	public MobilePhone(String myNumber){
		this.myNumber = myNumber;
	}
	
	public Boolean addContact(Contact contact){
		if(this.contacts
			.stream()
			.filter(c->c.equals(contact))
			.collect(Collectors.toList()).size() > 0){
			return false;
		}
		return this.contacts.add(contact);
	}
	
	public List<Contact> getContacts(){
		return this.contacts;
	}
	
}
