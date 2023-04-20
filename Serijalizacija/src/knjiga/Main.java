package knjiga;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Knjiga knjiga = new Knjiga("Java programiranje", "James Gosling", 1250.0);
		
		try(FileOutputStream fos = new FileOutputStream("knjiga.ser"); 
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(knjiga);
			
			System.out.println("Objekat je uspesno serijalizovan!");
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
		// serialVersionUID
		long serialVersionUID = ObjectStreamClass.lookup(knjiga.getClass()).getSerialVersionUID();
		System.out.println("serialVersionUID: " + serialVersionUID);
	}
}
