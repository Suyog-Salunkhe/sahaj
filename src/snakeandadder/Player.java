package snakeandadder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Player {

	private String name;
	private int position;
	private int turnSequence = 1;
	private int lastPosition;
	private boolean isLongest = false;

	private Integer biggestClimb;
	private Integer biggestSlide;
	private Integer luckyRolls = 0;
	private Integer unluckyRolls = 0;

	private Map<Integer, List<Integer>> longestTurnMap = new HashMap<>();

	public Player(String name) {
		this.name = name;
		this.position = 0;
		this.biggestClimb = 0;
		this.biggestSlide = 0;
	}

	public Player(int position) {
		this.position = position;

	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int incrementPosition(int add) {
		this.setPosition(this.getPosition() + add);
		return this.getPosition();
	}

	public Integer getBiggestClimb() {
		return biggestClimb;
	}

	public void setBiggestClimb(Integer biggestClimb) {
		this.biggestClimb = biggestClimb;
	}

	public Integer getBiggestSlide() {
		return biggestSlide;
	}

	public void setBiggestSlide(Integer biggestSlide) {
		this.biggestSlide = biggestSlide;
	}

	public Integer getLuckyRolls() {
		return luckyRolls;
	}

	public void setLuckyRolls() {
		this.luckyRolls++;
	}

	public Integer getUnluckyRolls() {
		return unluckyRolls;
	}

	public void setUnluckyRolls() {
		this.unluckyRolls++;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, List<Integer>> getLongestTurnMap() {
		return longestTurnMap;
	}

	public void setLongestTurnMap(Map<Integer, List<Integer>> longestTurnMap) {
		this.longestTurnMap = longestTurnMap;
	}

	public int getTurnSequence() {
		return turnSequence;
	}

	public void setTurnSequence() {
		this.turnSequence++;
	}

	public boolean isLongest() {
		return isLongest;
	}

	public void setLongest(boolean isLongest) {
		this.isLongest = isLongest;
	}

	public void setTurnSequence(int turnSequence) {
		this.turnSequence = turnSequence;
	}

	public int getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}

	public List<Integer> getLongestTurn() {

		int key = 0;
		int total = 0;
		for (Map.Entry<Integer, List<Integer>> turn : longestTurnMap.entrySet()) {
			int sum = turn.getValue().stream().mapToInt(value -> value).sum();
			if (sum > total) {
				total = sum;
				key = turn.getKey();
			}
		}
		return longestTurnMap.get(key);
	}

}
