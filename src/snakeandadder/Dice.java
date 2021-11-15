package snakeandadder;

import java.util.Random;

public class Dice {

	final static Random rand = new Random();
	final static int MIN = 1;
	final static int MAX = 6;

	public static int roll() {
		int randomNum = rand.nextInt((Dice.MAX - Dice.MIN) + 1) + Dice.MIN;
		return randomNum;
	}

}
