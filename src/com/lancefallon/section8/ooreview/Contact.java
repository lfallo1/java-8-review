package com.lancefallon.section8.ooreview;

public class Contact {

	private String name;
	private String number;

	private Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public static Contact createContact(String name, String number) {
		return new Contact(name, number);
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		Contact contact = (Contact) obj;
		return this.getNumber().equalsIgnoreCase(contact.getNumber());
	}

}
