package sample;

public class Customer {
	int customerID;int addressID; String firstName; String lastName; String phone; int yearOfUses; int age;
	String gender; 
	String status;
	public Customer(int customerID, String firstName, String lastName, int addressID, String phone, int yearOfUses, int age, String gender, String status) {
 		this.customerID = customerID;
 		this.addressID = addressID;
 		this.firstName = firstName;
 		this.lastName = lastName;
 		this.phone = phone;
 		this.yearOfUses = yearOfUses;
 		this.age = age;
 		this.gender = gender;
 		this.status = status;
    }
    public int getCustomerID() {
        return customerID;
    }
    public int getAddressID() {
        return addressID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public int getYearOfUses() {
        return yearOfUses;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getStatus() {
        return status;
    }



}