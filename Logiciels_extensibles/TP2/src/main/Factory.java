package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Factory {

	private static Factory fact;
	private HashMap<String, String> map;
	// a finir pour les singleton et penser a affichage par defaut
	//private HashMap<String , IAfficheur> mapInstance;
	
	private Factory() {
		map = new HashMap<String, String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/afficheur.txt"));
			String ligne;
			while((ligne = br.readLine())!=null){
			map.put(ligne.split(" = ")[0],ligne.split(" = ")[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

	public final static Factory getInstance() {
        if (fact == null) {
           synchronized(Factory.class) {
             if (fact == null) {
            	 fact = new Factory();
             }
           }
        }
        return fact;
	}
	
	public IAfficheur loadAfficher(String nomAffich) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String value = map.get(nomAffich);
		return (IAfficheur) Class.forName(value).newInstance();
	}
	
}
