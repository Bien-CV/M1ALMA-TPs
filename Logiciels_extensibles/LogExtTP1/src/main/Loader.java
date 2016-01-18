package main;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class Loader {
		
	public static void toString(Object o,String[] tab){
		System.out.println("L'object " + o + " a les valeurs suivantes :");
		System.out.println("\t -" + tab[1]);
	}
	
	public static void main(String[] args){
		String fichier ="src/bean.txt";
		
		String ligne, nomClasse;
		Object o = null;
		Class cl = null;
		String[] attribut = null;
		Class[] param = {String.class};
		
		//lecture du fichier texte	
		try{
			InputStream ips = new FileInputStream(fichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			
			
			
			while ((ligne=br.readLine())!=null){
				if(ligne.contains("class")) {
					nomClasse = ligne.substring(6); //on aurait pu fair avec methode split
					cl = Class.forName(nomClasse);
					//System.out.println(cl); //affiche nom de la classe
				} else {
					attribut = ligne.split("=");
					if(o == null){
						o = cl.newInstance();
						System.out.println("L'object " + o + " a les valeurs suivantes :");
					}
					Method method = cl.getMethod("set"+attribut[0],param);
					Object[] obs = {attribut[0]};
					method.invoke(o, obs);
					
					System.out.println("\t -" + attribut[1]);
				}
			}
			br.close(); 
			
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}	
	}	
}
