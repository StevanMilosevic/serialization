package knjiga;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// Koraci za deserijalizaciju:
		// 1. deklarisati objekat, ne instancirati ga
		Knjiga knjiga = null;
		
		// 2. klasa FileInputStream kao parametar prihvata fajl koji treba da deserijalizujemo
		// ostavljam ovde sa putanjom u mom fajl sistemu
		// za potrebe nekog drugog programa ovo ce morati da se ispravi
		String putanja = "C:\\Users\\Steva\\eclipse-workspace\\Serijalizacija\\knjiga.ser";
		
		// 3. i 4. klase FileInputStream i ObjectInputStream
		try(FileInputStream fis = new FileInputStream(putanja); 
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			//5. objectName = (Class)ois.readObject(), eksplicitna konverzija
			knjiga = (Knjiga)ois.readObject();
			
			System.out.println("Uspesna deserijalizacija!");
			
		}catch(ClassNotFoundException e) {
			System.out.println("Greska: " + e);
		}
		
		// serialVersionUID
		long serialVersionUID = ObjectStreamClass.lookup(knjiga.getClass()).getSerialVersionUID();
		System.out.println(knjiga.toString());
		System.out.println("serialVersionUID: " + serialVersionUID);

	}

}
