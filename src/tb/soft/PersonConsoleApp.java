package tb.soft;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class PersonConsoleApp {

	private static final String GREETING_MESSAGE = 
			"Program Person - wersja konsolowa\n" + 
	        "Autor: Paweł Rogaliński\n" +
			"Data:  październik 2018 r.\n";

	private static final String MENU = 
			"    M E N U   G Ł Ó W N E  \n" +
			"1 - Podaj dane nowej osoby \n" +
			"2 - Usuń dane osoby        \n" +
			"3 - Wczytaj dane z pliku   \n" +
			"4 - Zapisz dane do plików   \n" +
			"0 - Zakończ program        \n";	

	private static final ConsoleUserDialog UI = new ConsoleUserDialog();

	public static void main(String[] args) {
		PersonConsoleApp application = new PersonConsoleApp();
		application.runMainLoop();
	}
	private Person currentPerson = null;

	public void runMainLoop() {
		UI.printMessage(GREETING_MESSAGE);

		while (true) {
			UI.clearConsole();
			showCurrentPerson();

			try {
				switch (UI.enterInt(MENU + "==>> ")) {
				case 1: {
					currentPerson = createNewPerson();
					Collections.addName(currentPerson.getFirstName(), currentPerson.getLastName());
				}
					break;
				case 2: {
					currentPerson = null;
					UI.printInfoMessage("Dane aktualnej osoby zostały usunięte");
					Collections.removeName(currentPerson.getFirstName(), currentPerson.getLastName());
				}
					break;

				case 3: {
					String file_name = UI.enterString("Podaj nazwę pliku: ");
					currentPerson = Person.readFromFile(file_name);
					UI.printInfoMessage("Dane aktualnej osoby zostały wczytane z pliku " + file_name);
				}
					break;
				case 4: {
					UI.printInfoMessage("Dane osób wymienionych do tej pory zostały zapisane");
					Collections.saveData();
				}					break;
				case 0:
					UI.printInfoMessage("\nProgram zakończył działanie!");
					System.exit(0);
				}
			} catch (PersonException | FileNotFoundException e) {
				UI.printErrorMessage(e.getMessage());
			}
		}
	}
	void showCurrentPerson() {
		showPerson(currentPerson);
	} 

	static void showPerson(Person person) {
		StringBuilder sb = new StringBuilder();
		
		if (person != null) {
			sb.append("Aktualna osoba: \n")
			  .append("      Imię: ").append(person.getFirstName()).append("\n")
			  .append("  Nazwisko: ").append(person.getLastName()).append("\n");
		} else
			sb.append( "Brak danych osoby\n" );
		UI.printMessage( sb.toString() );
	}

	static Person createNewPerson(){
		String first_name = UI.enterString("Podaj imię: ");
		String last_name = UI.enterString("Podaj nazwisko: ");

		Person person;
		try {
			person = new Person(first_name, last_name);
		} catch (PersonException e) {
			UI.printErrorMessage(e.getMessage());
			return null;
		}
		return person;
	}
}
