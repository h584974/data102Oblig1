package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class FilmarkivKlient {

	public static void main(String[] args) {
		
		Filmarkiv filmarkiv = new Filmarkiv(1);
		
		Film film = new Film(1,"OlliCo", "OogaBooga", 1999, Sjanger.FANTASI, "OlliCoAS");
		
		filmarkiv.leggTilFilm(film);
		
		Meny meny = new Meny(filmarkiv);
		
	}
}
