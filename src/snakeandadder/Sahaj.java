package snakeandadder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sahaj {

	public static void main(String[] args) throws IOException {
		String resultRow = null;
		BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/suyog/Desktop/sahaj.csv"));
		String line;
		boolean isSnake = false;
		Board board = new Board();
		while ((line = bufferedReader.readLine()) != null) {
			List<String> list = Arrays.asList(line.split(","));
			if (list.contains("board_size")) {
				int boardSize = Integer.parseInt(list.get(1));
				board.setSize(boardSize);
				continue;
			}
			if (list.contains("snake_start")) {
				isSnake = true;
				continue;
			} else if (isSnake && !list.contains("ladder_start")) {
				board.addSnake(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)));
			} else if (list.contains("ladder_start")) {
				isSnake = false;
				continue;
			} else if (!isSnake) {
				board.addLadder(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)));
			}
		}

		Player player = new Player("Suyog");

		Play play = new Play(board);

		play.startPlaying(player);

		System.out.println(player.getPosition());
		System.out.println("Biggest climb in a game : " + player.getBiggestClimb());
		System.out.println("Biggest slide in a game: " +player.getBiggestSlide());

		System.out.println("Minimum dice rquired : " + board.getMinimumDiceThrow());
		System.out.println("Longest turn : " + player.getLongestTurn());

	}

}
