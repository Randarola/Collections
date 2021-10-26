package tb.soft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

class PersonException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersonException(String message) {
		super(message);
	}
}
public class Person {
	
	private String firstName;
	private String lastName;
	
	public Person(String first_name, String last_name) throws PersonException {
		setFirstName(first_name);
		setLastName(last_name);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) throws PersonException {
		if ((first_name == null) || first_name.equals(""))
			throw new PersonException("Pole <Imię> musi być wypełnione.");
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) throws PersonException {
		if ((last_name == null) || last_name.equals(""))
			throw new PersonException("Pole <Nazwisko> musi być wypełnione.");
		this.lastName = last_name;
	}
	
	public static void printToFile(PrintWriter writer, Person person){
		writer.println(person.firstName + "#" + person.lastName);
	}

	public static void printToFile(String file_name, Person person) throws PersonException {
		try (PrintWriter writer = new PrintWriter(file_name)) {
			printToFile(writer, person);
		} catch (FileNotFoundException e){
			throw new PersonException("Nie odnaleziono pliku " + file_name);
		}
	}

	public static Person readFromFile(BufferedReader reader) throws PersonException{
		try {
			String line = reader.readLine();
			String[] txt = line.split("#");
			Person person = new Person(txt[0], txt[1]);
			return person;
		} catch(IOException e){
			throw new PersonException("Wystąpił błąd podczas odczytu danych z pliku.");
		}	
	}
	
	
	public static Person readFromFile(String file_name) throws PersonException {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(file_name)))) {
			return Person.readFromFile(reader);
		} catch (FileNotFoundException e){
			throw new PersonException("Nie odnaleziono pliku " + file_name);
		} catch(IOException e){
			throw new PersonException("Wystąpił błąd podczas odczytu danych z pliku.");
		}	
	}
}
