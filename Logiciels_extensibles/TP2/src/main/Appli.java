package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import data.Personne;

public class Appli {
	
	private static IAfficheur afficheur;
	
	public void afficher(String nomAffich, Personne p) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(afficheur == null) {
			afficheur = Factory.getInstance().loadAfficher(nomAffich);
		}
		afficheur.affiche(p);
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		Appli app = new Appli();
		Personne p = new Personne();
		p.setNom("Toto");
		
		System.out.print("Saisir un nom d'afficheur : ");
		Scanner sc = new Scanner(System.in);
		app.afficher(sc.nextLine(), p);
		
	}
}
