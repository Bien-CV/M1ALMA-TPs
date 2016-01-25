package main;

import data.Personne;

public class AfficherDefaut implements IAfficheur{
	
	public void affiche(Personne p) {
		System.out.println(p.toString());
	}
}