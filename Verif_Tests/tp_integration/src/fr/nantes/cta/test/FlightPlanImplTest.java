package fr.nantes.cta.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.TakenAirway;
import fr.nantes.cta.one.AirwayImpl;
import fr.nantes.cta.one.FlightPlanImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.TakenAirwayImpl;
import fr.nantes.cta.one.VORImpl;

public class FlightPlanImplTest {

	private FlightPlanImpl fp;
	private List<TakenAirway> airwayListModifiable;
	private List<TakenAirway> airwayListNonModifiable;
	
	private TakenAirwayImpl tai;
	private AirwayImpl airw;
	private VORImpl vor, vor2;
	private LongitudeImpl lo, lo2;
	private LatitudeImpl la, la2;
	
	@Before
	public void setUp() throws Exception {
		
		la = new LatitudeImpl(20, 20, 20, CompassDirection.NORTH);
		lo = new LongitudeImpl(20, 20, 20, CompassDirection.EAST);
		PositionImpl poi = new PositionImpl(la, lo);
		
		vor = new VORImpl("depart", poi);
		
		la2 = new LatitudeImpl(10, 10, 10, CompassDirection.NORTH);
		lo2 = new LongitudeImpl(10, 10, 10, CompassDirection.EAST);
		PositionImpl poi2 = new PositionImpl(la2, lo2);
		
		vor2 = new VORImpl("arrivee", poi2);
		
		airw = new AirwayImpl(vor, vor2);
		tai = new TakenAirwayImpl(airw, 1000, CompassDirection.NORTH);
		
		fp = new FlightPlanImpl();
	}
	/*
	@Test
	public void testFlightPlanImpl() {
		assertNotNull(fp);
	}
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAddAirwayWithException() {
		fp.addAirway(tai);
	}
	
	@Test
	public void testAddAirway() {
		fail("Not yet implemented");
	}

	@Test
	public void testDistance() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPath() {
		assert fp.getPath() == airwayListNonModifiable;
	}

}
