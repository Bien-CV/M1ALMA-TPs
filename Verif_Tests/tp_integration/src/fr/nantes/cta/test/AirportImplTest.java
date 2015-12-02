package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.one.AirportImpl;

public class AirportImplTest {
	
	private AirportImpl airport;

	@Before
	public void setUp() throws Exception {
		airport= new AirportImpl("Rossy");
	}
	
	@Test
	public void testAirportImpl() {
		assertNotNull(airport);
	}
	
	@Test
	public void testGetName() {
		assert airport.getName() == "Rossy";	
	}
}
