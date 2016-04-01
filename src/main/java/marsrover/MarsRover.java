package marsrover;

import static marsrover.Direction.*;

import location.Point;

public class MarsRover {

	Direction direction;
	Point position;

	MarsRover(final Point position, final Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public void receiveCommands(String... commands) {

		for (final String command : commands) {

			if ("f".equals(command)) {
				if (NORTH.equals(direction)) {
					position = position.increaseY();
				}

				if (SOUTH.equals(direction)) {
					position = position.decreaseY();
				}

				if (EAST.equals(direction)) {
					position = position.increaseX();
				}

				if (WEST.equals(direction)) {
					position = position.decreaseX();
				}
			}

			if ("b".equals(command)) {
				if (NORTH.equals(direction)) {
					position = position.decreaseY();
				}

				if (SOUTH.equals(direction)) {
					position = position.increaseY();
				}

				if (EAST.equals(direction)) {
					position = position.decreaseX();
				}

				if (WEST.equals(direction)) {
					position = position.increaseX();
				}
			}

			if ("l".equals(command)) {
				direction = direction.previous();
			}

			if ("r".equals(command)) {
				direction = direction.next();
			}


		}

	}

}
