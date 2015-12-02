package fr.nantes.cta.test;

import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PositionImplTest {

	private PositionImpl poi;
	private LongitudeImpl lo, lo_autre;
	private LatitudeImpl la, la_autre;
	
	@Before
	public void setUp() throws Exception {
		la = new LatitudeImpl(20, 20, 20, CompassDirection.NORTH);
		lo = new LongitudeImpl(20, 20, 20, CompassDirection.EAST);
		poi = new PositionImpl(la, lo);
	}

	@Test
	public void testPositionImpl() {
		PositionImpl poitest = new PositionImpl(la,lo);
		assertNotNull(poitest);
	}
/*
	@Test
	public void testDistanceTo() {
		la = new LatitudeImpl(90, 0, 0, CompassDirection.NORTH);
		lo = new LongitudeImpl(180, 0, 0, CompassDirection.EAST);
		PositionImpl autre = new PositionImpl(la_autre,lo_autre);
		double distance_cacul = Math.acos(la.Cos() * lo.Cos() *
							((LatitudeImpl)autre.getLatitude()).Cos() *
							((LongitudeImpl)autre.getLongitude()).Cos() +
							la.Cos() * lo.Sin() *
							((LatitudeImpl)autre.getLatitude()).Cos() *
							((LongitudeImpl)autre.getLongitude()).Sin() +
							la.Sin() * ((LatitudeImpl)autre.getLatitude()).Sin()) * 6378.14;
		assertTrue(poi.distanceTo(autre) == distance_cacul);
	}
	*/
	@Test
	public void testGetLatitude() {
		assertSame(poi.getLatitude(), la);
	}

	@Test
	public void testGetLongitude() {
		assertSame(poi.getLongitude(), lo);
	}

}
