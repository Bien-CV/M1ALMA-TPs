package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import fr.nantes.cta.one.AirplaneImpl;

public class AirplaneImplTest {

	private AirplaneImpl plane;

	@Before
	public void setUp() throws Exception {
		plane = new AirplaneImpl(5000.00, 30, 80, 100);
	}
	
	@Test
	public void testAirplaneImpl() {
		plane = new AirplaneImpl(5000.00, 30, 80, 100);
		assertNotNull(plane);
	}

	@Test
	public void testGetAutonomy() {
		int autonomie = 80 * 100;
		assert plane.getAutonomy() == autonomie;
	}

	@Test
	public void testGetLoading() {
		assert plane.getLoading() == 30;
	}

	@Test
	public void testWeight() {
		assert plane.weight() == 5000;
	}

}
