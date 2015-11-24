package fr.nantes.cta.one;

import fr.nantes.cta.Airplane;
import fr.nantes.cta.AirplaneOverload;
import fr.nantes.cta.Airport;
import fr.nantes.cta.Airway;
import fr.nantes.cta.CTAFactory;
import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.Coordinate;
import fr.nantes.cta.Flight;
import fr.nantes.cta.FlightPlan;
import fr.nantes.cta.IncompatibleAirway;
import fr.nantes.cta.Position;
import fr.nantes.cta.TakenAirway;
import fr.nantes.cta.VOR;
import fr.nantes.cta.one.*;



public class CTAFactoryImpl implements CTAFactory{
	
	private Airplane[] airplanes; 

	public Airplane createAirplane(double weight, int loading, int consumption, int tank) {
		return new AirplaneImpl(weight, loading, consumption, tank);
	}

	public Airport createAirport(String name) {
		return new AirportImpl(name);
	}

	public Airway createAirway(VOR start, VOR stop) {
		return new AirwayImpl(start, stop);
	}

	public Flight createCivilFlight(Airport departure, Airport arrival, Airplane plane, FlightPlan fp, int passengers) throws IncompatibleAirway, AirplaneOverload {
		// TODO Raccord de m�thode auto-g�n�r�
		return new CreateCivilFlight(departure, arrival, plane, fp, passengers);
	}

	public FlightPlan createFlightPlan() {
		// TODO Raccord de m�thode auto-g�n�r�
		return new FlightPlanImpl() ;
	}

	public Coordinate createLatitude(int degrees, int minutes, int seconds, CompassDirection dir) {
		return new LatitudeImpl(degrees, minutes, seconds, dir);
	}

	public Coordinate createLongitude(int degrees, int minutes, int seconds, CompassDirection dir) {
		return new LongitudeImpl(degrees, minutes, seconds, dir);
	}

	public Flight createMilitarFlight(Airport departure, Airport arrival, Airplane plane, FlightPlan fp, int passengers) throws IncompatibleAirway, AirplaneOverload {
		// TODO Raccord de m�thode auto-g�n�r�
		return new CreateMilitarFlight(departure, arrival, plane, fp, passengers);
	}

	public Position createPosition(Coordinate latitude, Coordinate longitude) {
		return new PositionImpl ((LatitudeImpl)latitude, (LongitudeImpl)longitude);
	}

	public TakenAirway createTakenAirway(Airway airway, int altitude, CompassDirection dir) {
		// TODO Raccord de m�thode auto-g�n�r�
		return new TakenAirwayImpl(airway, altitude, dir);
	}

	public VOR createVOR(String name, Position position) {
		return new VORImpl(name, position);
	}
	
	public void setAirplanes(Airplane[] array) {
		airplanes = array;
	}

}
