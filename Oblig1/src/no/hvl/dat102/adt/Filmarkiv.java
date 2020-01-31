package no.hvl.dat102.adt;

import no.hvl.dat102.*;

public class Filmarkiv implements FilmarkivADT {
	
	private Film[] filmliste;
	private int antall;
	
	public Filmarkiv(int antallPlasser) {
		this.filmliste = new Film[antallPlasser];
		this.antall = 0;
	}
	
	public int getAntall() {
		return this.antall;
	}
	
	public Film[] hentFilmTabell() {
		return this.filmliste;
	}
	
	public void utvidKapasitet() {
		
		Film[] tempfilmliste;
		
		if(this.antall < 10) {
			tempfilmliste = new Film[this.filmliste.length + 1];
		} else {
			tempfilmliste = new Film[(int)(this.filmliste.length * 1.1)];
		}
		
		for(int i = 0; i < this.antall; i++) {
			tempfilmliste[i] = this.filmliste[i];
		}
		
		this.filmliste = tempfilmliste;
	}
	
	public static void forkortFilmTabell(Film[] filmer) {
		
		int indeks = -1;
		
		for(int i = 0; i < filmer.length; i++) {
			if(filmer[i] == null) {
				indeks = i;
				break;
			}
		}
		
		
		if(indeks > -1) {
			Film[] tempfilmer = new Film[indeks];
			
			for(int i = 0; i < tempfilmer.length; i++) {
				tempfilmer[i] = filmer[i];
			}
			
			filmer = tempfilmer;
		}
		
	}
	
	public int finnFilm(Film film) {
		
		for(int i = 0; i < this.antall; i++) {
			if(this.filmliste[i].getFilmnummer() == film.getFilmnummer()) {
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean leggTilFilm(Film nyfilm) {
		
		if(finnFilm(nyfilm) == -1 && this.antall < this.filmliste.length) {
			this.filmliste[this.antall] = nyfilm;
			this.antall++;
			return true;
		}  else if(this.antall == this.filmliste.length) {
			utvidKapasitet();
			this.filmliste[this.antall] = nyfilm;
			this.antall++;
			return true;
		} else {
			System.out.println("Film finnes fra før");
		}
		
		return false;
	}
	
	public boolean slettFilm(int filmnummer) {
		
		boolean funnet = false;
		
		for(int i = 0; i < this.antall; i++) {
			
			if(funnet) {
				this.filmliste[i-1] = this.filmliste[i];
			}
			
			if(filmnummer == this.filmliste[i].getFilmnummer()) {
				funnet = true;
			}
			
			if(funnet && i == this.antall - 1) {
				this.filmliste[i] = null;
			}
			
		}
		
		this.antall--;
		
		return funnet;
	}
	
	public Film[] sokTittel(String tittelstreng) {
		
		Film[] filmer = new Film[this.antall];
		int tempantall = 0;
		
		for(int i = 0; i < this.antall; i++) {
			if(this.filmliste[i].getTittel().toLowerCase().contains(tittelstreng.toLowerCase())) {
				filmer[tempantall] = this.filmliste[i];
				tempantall++;
			}
		}
		
		forkortFilmTabell(filmer);
		
		return filmer;
	}
	
	public Film[] sokProdusent(String produsentstreng) {
		
		Film[] filmer = new Film[this.antall];
		int tempantall = 0;
		
		for(int i = 0; i < this.antall; i++) {
			if(this.filmliste[i].getProdusent().toLowerCase().contains(produsentstreng.toLowerCase())) {
				filmer[tempantall] = this.filmliste[i];
				tempantall++;
			}
		}
		
		forkortFilmTabell(filmer);
		
		return filmer;
	}
	
	public int antallSjanger(Sjanger sjanger) {
		
		int antallsjanger = 0;
		
		for(int i = 0; i < this.antall; i++) {
			if(this.filmliste[i].getSjanger() == sjanger) {
				antallsjanger++;
			}
		}
		
		return antallsjanger;
	}
	
}
