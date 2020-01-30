package no.hvl.dat102;

import java.util.Scanner;
import no.hvl.dat102.adt.*;

public class Tekstgrensesnitt {

	public static void skrivUtFilmDelstrengTittel(FilmarkivADT filmarkiv, String tittelstreng) {
		skrivUtFilmTabell(filmarkiv.sokTittel(tittelstreng));
	}
	
	public static void skrivUtFilmDelstrengProdusent(FilmarkivADT filmarkiv, String produsentstreng) {
		skrivUtFilmTabell(filmarkiv.sokProdusent(produsentstreng));
	}
	
	public static void skrivUtStatistikk(FilmarkivADT filmarkiv) {
		
		int antall = filmarkiv.getAntall();
		int antallFANTASI = filmarkiv.antallSjanger(Sjanger.FANTASI);
		int antallSCIFI = filmarkiv.antallSjanger(Sjanger.SCIFI);
		int antallDOKUMENTAR = filmarkiv.antallSjanger(Sjanger.DOKUMENTAR);
		
		System.out.println("-----------------------------------");
		System.out.println("Antall filmer:" + String.format("%10d", antall));
		System.out.println("Antall FANTASI:" + String.format("%10d", antallFANTASI));
		System.out.println("Antall SCIFI:" + String.format("%10d", antallSCIFI));
		System.out.println("Antall DOKUMENTAR:" + String.format("%10d", antallDOKUMENTAR));
		System.out.println("-----------------------------------");
		
	}
	
	public static Film lesFilm() {
		
		Scanner leser = new Scanner(System.in);
		
		System.out.println("Skriv Filmnummer:");
		int filmnummer = Integer.parseInt(leser.nextLine());
		while(filmnummer < 0) {
			System.out.println("Filmnummer kan ikke være negativ");
			filmnummer = Integer.parseInt(leser.nextLine());
		}
		
		System.out.println("Skriv Tittel:");
		String tittel = leser.nextLine();
		
		System.out.println("Skriv utgivelseår");
		int utgivelseaar = Integer.parseInt(leser.nextLine());
		while(utgivelseaar < 0) {
			System.out.println("Utgivelseår kan ikke være negativ");
			utgivelseaar = Integer.parseInt(leser.nextLine());
		}
		
		System.out.println("Skriv sjanger (SCIFI, DOKUMENTAR, FANTASI):");
		Sjanger sjanger = Sjanger.finnSjanger(leser.nextLine());
		while(sjanger == null) {
			System.out.println("Ugyldig sjanger valgt, prøv igjen:");
			sjanger = Sjanger.finnSjanger(leser.nextLine());
		}
		
		System.out.println("Skriv filmselskap:");
		String filmselskap = leser.nextLine();
		
		System.out.println("Skriv produsent");
		String produsent = leser.nextLine();
		
		leser.close();
		
		return new Film(filmnummer, produsent, tittel, utgivelseaar, sjanger, filmselskap);
		
	}
	
	public static void skrivUtFilmTabell(Film[] filmer) {
		
		System.out.println("-----------------------------------");
		for(Film i : filmer) {
			visFilm(i);
			System.out.println("-----------------------------------");
		}
	}
	
	public static void visFilm(Film film) {
		
		try {
			String output = "Filmnummer" + String.format("%10d",film.getFilmnummer()) + "\n";
			output += "Tittel:" + String.format("%30s", film.getTittel()) + "\n";
			output += "Sjanger:" + String.format("%20s", film.getSjanger()) + "\n";
			output += "År utgitt:" + String.format("%10d", film.getUtgivelseaar()) + "\n";
			output += "Filmselskap:" + String.format("%30s", film.getFilmselskap()) + "\n";
			output += "Produsent:" + String.format("%30s", film.getProdusent()) + "\n";
		
			System.out.println(output);
		} catch(NullPointerException e) {
			System.out.println("NullPointerException, verdi for Film ikke funnet i Tekstgrensesnitt.visFilm");
		}
	}
	
}
