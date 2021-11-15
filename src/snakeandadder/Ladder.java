package snakeandadder;

import java.util.*;

public class Ladder {

	private int start;
	private int end;
	private int climb;

	public Ladder(int start, int end) {
		this.start = start;
		this.end = end;
		this.climb = end - start;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getClimb() {
		return climb;
	}

}
