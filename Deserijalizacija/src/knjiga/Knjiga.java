package knjiga;

import java.io.Serializable;

// Ova klasa je identicna klasi Knjiga u projektu Serijalizacija

public class Knjiga implements Serializable {

	private static final long serialVersionUID = 2023L;
	String naziv;
	String autor;
	transient double cena; // ovo ce biti ignorisano prilikom (de)serijalizacije
	
	Knjiga(String naziv, String autor, double cena){
		this.naziv = naziv;
		this.autor = autor;
		this.cena = cena;
	}
	
	public String toString() {
		return "Naziv knjige: " + naziv + "\nAutor: " + autor + "\nCena: " + cena;
	}
	
}
