package fr.nantes.cta.test;

import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.CompassDirection;
import org.junit.Test;
import static org.junit.Assert.*;

public class LongitudeImplTest {

	private LongitudeImpl lo;
    
	@Test
	public void testLongitudeImpl() {
		lo = new LongitudeImpl(180, 0, 0, CompassDirection.EAST);
		assertNotNull(lo);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLongitudeImplWithWrongDirectionNORTH() {
        lo = new LongitudeImpl(180,0,0, CompassDirection.NORTH);
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testLongitudeImplWithWrongDirectionSOUTH() {
        lo = new LongitudeImpl(180,0,0, CompassDirection.SOUTH);
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testLongitudeImplWithWrongLowerDegree() {
        lo = new LongitudeImpl(-1,0,0, CompassDirection.EAST);
    }
	@Test(expected=IllegalArgumentException.class)
	public void testLongitudeImplWithWrongUpperDegree() {
        lo = new LongitudeImpl(181,0,0, CompassDirection.WEST);
    }

}
