package snakeandadder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceTest {

	@Test
	void testRoll() {

		for (int index = 0; index < 100; index++) {
			int roll = Dice.roll();
			assertTrue(roll >= 1 && roll <= 6);
		}
	}

}
