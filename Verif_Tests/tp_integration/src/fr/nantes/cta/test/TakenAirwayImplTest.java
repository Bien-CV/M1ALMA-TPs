package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.one.AirwayImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.TakenAirwayImpl;
import fr.nantes.cta.one.VORImpl;

public class TakenAirwayImplTest {

	private TakenAirwayImpl tai;
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
		vor = new VORImpl(name1, poi);
		
		la2 = new LatitudeImpl(10, 10, 10, CompassDirection.NORTH);
		lo2 = new LongitudeImpl(10, 10, 10, CompassDirection.EAST);
		PositionImpl poi2 = new PositionImpl(la2, lo2);
		vor2 = new VORImpl(name2, poi2);
		
		AirwayImpl airw = new AirwayImpl(vor, vor2);
		tai = new TakenAirwayImpl(airw, 1000, CompassDirection.NORTH);
	}
	@Test
	public void testTakenAirwayImpl() {
		TakenAirwayImpl tai = new TakenAirwayImpl(airw, 1000, CompassDirection.NORTH);
		assertNotNull(tai);
	}

	@Test
	public void testDistance() {
		assert tai.distance() == airw.getDistance();
	}

	@Test
	public void testGetAirway() {
		assert tai.getAirway()== airw;
	}

	@Test
	public void testGetAltitude() {
		assert tai.getAltitude() == 1000;
	}

	@Test
	public void testGetSense() {
		assert tai.getSense() == CompassDirection.NORTH;
	}

}
