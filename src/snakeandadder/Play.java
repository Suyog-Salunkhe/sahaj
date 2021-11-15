package snakeandadder;

import java.util.ArrayList;
import java.util.List;

public class Play {

	private Board board;

	public Play(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return this.board;
	}

	public void move(Player player, int position) {

		int lastPosition = player.getPosition();
		int newPosition = player.getPosition() + position;

		if (newPosition + player.getPosition() == board.getSize()) {
			player.setLuckyRolls();
		}

		// find longest turn
		findLongestTurn(player, position);

		if (newPosition > this.getBoard().getSize()) {
			newPosition = lastPosition;
		} else {
			player.setPosition(newPosition);

			this.board.getLadders().stream().forEach(ladder -> {
				if (ladder.getStart() == player.getPosition() + position) {
					player.setPosition(ladder.getEnd());
					player.setLuckyRolls();
					if (player.getBiggestClimb() < ladder.getClimb()) {
						player.setBiggestClimb(ladder.getClimb());
					}
				}
			});

			this.board.getSnakes().stream().forEach(snake -> {
				if ((snake.getStart() + 1 == player.getPosition()) || (snake.getStart() + 2 == player.getPosition())) {
					player.setLuckyRolls();
				}
				if (snake.getStart() == player.getPosition() + position) {
					player.setPosition(snake.getEnd());
					player.setUnluckyRolls();
					if (player.getBiggestSlide() < snake.getSlide()) {
						player.setBiggestSlide(snake.getSlide());
					}
				}
			});
		}
	}

	public boolean isPlayerWon(Player player) {
		boolean won = false;
		if (player.getPosition() == getBoard().getSize()) {
			won = true;
		}
		return won;
	}

	public void startPlaying(Player player) {
		while (!isPlayerWon(player)) {
			int diceValue = Dice.roll();
			move(player, diceValue);

		}
	}

	public void findLongestTurn(Player player, int position) {
		if (player.isLongest() && player.getLastPosition() == 6) {
			player.getLongestTurnMap().get(player.getTurnSequence()).add(position);
			if (position != 6) {
				player.setLongest(false);
				player.setTurnSequence();
			}
			player.setLastPosition(position);

		} else {
			if (position == 6) {
				player.setLongest(true);
				if (player.getLongestTurnMap().containsKey(player.getTurnSequence())) {
					player.getLongestTurnMap().get(player.getTurnSequence()).add(position);
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(position);
					player.getLongestTurnMap().put(player.getTurnSequence(), list);
				}
				player.setLastPosition(position);
			}
		}
	}

}