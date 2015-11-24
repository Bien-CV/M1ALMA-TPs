/*
 * Created on 22 oct. 06
 *
 */
package fr.nantes.cta;

/**
 * @author sunye
 *
 * Exception thrown during a {@link Flight Flight}  instantiation. 
 */
public class IncompatibleAirway extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 102869751064547652L;
	
	public IncompatibleAirway (){
		super ("plan de vol incompatible");
	}
	
	public IncompatibleAirway (double autonomie, double distance){
		// TODO mettre une jolie phrase! ;D
		super ("distance du vol : "+distance+" autonomie de l'avion : "+autonomie+"\n distance trop importante");
	}

}
