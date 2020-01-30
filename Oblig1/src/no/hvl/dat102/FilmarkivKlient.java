package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class FilmarkivKlient {

	public static void main(String[] args) {
		
		Filmarkiv filmarkiv = new Filmarkiv(1);
		
		filmarkiv.leggTilFilm(new Film(1,"bitch", "bitch2", 1999, Sjanger.FANTASI, "hore"));
		
		Meny meny = new Meny(filmarkiv);
		
		meny.start();
		
		System.out.println("Program avsluttet");
		
	}
}
