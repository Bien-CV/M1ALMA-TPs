package fr.nantes.cta.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.one.AirwayImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.VORImpl;

public class AirwayImplTest {
	
	private AirwayImpl airw;
	private VORImpl vor, vor2;
	private LongitudeImpl lo, lo2;
	private LatitudeImpl la, la2;
	private String name1 = "depart", name2 = "arrivee";

	@Before
	public void setUp() throws Exception {
		la = new LatitudeImpl(20, 20, 20, CompassDirection.NORTH);
		lo = new LongitudeImpl(20, 20, 20, CompassDirection.EAST);
		PositionImpl poi = new PositionImpl(la, lo);
		
		VORImpl vor = new VORImpl(name1, poi);
		
		la2 = new LatitudeImpl(10, 10, 10, CompassDirection.NORTH);
		lo2 = new LongitudeImpl(10, 10, 10, CompassDirection.EAST);
		PositionImpl poi2 = new PositionImpl(la2, lo2);
		
		VORImpl vor2 = new VORImpl(name2, poi2);
		
		airw = new AirwayImpl(vor, vor2);
	}
	
	@Test
	public void testAirwayImpl() {
		AirwayImpl airw = new AirwayImpl(vor, vor2);
		assertNotNull(airw);
	}

	@Test
	public void testGetDistance() {
		double distance = vor.distanceTo(vor2);
		assert(airw.getDistance() == distance);
	}

	@Test
	public void testGetVORDepart() {
		assert(airw.GetVORDepart() == "depart");
	}

	@Test
	public void testGetVORArrive() {
		assert(airw.GetVORArrive()== "arrivee" );
	}

}
