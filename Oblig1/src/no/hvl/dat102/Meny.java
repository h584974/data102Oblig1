package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		this.filmarkiv = filmarkiv;
		tekstgr = new Tekstgrensesnitt();
	}
	
	public void start()  {
		
		Scanner leser = new Scanner(System.in);
		System.out.println("Hva ønsker du å gjøre? Skriv følgende for ønskede funksjoner:");
		
		while(true) {
			System.out.println("Avslutt: 1");
			System.out.println("Legg til ny film i samling: 2");
			System.out.println("Slett film fra samling: 3");
			System.out.println("Skriv ut statistikk om samling: 4");
			System.out.println("Skriv ut film fra produsent: 5");
			System.out.println("Skriv ut film fra tittel: 6");
			
			int svar = 1;
			
			try {
				svar = Integer.parseInt(leser.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ugyldig svar angitt\n");
			}
			
			if(svar == 1) {
				break;
			} else if(svar == 2) {
				
			} else if(svar == 3) {
				
			} else if(svar == 4) {
				
			} else if(svar == 5) {
				
			} else if(svar == 6) {
				
			} else {
				System.out.println("Ingen gyldig svar angitt\n");
			}
		}
		
		leser.close();
	}

}
