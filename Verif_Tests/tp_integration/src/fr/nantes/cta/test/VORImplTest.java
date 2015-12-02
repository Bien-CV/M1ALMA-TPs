package fr.nantes.cta.test;

import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.VORImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VORImplTest {

	private PositionImpl poi;
	private LongitudeImpl lo;
	private LatitudeImpl la;
	private VORImpl vor;
	private String name = "coucou";
	
	@Before
	public void setUp() throws Exception {
		la = new LatitudeImpl(20, 20, 20, CompassDirection.NORTH);
		lo = new LongitudeImpl(20, 20, 20, CompassDirection.EAST);
		poi = new PositionImpl(la, lo);
		vor = new VORImpl(name, poi);
		
	}
	
	@Test
	public void testVORImpl() {
		assertNotNull(vor);
    }
	
	@Test
    public void testdistanceTo() {
		LatitudeImpl la2 = new LatitudeImpl(10, 10, 10, CompassDirection.NORTH);
		LongitudeImpl lo2 = new LongitudeImpl(10, 10, 10, CompassDirection.EAST);
		PositionImpl poi2 = new PositionImpl(la2, lo2);
		
		VORImpl vor2 = new VORImpl("autre", poi2);
		
		double distance = (vor.getPosition()).distanceTo(vor2.getPosition());
		assertTrue(distance == vor.distanceTo(vor2));
	}
	
	@Test
    public void testGetName() {
		assertSame(vor.getName(), this.name);
    }
	
	@Test
    public void testGetPosition() {
		assertSame(vor.getPosition(), this.poi);
    }

}
