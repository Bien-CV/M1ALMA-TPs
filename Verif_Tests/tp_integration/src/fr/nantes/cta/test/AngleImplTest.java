package fr.nantes.cta.test;

import fr.nantes.cta.one.AngleImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AngleImplTest {
	
	private AngleImpl ai;
	private double theta;
	
	@Before
	public void setUp() throws Exception {
		theta = 50 + (120 + 40 / 60.) / 60.;
		ai = new AngleImpl(50, 120, 40);
	}
	
	@Test
	public void testAngleImpl() {
		assertNotNull(ai);
	}

	

	@Test
    public void testCos(){
    	double res = Math.cos(Math.toRadians(theta));
    	assert ai.cos() == res;
    }
	
	@Test
	public void testdegrees() {
		assert ai.degrees() == theta;
	}
	
	@Test
	public void testRadians() {
		double res = Math.toRadians(theta);
		assert ai.radians() == res;
    }
	
	@Test
    public void testSin(){
		double res = Math.sin(Math.toRadians(theta));
    	assert ai.sin() == res;
    }
}
