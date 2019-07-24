package suite.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import gameDevelopment.EnemyEntity;
import gameDevelopment.Entity;
import gameDevelopment.Game;
import gameDevelopment.HealthEntity;
import gameDevelopment.MySprite;
import gameDevelopment.TreasureEntity;

public class HeroEntityTest {

	private MySprite hero, enemy, treasure, healthpack;
	private Entity enemyEntity, treasureEntity, healthpackEntity;
	private Rectangle heroRect, enemyRect, treasureRect, healthRect;
	private int x, y;

	@Before
	public void setUp() throws Exception {
		Display.create();
		hero = new MySprite(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/gunman.png")));
		enemy = new MySprite(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/bird.png")));
		treasure = new MySprite(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/chest.png")));
		healthpack = new MySprite(
				TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/health.png")));
		enemyEntity = new EnemyEntity(enemy, x, y);
		treasureEntity = new TreasureEntity(treasure, x, y);
		healthpackEntity = new HealthEntity(healthpack, x, y);
		heroRect = new Rectangle();
		enemyRect = new Rectangle();
		treasureRect = new Rectangle();
		healthRect = new Rectangle();
	}

	@Test
	public void testHeroEntity() {
		assertNotNull(Game.initHero(hero));
	}

	@Test
	public void testCollidesWithEnemy() {
		if (heroRect.intersects(enemyRect))
			assertTrue(Game.initHero(hero).collidesWith(enemyEntity));
	}

	@Test
	public void testCollidesWithTreasure() {
		if (heroRect.intersects(treasureRect))
			assertTrue(Game.initHero(hero).collidesWith(treasureEntity));
	}

	@Test
	public void testCollidesWithHealth() {
		if (heroRect.intersects(healthRect))
			assertTrue(Game.initHero(hero).collidesWith(healthpackEntity));
	}

	@Test
	public void testRemoveEnemy() {
		assertTrue(Game.initHero(hero).removedByHero(enemyEntity));
	}

	@Test
	public void testRemoveTreasure() {
		assertTrue(Game.initHero(hero).removedByHero(treasureEntity));
	}

	@Test
	public void testRemoveHealth() {
		assertTrue(Game.initHero(hero).removedByHero(healthpackEntity));
	}

	@After
	public void tearDown() throws Exception {
		Display.destroy();
	}
}