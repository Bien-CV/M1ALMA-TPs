package main;

import data.Personne;

public class AfficherXML implements IAfficheur{
	
	public void affiche(Personne p) {
		System.out.println("<personne> " + p.toString() + " </personne>");
	}
}
