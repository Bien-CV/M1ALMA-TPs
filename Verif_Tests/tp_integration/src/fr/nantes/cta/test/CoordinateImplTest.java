package fr.nantes.cta.test;

import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.one.CoordinateImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoordinateImplTest {

	private CoordinateImpl ciPos, ciNeg;
	private double theta;
	
	@Before
	public void setUp() throws Exception {
		ciPos = new CoordinateImpl(90, 0, 0, CompassDirection.NORTH);
		ciNeg = new CoordinateImpl(90, 0, 0, CompassDirection.SOUTH);
		theta = 90 + (0 + 0 / 60.) / 60.;
	}
	
	@Test
	public void testCoordinateImpl() {
		assertNotNull(ciPos);
	}
	
	@Test
	public void testDirection() {
		assertSame(ciPos.direction(), CompassDirection.NORTH);
	}
	
	@Test
	public void testCos() {
		//2è cas a faire avec SOUTH
		assert ciPos.Cos()== Math.cos(Math.toRadians(theta));
	}
	
	@Test
	public void testDegreesPositif() {
		assertTrue(ciPos.Degrees() == 90.0);
	}
	
	@Test
	public void testDegreesNegatif() {
		assertTrue(ciNeg.Degrees() == -90.0);
	}
	
	@Test
	public void testRadians() {
		assert ciPos.Radians() == Math.toRadians(theta);
	}

	@Test
	public void testSin() {
		// 2cas avec SOUTH
		assert ciPos.Sin()== Math.sin(Math.toRadians(theta));
	}

}
