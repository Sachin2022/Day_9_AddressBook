package com.bridgelabz.addressbook;

import java.util.List;

public class AddressBook {

	private List<Contact> contacts;

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "AddressBook [contacts=" + contacts + "]";
	}

}
