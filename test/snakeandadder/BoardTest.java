package snakeandadder;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BoardTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/resource/ladder.csv", numLinesToSkip = 1)
	public void testLadder(Integer start, Integer end) {
		assertTrue(start < end);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/resource/snakes.csv", numLinesToSkip = 1)
	public void testSnakes(Integer start, Integer end) {
		assertTrue(start > end);
	}
}
