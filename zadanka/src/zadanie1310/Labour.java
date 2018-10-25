package zadanie1310;

public class Labour {

	String name, surname, email;
	
	public Labour(String email) {
		this.email = email;
	}
	public Labour (String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Labour (String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return name + " " + surname + " " + email;
	}


	
	
	
	
}
