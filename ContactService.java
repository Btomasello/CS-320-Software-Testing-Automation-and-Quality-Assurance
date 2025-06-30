package service;

import java.util.List;
import model.Contact;
import java.util.ArrayList;

public class ContactService {
	
	int currentIDNum = 0; // Test.

	// Creates new ArrayList that holds Contact objects.
	public static List<Contact> contactList = new ArrayList<Contact>();
	
	/**
	 * Adds a new contact at the index ID.
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param address
	 */
	public void addContact(String firstName, String lastName,
			String phoneNumber, String address) {
		
		String stringID = Integer.toString(currentIDNum);
		
		Contact newContact = new Contact(stringID, firstName, lastName, phoneNumber, address);
		contactList.add(newContact.getContactID(),newContact);
		
		// ID +1
		++currentIDNum;
	}
	
	/**
	 * Deletes contact as index ID.
	 * @param ID
	 */	
	public void deleteContact(String ID) {
		int intID = Integer.valueOf(ID);

		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getContactID() == intID) {
				contactList.remove(i);
			}
		}
	}
	
	/**
	 * Edits First Name of Contact Object located at contactID.
	 * Uses setFirstName method.
	 * @param contactID
	 * @param firstName
	 */
	public void editFirstName(String contactID, String firstName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setFirstName(firstName);				
			}			
		}	
	}
	
	/**
	 * Edits Last Name of Contact Object located at contactID.
	 * Uses setLastName method.
	 * @param contactID
	 * @param lastName
	 */
	public void editLastName(String contactID, String lastName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setLastName(lastName);				
			}			
		}	
	}
	public void editNumber(String contactID, String phoneNumber) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setPhoneNumber(phoneNumber);				
			}			
		}	
	}
	public void editAddress(String contactID, String address) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setAddress(address);				
			}			
		}	
	}
}