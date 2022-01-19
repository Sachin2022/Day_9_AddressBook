package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMainClass {
	public static AddressBook addressBook = new AddressBook();
	public static List<Contact> contactList = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		addContactDetails();
	}

	public static void addContactDetails() {
		Scanner sc = new Scanner(System.in);
		String value;

		System.out.println("Do You Want Use Address Book Press Yes for Continue");
		value = sc.next();

		while (value.equals("yes")) {

			System.out.println("Enter your choice");
			System.out.println("1 : Add new contact    2 : Edit contact   3 : Delete Contact  4 : Display");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the First Name");
				String firstName = sc.next();
				System.out.println("Enter the Last Name");
				String lastName = sc.next();
				System.out.println("Enter the Address");
				String address = sc.next();
				System.out.println("Enter the city");
				String city = sc.next();
				System.out.println("Enter the state");
				String state = sc.next();
				System.out.println("Enter the zip Code");
				int zip = sc.nextInt();
				System.out.println("Enter the Phone number");
				long phone = sc.nextLong();
				Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone);

				contactList.add(contact);
				addressBook.setContacts(contactList);
				break;

			case 2:

				System.out.println("Please Enter the Person name to Edit ");
				String name = sc.next();
				editContact(name);
				break;

			case 3:
				System.out.println("Enter the person Name");
				String deletename = sc.next();
				deleteContactDetails(deletename);
				break;

			case 4:
				displayContacts(addressBook);
				break;

			default:
				System.out.println("Please Enter correct choice");
				break;
			}

		}

	}

	public static void deleteContactDetails(String name) {
		List<Contact> contactDetails = addressBook.getContacts();
		for (int i = 0; i <= contactDetails.size() - 1; i++) {

			int value = 0;
			Contact contactperson = contactDetails.get(i);
			if (contactperson.getFirstName().equals(name)) {
				contactperson.setAddress("");
				contactperson.setCity("");
				contactperson.setFirstName("");
				contactperson.setLastName("");
				contactperson.setPhone(value);
				contactperson.setState("");
				contactperson.setZip(value);
				contactDetails.set(i, contactperson);
				addressBook.setContacts(contactDetails);
			}
		}
		System.out.println("Contact deleted Successfully");
		displayContacts(addressBook);
	}

	public static void editContact(String name) {
		Scanner sc = new Scanner(System.in);
		List<Contact> contactDetails = addressBook.getContacts();
		for (int i = 0; i <= contactDetails.size() - 1; i++) {

			Contact contactperson = contactDetails.get(i);
			if (contactperson.getFirstName().equals(name)) {
				System.out.println("Please Select Your Choice to Edit");
				System.out.println("1:Firstname 2:Lastname 3:Address 4:City 5:State 6:Zip Code 7:Phone Number");
				int yourChoice = sc.nextInt();
				switch (yourChoice) {
				case 1:
					System.out.println("Enter the First Name");
					String firstName = sc.next();
					contactperson.setFirstName(firstName);
					break;
				case 2:
					System.out.println("Enter the Last Name");
					String lastName = sc.next();
					contactperson.setLastName(lastName);
					break;
				case 3:
					System.out.println("Enter The Address");
					String address = sc.next();
					contactperson.setAddress(address);
					break;
				case 4:
					System.out.println("Enter the city");
					String city = sc.next();
					contactperson.setCity(city);
					break;
				case 5:
					System.out.println("Enter the state");
					String state = sc.next();
					contactperson.setState(state);
					break;
				case 6:
					System.out.println("Enter the zip Code");
					int zip = sc.nextInt();
					contactperson.setZip(zip);
					break;
				case 7:
					System.out.println("Enter the Phone number");
					long phone = sc.nextLong();
					contactperson.setPhone(phone);
					break;
				default:
					System.out.println("Please Enter correct choice");
					break;
				}
				contactDetails.set(i, contactperson);
				addressBook.setContacts(contactDetails);
			}
		}
		displayContacts(addressBook);
	}

	public static void displayContacts(AddressBook addressBook) {
		List<Contact> contactDetails = addressBook.getContacts();

		for (int i = 0; i <= contactDetails.size() - 1; i++) {
			Contact contactperson = contactDetails.get(i);
			if (!contactperson.getFirstName().equals("")) {
				System.out.println("Conatct Details :");
				System.out.println("FirstName :" + contactperson.getFirstName() + "      LastName :"
						+ contactperson.getLastName() + "     Address :" + contactperson.getAddress() + "      City :"
						+ contactperson.getCity() + "       State :" + contactperson.getState() + "     Zip :"
						+ contactperson.getZip() + "     Phone Number :" + contactperson.getPhone());
			} else {

				System.out.println("No Conatct Details available :");
			}
		}
	}
}
