package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest{

	// Test constructor that has Valid behavior.

	@DisplayName("Test Valid Constructor.")
	@Test
	public void testGoodConstructor() {
        String contactId = "1";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        
		assertEquals(1, testContact.getContactID());
		assertEquals(firstName, testContact.getFirstName());
		assertEquals(lastName, testContact.getLastName());
		assertEquals(phoneNumber, testContact.getPhoneNumber());
		assertEquals(address, testContact.getAddress());
	}
	
	// Test constructor with data that is Invalid.

	@DisplayName("Test Constructor that is Invalid.")
	@Test
	public void testBadConstructor() {
      	String badID = null;
      	
		String firstName = "John";
        String lastName = "Smith";
        String address = "123 Main Rd.";       
        
        // Invalid ID.
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      		 new Contact(badID, firstName, lastName, "1234567890", address);
        });
      	
      	assertEquals("Invalid contact ID", exception.getMessage());
      	
        // Invalid phone number.
      	exception = assertThrows(IllegalArgumentException.class, () -> {
      		 new Contact("0", firstName, lastName, "1", address);
        });
      	
      	assertEquals("Invalid phone number", exception.getMessage());
	}

	// Test setFirstName with an input that is Valid. 

	@DisplayName("Test setFirstName with Valid input.")
	@Test
	public void testGoodSetFirst() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setFirstName("Test");        
        assertEquals("Test", testContact.getFirstName());
	}
	
	// Test setFirstName with string that is Null. Error.

	@DisplayName("Test setFirstName that is Invalid and Null.")
	@Test
	public void testBadSetFirst() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName(null);
        });
	}
	
	// Test setFirstName with a length that is too long.

	@DisplayName("Test for setFirstName with length that is Invalid.")
	@Test
	public void testLongSetFirst() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName("First Name Too Long");
        });
	}
	
	// Test for getID using Valid constructor, ensure int is returned.

	@DisplayName("Test for getID.")
	@Test
	public void testGetID() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        assertEquals(3, testContact.getContactID());
	}
	
	// Test for getID using Valid constructor, ensure no string is returned.

	@DisplayName("Test for getId that is Invalid.")
	@Test
	public void testBadGetID() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        assertNotEquals("3", testContact.getContactID());
	}

	// Test getID with an ID that is too long.

	@DisplayName("Test for getId, too long.")
	@Test
	public void testlongGetID() {
        String contactId = "123456789101112131415";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactId, firstName, lastName, phoneNumber, address);
        });
	}
	
	// Test setLastName with a string that is Null. Error.
	
	@DisplayName("Test Invalid setLastName that is Null.")
	@Test
	public void testBadSetLast() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName(null);
        });
	}
	
	// Test setLastName with a length that is too long.
	
	@DisplayName("Test setLastName that has a length that is Invalid.")
	@Test
	public void testLongSetLast() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName("Last Name Too Long");
        });
	}
	
	// Test setLastName with an input that is Valid.

	@DisplayName("Test for setLastName that is Valid.")
	@Test
	public void testGoodsetLast() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setLastName("Test");        
        assertEquals("Test", testContact.getLastName());
	}
	
	// Test setPhoneNumber with string that is Null. Error.

	@DisplayName("Test for setPhoneNumber that is Invalid and Null.")
	@Test
	public void testBadSetPhone() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber(null);
        });
	}

	// Test setPhoneNumber with a length that is NOT 10.

	@DisplayName("Test for setPhoneNumber with an Invalid length.")
	@Test
	public void testWrongLengthPhone() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber("1");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber("123456789101112131415");
        });
	}
	
	// Test setPhone with length value of 10.
	
	@DisplayName("Test setPhoneNumber with a length that is Valid.")
	@Test
	public void testGoodPhone() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setPhoneNumber("1098765432");        
        assertEquals("1098765432", testContact.getPhoneNumber());

	}
	
	// Test for setAddress with string that is Null. Error.

	@DisplayName("Test Invalid setaddress that is Null.")
	@Test
	public void testNullSetAddress() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress(null);
        });
	}
	
	/*
	 * Test setAddress with a length that exceeds 30.
	 * Throw exception.
	 */

	@DisplayName("Test setPhoneNumber with a length that is Invalid.")
	@Test
	public void testWrongLengthAddress() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress("Address is too long.");
        });
	}

	// Test for setAddress with a Valid input.

	@DisplayName("Test setAddress with a length that is Valid.")
	@Test
	public void testGoodAddress() {
        String contactId = "3";
      	String firstName = "John";
        String lastName = "Smith";
        String phoneNumber = "123456789101112131415";
        String address = "123 Main Rd.";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setAddress("123 Valid Address.");        
        assertEquals("123 Valid Address.", testContact.getAddress());
	}
}