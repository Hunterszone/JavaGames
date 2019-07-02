package suite.tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import items.ShipRocket;

public class ShipRocketTest {

	private ShipRocket shipRocket;
	private int x, y;

	@Before
	public void setUp() throws Exception {
		shipRocket = new ShipRocket(x, y);
	}

	@Test(timeout = 200)
	public void testShipMissileUnit() {
		assertNotNull(shipRocket.loadImage(shipRocket.initRocket()));
		assertNotEquals("", shipRocket.initRocket());
	}

	@After
	public void tearDown() throws Exception {
		shipRocket = null;
	}
}