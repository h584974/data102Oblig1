package no.hvl.dat102;

import java.util.Scanner;
import no.hvl.dat102.adt.FilmarkivADT;

public class Fil {

	private final static String SKILLE = "#";
	
	public static void lesFraFil(FilmarkivADT filmarkiv, String filnavn) {
		
		Scanner leser = new Scanner(filnavn);
		
		while(true) {
			String tempstring = leser.nextLine();
			
			if(tempstring == null || tempstring.equals("")) {
				break;
			}
			
			int filmnummeri = tempstring.indexOf(SKILLE);
			int filmnummer = Integer.parseInt(tempstring.substring(0, filmnummeri));
			
			int titteli = tempstring.indexOf(SKILLE, filmnummeri);
			String tittel = tempstring.substring(filmnummeri, titteli);
			
			int utgivelseaari = tempstring.indexOf(SKILLE, titteli);
			int utgivelseaar = Integer.parseInt(tempstring.substring(titteli, utgivelseaari));
			
			int sjangeri = tempstring.indexOf(SKILLE, utgivelseaari);
			Sjanger sjanger = Sjanger.finnSjanger(tempstring.substring(utgivelseaari, sjangeri));
			
			int filmselskapi = tempstring.indexOf(SKILLE, sjangeri);
			String filmselskap = tempstring.substring(sjangeri, filmselskapi);
			
			int produsenti = tempstring.indexOf(SKILLE, filmselskapi);
			String produsent = tempstring.substring(filmselskapi, produsenti);	
			
			filmarkiv.leggTilFilm(new Film(filmnummer, produsent, tittel, utgivelseaar, sjanger, filmselskap));
		}
		
		leser.close();
	}
	
}
