package fr.nantes.cta.test;

import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.CompassDirection;
import org.junit.Test;
import static org.junit.Assert.*;

public class LatitudeImplTest {

	private LatitudeImpl la;
	
	@Test
	public void testLatitudeImpl() {
		la = new LatitudeImpl(90, 0, 0, CompassDirection.NORTH);
		assertNotNull(la);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLatitudeImplWithWrongDirectionEAST() {
        la = new LatitudeImpl(90,0,0, CompassDirection.EAST);
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testLatitudeImplWithWrongDirectionWEST() {
        la = new LatitudeImpl(90,0,0, CompassDirection.WEST);
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testLatitudeImplWithWrongLowerDegree() {
        la = new LatitudeImpl(-1,0,0, CompassDirection.NORTH);
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testLatitudeImplWithWrongUpperDegree() {
        la = new LatitudeImpl(91,0,0, CompassDirection.SOUTH);
    }
}