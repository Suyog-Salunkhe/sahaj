package snakeandadder;

import java.util.ArrayList;
import java.util.List;

public class Snake {

	private int start;
	private int end;
	private int slide;
	
	public Snake(int start, int end) {
		this.start = start;
		this.end = end;
		this.slide = start - end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
	
	public int getSlide() {
		return slide;
	}

	public void setSlide(int slide) {
		this.slide = slide;
	}

}
