package services;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ContactService;

class ContactServiceTest {
	
	// Clears the ArrayList after each test run.
	@AfterEach
	void tearDown() throws Exception {
		ContactService.contactList.clear();
	}

	// Calls AddContact method and passes first name, last name, phone number, and address, then validates.

	@DisplayName("Test for addContact.")
	@Test
	void testAddContact() {

		String firstName = "John";
		String lastName = "Smith";
		String phoneNumber = "123456789101112131415";
		String address = "123 Main Rd.";

		ContactService test = new ContactService();

		assertTrue(ContactService.contactList.isEmpty());

		test.addContact(firstName, lastName, phoneNumber, address);

		assertFalse(ContactService.contactList.isEmpty());
		assertEquals(0, ContactService.contactList.get(0).getContactID());
		assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
		assertEquals(lastName, ContactService.contactList.get(0).getLastName());
		assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
		assertEquals(address, ContactService.contactList.get(0).getAddress());

	}

	/**
	* Adds 3 contacts through the addContact delete object.
	Check at ID location 1 and ensure there is no object present.
	*/

	@DisplayName("Test for deleteContact.")			  
	@Test void testDeleteContact() {
				  
		String firstName = "John"; 
		String lastName = "Smith"; 
		String phoneNumber = "123456789101112131415"; 
		String address = "123 Main Rd.";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  
		assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		  
		test.deleteContact("1");
		  
		assertEquals(2,ContactService.contactList.size());
		 
		// Loops through and searches for an ID.

		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getContactID() == 1) {
				testBool = true;
			}
		}		
		assertFalse(testBool);				 
	}

	// Creates a new contact and validates the phone number. Edits number and validates again.

	@DisplayName("Test for phone number edit.")
	@Test
	void testEditPhone() {
		
		String firstName = "John"; 
		String lastName = "Smith"; 
		String phoneNumber = "123456789101112131415"; 
		String address = "123 Main Rd.";
		  
		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
		
		test.editNumber("0", "1098765432");
		assertEquals("1098765432", ContactService.contactList.get(0).getPhoneNumber());
	}

	// Creates a  new contact and validates last name. Edits last name and validates again.

	@DisplayName("Test the edit for last name.")
	@Test
	void testEditLast() {
		
		String firstName = "John"; 
		String lastName = "Smith"; 
		String phoneNumber = "123456789101112131415"; 
		String address = "123 Main Rd.";
		  
		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(lastName, ContactService.contactList.get(0).getLastName());
		
		test.editLastName("0", "Test_Name");
		assertEquals("Test_Name", ContactService.contactList.get(0).getLastName());
	}

	// Creates a new contact and validates the first name. Edits first name and validates again.

	@DisplayName("Test the edit for the first name.")
	@Test
	void testEditFirst() {
		
		String firstName = "John"; 
		String lastName = "Smith"; 
		String phoneNumber = "123456789101112131415"; 
		String address = "123 Main Rd.";

		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
		
		test.editFirstName("0", "Test_First");
		assertEquals("Test_First", ContactService.contactList.get(0).getFirstName());
	}

	// Creates a new contact and validates address. Edits address and validates again.

	@DisplayName("Test the edit for address.")
	@Test
	void testEditAddress() {
		
		String firstName = "John"; 
		String lastName = "Smith"; 
		String phoneNumber = "123456789101112131415"; 
		String address = "123 Main Rd.";

		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(address, ContactService.contactList.get(0).getAddress());
		
		test.editAddress("0", "Test_Address");
		assertEquals("Test_Address", ContactService.contactList.get(0).getAddress());
	}
	
	/*
	 * Creates a new contact and validates address. Attempts to edit address.
	 * Address does NOT exist.
	 */

	@DisplayName("Test for edit of address with Invalid ID.")
	@Test
	void testEditBadAddress() {
		
		String firstName = "John"; 
		String lastName = "Smith"; 
		String phoneNumber = "123456789101112131415"; 
		String address = "123 Main Rd.";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  
		assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		
		test.editAddress("3", "Test_Address");
		
		assertEquals(3,ContactService.contactList.size());
		  	 
		// Loops through and searches for an ID.

		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getAddress().equals("Test_Address")) {
				testBool = true;
			}
		}		
		assertFalse(testBool);				
	}
	
	/*
	 * Creates a new contact and validates First Name. Attempts to edit first name.
	 * First name does NOT exist.
	 */

	@DisplayName("Test edit for first name with Invalid ID.")
	@Test
	void testEditBadFirstName() {
		
		String firstName = "John"; 
		String lastName = "Smith"; 
		String phoneNumber = "123456789101112131415"; 
		String address = "123 Main Rd.";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  
		assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		
		test.editFirstName("3", "Test_Name");
		
		assertEquals(3,ContactService.contactList.size());
		  	 
		// Loops through and searches for an ID.

		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getFirstName().equals("Test_Name")) {
				testBool = true;
			}
		}		
		assertFalse(testBool);			
	}

	/*
	 * Creates a new contact and validates Last Name. Attempts to edit last name.
	 * Last name does NOT exist.
	 */

	@DisplayName("Test edit for last name with an Invalid ID.")
	@Test
	void testEditBadLastName() {
		
		String firstName = "John"; 
		String lastName = "Smith"; 
		String phoneNumber = "123456789101112131415"; 
		String address = "123 Main Rd.";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  
		assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		
		test.editLastName("3", "Test_Name");
		
		assertEquals(3,ContactService.contactList.size());
		  	 
		// Loops through and searches for an ID.

		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getLastName().equals("Test_Name")) {
				testBool = true;
			}
		}		
		assertFalse(testBool);			
	}
	
	/*
	 * Creates a new contact and validates phone number. Attempts to edit phone number.
	 * Phone number does NOT exist.
	 */

	@DisplayName("Test edit for last name with Invalid ID.")
	@Test
	void testEditBadNumber() {
		
		String firstName = "John"; 
		String lastName = "Smith"; 
		String phoneNumber = "123456789101112131415"; 
		String address = "123 Main Rd.";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  
		assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		
		test.editNumber("3", "1098765432");
		
		assertEquals(3,ContactService.contactList.size());
		  	 
		// Loops through and searches for ID.

		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getPhoneNumber().equals("Test_Name")) {
				testBool = true;
			}
		}		
		assertFalse(testBool);			
	}
}