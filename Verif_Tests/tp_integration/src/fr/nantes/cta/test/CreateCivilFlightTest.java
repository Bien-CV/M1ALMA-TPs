package fr.nantes.cta.test;

import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.one.AirplaneImpl;
import fr.nantes.cta.one.AirportImpl;
import fr.nantes.cta.one.AirwayImpl;
import fr.nantes.cta.one.CreateCivilFlight;
import fr.nantes.cta.one.FlightPlanImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.TakenAirwayImpl;
import fr.nantes.cta.one.VORImpl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreateCivilFlightTest {
	
	private CreateCivilFlight civilflight;
	
	@Before
	public void setUp() throws Exception {
		AirportImpl airportdepart = new AirportImpl("Rossy");
		AirportImpl airportarrivee = new AirportImpl("Atlantique Nantes");
		AirplaneImpl plane = new AirplaneImpl(3500000, 10000, 1000, 2000);
		
		LatitudeImpl la = new LatitudeImpl(11, 11, 11, CompassDirection.NORTH);
		LongitudeImpl lo = new LongitudeImpl(11, 11, 11, CompassDirection.EAST);
		PositionImpl poi = new PositionImpl(la, lo);
		VORImpl vor = new VORImpl("depart", poi);
		
		LatitudeImpl la2 = new LatitudeImpl(10, 10, 10, CompassDirection.NORTH);
		LongitudeImpl lo2 = new LongitudeImpl(10, 10, 10, CompassDirection.EAST);
		PositionImpl poi2 = new PositionImpl(la2, lo2);
		VORImpl vor2 = new VORImpl("arrivee", poi2);
		
		AirwayImpl airw = new AirwayImpl(vor, vor2);
		TakenAirwayImpl tai = new TakenAirwayImpl(airw, 1000, CompassDirection.NORTH);
		
		FlightPlanImpl fp = new FlightPlanImpl();
		
		civilflight = new CreateCivilFlight(airportdepart, airportarrivee, plane, fp, 300);
	}
	
	@Test
	public void testCreateCivilFlight() {
		assertNotNull(civilflight);
	}
	
	@Test
	public void testLoadingWeight() {
		int poids = 300 * 70 + 60;
		assert civilflight.loadingWeight() == poids;
		
	}

	@Test
	public void testTotalWeight() {
		assert civilflight.totalWeight() == 3500000 + 300 * 70 + 60;
	}

	

}
