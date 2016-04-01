package marsrover;

import location.Point;

public class MarsRover {

	final String direction;
	Point position;

	MarsRover(final Point position, final String direction) {
		this.position = position;
		this.direction = direction;
	}

	public void receiveCommands(String... commands) {

		for (final String command : commands) {
			if ("f".equals(command)) {
				if ("N".equals(direction)) {
					position = position.increaseY();
				}

				if ("S".equals(direction)) {
					position = position.decreaseY();
				}

				if ("E".equals(direction)) {
					position = position.increaseX();
				}

				if ("W".equals(direction)) {
					position = position.decreaseX();
				}
			}

			if ("b".equals(command)) {
				if ("N".equals(direction)) {
					position = position.decreaseY();
				}

				if ("S".equals(direction)) {
					position = position.increaseY();
				}

				if ("E".equals(direction)) {
					position = position.decreaseX();
				}

				if ("W".equals(direction)) {
					position = position.increaseX();
				}
			}
		}


	}

}
