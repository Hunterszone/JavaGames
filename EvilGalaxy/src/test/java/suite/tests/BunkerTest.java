package suite.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Bunker;

public class BunkerTest {

	private Bunker bunker;
	private int x, y;

	@Before
	public void setUp() throws Exception {
		bunker = new Bunker(x, y);
	}

	@Test
	public void testBunkerUnit() {
		assertNotNull(bunker.loadImage(bunker.drawBunker()));
		assertFalse(bunker.drawBunker().isEmpty());
	}

	@Test
	public void testBunkerUnitHit() {
		assertNotNull(bunker.loadImage(bunker.drawBunkerHit()));
		assertFalse(bunker.drawBunkerHit().isEmpty());
	}

	@Test
	public void testListsOfBullets() {
		assertFalse(bunker.loadBullet().isEmpty());
		assertFalse(bunker.loadBullet2().isEmpty());
	}

	@After
	public void tearDown() throws Exception {
		bunker = null;
	}
}