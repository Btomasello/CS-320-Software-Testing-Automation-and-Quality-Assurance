package model;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;	
	
	/**
	 * Validation for the contactID.
	 * @param contactID
	 * @return bool
	 */
	private final boolean validateID(String contactID) {
		if(contactID == null || contactID.length() > 10) {
			return false;			
		}		
		return true;
	}
	
	/**
	 * Validation for the lastName.
	 * @param lastName
	 * @return bool
	 */
	private final boolean validateLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			return false;			
		}
		return true;
	}
	/**
	 * Validation for the firstName.
	 * @param firstName
	 * @return bool
	 */
	private final boolean validateFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {	
			return false;			
		}
		return true;
	}
	/**
	 * Validation for the phoneNumber.
	 * @param phoneNumber
	 * @return bool
	 */
	private final boolean validatePhone(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.length() != 10) {
			return false;			
		}
		return true;
	}
	/**
	 * Validation for the address.
	 * @param address
	 * @return bool
	 */
	private final boolean validateAddress(String address) {
		if(address == null || address.length() > 30) {
			return false;			
		}
		return true;
	}
	
	public Contact(String contactID, 
			String firstName, 
			String lastName, 
			String phoneNumber, 
			String address) {
		
		if(!this.validateID(contactID)) {
			throw new IllegalArgumentException("The contact ID is Invalid.");
		}
		
		if(!this.validateFirstName(firstName)) {
			throw new IllegalArgumentException("The first name is Invalid.");
		}
		
		if(!this.validateLastName(lastName)) {
			throw new IllegalArgumentException("The last name is Invalid.");
		}
		
		if(!this.validatePhone(phoneNumber)) {
			throw new IllegalArgumentException("The phone number is Invalid.");
		}
		
		if(!this.validateAddress(address)) {
			throw new IllegalArgumentException("The address is Invalid.");
		}		
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getContactID() {
		return Integer.valueOf(contactID);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(!this.validateFirstName(firstName)) {
			throw new IllegalArgumentException("First name is Invalid.");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(!this.validateLastName(lastName)) {
			throw new IllegalArgumentException("Last name is Invalid.");
		}
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if(!this.validatePhone(phoneNumber)) {
			throw new IllegalArgumentException("Phone number is Invalid.");
		}
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(!this.validateAddress(address)) {
			throw new IllegalArgumentException("Address is Invalid.");
		}	
		this.address = address;
	}
}